/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.servidor.acceso;


import co.unicauca.restaurante.commons.domain.DiaEnum;
import co.unicauca.restaurante.commons.domain.Plato;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.commons.infra.Utilities;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * objeto concreto de un repositorio, en este caso un repositorio de mysql
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class RestauranteRepositorioMysql implements IPlatoRepositorio{
    /**
     * Conección con Mysql
     */
    private Connection conn;

    public RestauranteRepositorioMysql(){

    }
    /**
     * busca un plato especial en la base de datos.
     * @param id identificador del plato
     * @return true si encontro el plato, false de lo contrario
     */
    private boolean findPlatoEspecial(int id){
        boolean resultado;
        try{
            this.connect();
            String sql = "select pesp_nombre from platoespecial where PESP_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            resultado = rs.next();
            ps.close();
            this.disconnect();
            return resultado;
        }catch(SQLException ex){
            System.out.println("revento excepcion encontrar plato especial_:"+ex.getMessage());
            return false;
        }
    }
    /**
     * busca un plato del dia en la base de datos
     * @param id identificador del plato
     * @return true si lo encuentra, false de lo contrario.
     */
    private boolean findPlatoDia(int id){
        boolean resultado;
        try{
            this.connect();
            String sql = "select pdia_nombre from platodia where PDIA_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            resultado = rs.next();
            ps.close();
            this.disconnect();
            return resultado;
        }catch(SQLException ex){
            System.out.println("revento excepcion encontrar plato_:"+ex.getMessage());
            return false;
        }
    }
    /**
     * actualiza un item de plato del dia en la base de datos.
     * @param clave identificador del plato
     * @param atributo columna a modificar en la base de datos.
     * @param valor nuevo valor para la columna.
     * @return retorna "FALLO" si erra el metodo, identificador de lo contrario.
     */
    @Override
    public String updatePlatoDia(String clave, String atributo, String valor){
        if(!this.findPlatoDia(Integer.parseInt(clave))){
            return "FALLO";
        }
        try{
            this.connect();
            //String sql = "UPDATE platoespecial set "+atributo+" = "+valor+" WHERE PESP_NOMBRE = "+clave;
            String sql = "UPDATE platodia SET "+atributo+" = ? WHERE PDIA_ID = ?";
            System.out.println("SENTENCIA SQL UPDATE PLATO DIA: "+sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if(atributo.equals("PDIA_PRECIO")){
                int valorNum = Integer.parseInt(valor);
                pstmt.setInt(1, valorNum);
            }else{
                pstmt.setString(1, valor);
            }
            pstmt.setInt(2, Integer.parseInt(clave));
            
            pstmt.executeUpdate();
            
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return clave;
    }
    /**
     * actualiza un item plato especial en la base de datos
     * @param clave identificador del plato
     * @param atributo columna a modificarse en la base de datos.
     * @param valor nuevo valor para la celda
     * @return retorna "FALLO" si el metodo erra
     */
    @Override
    public String updatePlatoEspecial(String clave, String atributo, String valor){
        if(!this.findPlatoEspecial(Integer.parseInt(clave))){
            return "FALLO";
        }
        try{
            this.connect();
            String sql = "UPDATE platoespecial SET "+atributo+" = ? WHERE PESP_ID = ?";
            System.out.println("SENTENCIA SQL UPDATE PLATO ESPECIAL: "+sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if(atributo.equals("PESP_PRECIO")){
                int valorNum = Integer.parseInt(valor);
                pstmt.setInt(1, valorNum);
            }else{
                pstmt.setString(1, valor);
            }
            pstmt.setInt(2, Integer.parseInt(clave));
            
            pstmt.executeUpdate();
            
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return clave;
    }
    /**
     * cumunicacion con la base de datos para guardar un platodel dia
     * @param instancia un plato del dia que se desea registrar
     * @return 
     */
    @Override
    public String savePlatoDia(PlatoDia instancia) {
        try{
            if (findPlatoDia(instancia.getId()))
            {
                return "FALLO";
            }

            System.out.println("entro");

            //primero se establece la conexion
            this.connect(); 
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO platodia(PDIA_ID,MDIA_ID,PDIA_NOMBRE,PDIA_DESCRIPCION,PDIA_DIA,PDIA_ENTRADA,PDIA_PRINCIPIO,PDIA_BEBIDA,PDIA_CARNE,PDIA_PRECIO) VALUES (?,?,?,?,?,?,?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getId());
            pstmt.setInt(2, instancia.getMenuId());
            pstmt.setString(3, instancia.getNombre());
            pstmt.setString(4, instancia.getDescripcion());
            pstmt.setString(5, String.valueOf(instancia.getDiaSemana()));
            pstmt.setString(6, instancia.getEntrada());
            pstmt.setString(7, instancia.getPrincipio());
            pstmt.setString(8, instancia.getBebida());
            pstmt.setString(9, instancia.getCarne());
            pstmt.setInt(10, (int)instancia.getPrecio());
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
              
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            //return "FALLO";
        }
        return instancia.getNombre(); 
    }
    
    /**
     * cumunicacion con la base de datos para eliminar un plato del dia
     * @param idPlaD id del plato a eliminar
     * @return 
     */
    @Override
    public String deletePlatoDia(int idPlaD) {
        if(findPlatoDia(idPlaD)){
            System.out.println("EXISTE EL ELEMENTO");
        }else{
            System.out.println("NO EXISTE EL ELEMENTO");
            return "FALLO";
        }
        try{
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "DELETE FROM platodia WHERE pdia_id = (?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se compara el id, OJO Ddebe cumplir estrictamente el orden y el tipo de dato(de las tablas)
            pstmt.setInt(1,idPlaD);
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al eliminar el plato", ex);
        }
        return ""+idPlaD;
    }
    /**
     * cumunicacion con la base de datos para eliminar un plato del dia
     * @param idPlaE id plato que se desea eliminar
     * @return 
     */
    @Override
    public String deletePlatoEspecial(int idPlaE) {
        if(findPlatoEspecial(idPlaE)){
            System.out.println("EXISTE EL ELEMENTO");
        }else{
            System.out.println("NO EXISTE EL ELEMENTO");
            return "FALLO";
        }
        try{
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "DELETE FROM platoespecial WHERE pesp_id = (?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se compara el id, OJO Ddebe cumplir estrictamente el orden y el tipo de dato(de las tablas)
            pstmt.setInt(1,idPlaE);
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
  
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al eliminar el plato", ex);
        }
        return ""+idPlaE;
    }
    /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
     */
    public int connect() {
        try {
            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            //estos datos estan quemados en el archivo propertis, si la base de datos cambia propertis debe modificarse
            String url = Utilities.loadProperty("server.db.url");
            String username = Utilities.loadProperty("server.db.username"); //usuario de la base de datos
            String pwd = Utilities.loadProperty("server.db.password");//contraseña de usuario
            //se establece la coneccion con los datos previos
            conn = DriverManager.getConnection(url, username, pwd);
            if(conn == null){
                System.out.println("coneccion fallida a la base de datos");
            }else{
                System.out.println("conecion exitosa a la base de datos");
            }
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

    /**
     * 
     * @param instancia
     * @return 
     */
    @Override
    public String savePlatoEspecial(PlatoEspecial instancia) {
        try{
            if (findPlatoEspecial(instancia.getId()))
            {
                return "FALLO";
            }
            System.out.println("entro");
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO platoespecial(PESP_ID,MESP_ID,PESP_NOMBRE,PESP_DESCRIPCION,PESP_PRECIO) VALUES (?,?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getId());
            pstmt.setInt(2, instancia.getMenuEsp());
            pstmt.setString(3, instancia.getNombre());
            pstmt.setString(4, instancia.getDescripcion());
            pstmt.setInt(5, (int)instancia.getPrecio());
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        //lo ideal es retornor un id
        return instancia.getNombre();
    }
    
    /**
     * guarda un restaurante en la base de datos
     * @param res instancia a guardar
     * @return 
     */
    @Override
    public String saveRestaurante(Restaurante res) {
        System.out.println("ingreso a guardar");
        try{
            this.connect();
            String sql = "INSERT INTO restaurante(RES_ID,RES_NOMBRE) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, res.getId());
            pstmt.setString(2, res.getNombre());
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return res.getNombre();
    }
    /**
     * Lista el menu desde la consulta hecha a la base de datos 
     * añade las tuplas encontradas en una lista de Plato
     * y convierte la lista en json para enviarla por el sockect devuelta
     * al cliente
     * 
     * @param resId
     * @return 
     */
    @Override
    public String listarMenuDia(int resId) {
        List<Plato> list=new ArrayList<>();
        String response=null;
        System.out.println("ingreso al listar Menu Dia");
        try{
            this.connect();
            String sql = "select pdia_id,pdia_nombre,pdia_descripcion,pdia_dia, pdia_entrada,pdia_principio,pdia_carne,pdia_bebida,pdia_precio, m.mdia_id from (restaurante r inner join menudia m on r.res_id=m.res_id) inner join platodia p on m.mdia_id=p.mdia_id where r.res_id ="+resId;
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {      
                Plato pla=  new PlatoDia(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(9)), rs.getString(3), DiaEnum.valueOf(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), Integer.parseInt(rs.getString(10)));
                list.add(pla);
            }
            response=listToJson(list);
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del dia", ex);
        }
        return response;
    }
    
    /**
     * Lista el menu desde la consulta hecha a la base de datos 
     * añade las tuplas encontradas en una lista de Plato
     * y convierte la lista en json para enviarla por el sockect devuelta
     * al cliente
     * @param resId
     * @return 
     */
    @Override
    public String listarMenuEspecial(int resId) {
        List<Plato> list=new ArrayList<>();
        String response=null;
        System.out.println("ingreso al listar Menu Dia");
        try{
            this.connect();
            String sql = "select pesp_id,pesp_nombre,pesp_descripcion,pesp_precio,m.mesp_id from (restaurante r inner join menuespecial m on r.res_id=m.res_id) inner join platoespecial p on m.mesp_id=p.mesp_id where r.res_id = (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, resId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {   
                
                Plato pla = new PlatoEspecial(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(4)), rs.getString(3), Integer.parseInt(rs.getString(5)));
                list.add(pla);
            }
            response=listToJson(list);
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del especial", ex);
        }
       return response;
    }
    /**
     * Convierte una lista de tipo plato en un json
     * 
     * @param list
     * @return 
     */
    public String listToJson (List<Plato> list){
        Gson gson=new Gson();
        String response=gson.toJson(list);
        return response;
    }
}