/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.servidor.acceso;


import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private boolean findPlatoEspecial(int id){
        try{
            this.connect();
            String sql = "SELECT PESP_NOMBRE FROM platoespecial where PESP_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet res= ps.executeQuery();
            ps.close();
            this.disconnect();
            return res.first();
        }catch (Exception e){
            return false;
        }
    }
    private boolean findPlatoDia(int id){
        try{
            this.connect();
            String sql = "SELECT PDIA_NOMBRE FROM platodia where PDIA_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet res= ps.executeQuery();
            ps.close();
            this.disconnect();
            return res.first();
        }catch (Exception e){
            return false;
        }
    }
    @Override
    public String updatePlatoDia(String clave, String atributo, String valor){
        if(findPlatoDia(Integer.parseInt(clave))){
            System.out.println("EXISTE EL ELEMENTO");
        }else{
            System.out.println("SE CAGO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return "FALLO";
        }
        try{
            this.connect();
            //String sql = "UPDATE platoespecial set "+atributo+" = "+valor+" WHERE PESP_NOMBRE = "+clave;
            String sql = "UPDATE platodia SET "+atributo+" = ? WHERE PDIA_ID = ?";
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
    @Override
    public String updatePlatoEspecial(String clave, String atributo, String valor){
        if(findPlatoEspecial(Integer.parseInt(clave))){
            System.out.println("EXISTE EL ELEMENTO");
        }else{
            System.out.println("SE CAGO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return "FALLO";
        }
        try{
            this.connect();
            String sql = "UPDATE platoespecial SET "+atributo+" = ? WHERE PESP_ID = ?";
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
}