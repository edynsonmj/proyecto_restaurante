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
 */
public class RestauranteRepositorioMysql implements IPlatoRepositorio{
    /**
     * Conección con Mysql
     */
    private Connection conn;

    public RestauranteRepositorioMysql(){

    }
    /**
     * cumunicacion con la base de datos para guardar un platodel dia
     * @param instancia un plato del dia que se desea registrar
     * @return 
     */
    @Override
    public String savePlatoDia(PlatoDia instancia) {
        try{
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO platodia(nombre,precio,bebida,carne,entrada,principio) VALUES (?,?,?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato(de las tablas)
            pstmt.setString(1, instancia.getNombre());
            pstmt.setInt(2, (int)instancia.getPrecio());
            pstmt.setString(3, instancia.getBebida());
            pstmt.setString(4, instancia.getCarne());
            pstmt.setString(5, instancia.getEntrada());
            pstmt.setString(6, instancia.getPrincipio());
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
     * cumunicacion con la base de datos para eliminar un plato del dia
     * @param instancia un plato del dia que se desea eliminar
     * @return 
     */
    @Override
    public boolean deletePlatoDia(int idPlaD) {
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
        return true;
    }
    
    /**
     * cumunicacion con la base de datos para eliminar un plato del dia
     * @param idPlaE id plato especial que se desea eliminar
     * @return 
     */
    @Override
    public boolean deletePlatoEspecial(int idPlaE) {
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
        return true;
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
     * metodo que dara enviara la solicitud a la base de datos, similar a savePlatoDia
     * @param plato instancia de plato especial a guardar
     * @return 
     */
    @Override
    public String savePlatoEspecial(PlatoEspecial plato) {
        System.out.println("aun no implementado");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public String listarMenuDia(int resId) {
        List<Plato> list=new ArrayList<>();
        String response=null;
        System.out.println("ingreso al listar Menu Dia");
        try{
            this.connect();
            String sql = "select pdia_id,pdia_nombre,pdia_descripcion,pdia_entrada,pdia_principio,pdia_bebida,pdia_carne,pdia_precio from (restaurante r inner join menudia m on r.res_id=m.res_id) inner join platodia p on m.mdia_id=p.mdia_id where r.res_id ="+resId;
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {      
                Plato pla=new PlatoDia(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(8)), rs.getString(3), DiaEnum.Lunes, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(pla);
            }
            response=listToJson(list);
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del dia", ex);
        }
        return response;
    }

    @Override
    public String listarMenuEspecial(int resId) {
        List<Plato> list=new ArrayList<>();
        String response=null;
        System.out.println("ingreso al listar Menu Dia");
        try{
            this.connect();
            String sql = "select pesp_id,pesp_nombre,pesp_descripcion,pesp_precio from (restaurante r inner join menuespecial m on r.res_id=m.res_id) inner join platoespecial p on m.mesp_id=p.mesp_id where r.res_id = (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, resId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {            
                Plato pla=new PlatoEspecial(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4));
                list.add(pla);
            }
            response=listToJson(list);
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del dia", ex);
        }
       return response;
    }
    
    public String listToJson (List<Plato> list){
        Gson gson=new Gson();
        String response=gson.toJson(list);
        return response;
    }
}