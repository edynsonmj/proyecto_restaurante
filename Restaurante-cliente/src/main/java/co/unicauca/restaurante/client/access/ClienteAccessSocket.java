/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.access;
import co.unicauca.restaurante.client.infra.RestauranteSocket;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.commons.infra.JsonError;
import co.unicauca.restaurante.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;


/**
 *
 * @author EdynsonMJ
 */
public class ClienteAccessSocket implements IClienteAccess{
    /**
     * uso de un socket para comunicarse con el servidor
     */
    private RestauranteSocket mySocket;

    //el costructor crea el socket para poder comunicarse con el servidor
    public ClienteAccessSocket() {
        mySocket = new RestauranteSocket();
    }
    
    /**
     * envia la solicitud al servidor para guardar un restaurante
     * @param res la instancia a guardar
     * @return (hacer validacion con el retorno)
     * @throws Exception 
     */
    @Override
    public String saveRestaurante(Restaurante res) throws Exception{
        
        String requestJson = crearRestauranteJson(res);
        if((this.procesarConexion(requestJson)).equals("FALLO")){
            return null;
        }
        return res.getNombre();
    }
    
    /**
     * establece la conexion con el servidor para una solicitud que se pasa por parametro
     * @param requestJson solicitud al servidor
     * @return verdadero si la solicitud es exitosa, false de lo contrario
     * @throws Exception 
     */
    private String procesarConexion(String requestJson)throws Exception{
        String jsonResponse = null;
        try{
            //se establece la conexion
            mySocket.connect();
            //se envia la solicitud y se recibe una respuesta,
            //(CREO)AQUI VALIDAR SI SE DIO CON EXITO LA OPERACION, SEGUN LA REPUESTA DEL SERVIDOR
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
	    if(jsonResponse.equals("FALLO")){
                return "FALLO";
            }else{
                System.out.println("todo normal");
            }
        }catch(IOException ex){
            ex.getMessage();
        }
        if(jsonResponse == null){
            throw new Exception("no se pudo conectar al servidor");
        }else{
            if (jsonResponse.contains("error")) {
                //Devolvió algún erroR, usar mejor login
                System.out.println("hubo algun tipo de error");
                throw new Exception(this.extractMessages(jsonResponse));
            } else {
                //Devuelve la respuesta del servidor
                return jsonResponse;
            }
        }
    }
    
    /**
     * crea el plotocolo en formato yeison de la informacion que se desea enviar
     * @param instancia 
     * @return 
     */
    private String crearRestauranteJson(Restaurante instancia){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("postRestaurante");
        protocol.addParameter("res_id", String.valueOf(instancia.getId()));
        //protocol.addParameter("res_id", ""+instancia.getId());
        protocol.addParameter("nombre", instancia.getNombre());
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    
    /**
     *envia la solicitud al servidor para guardar un plato del dia
     * @param instancia una instancia de plato
     * @return devualve el nombre
     * @throws Exception
     */
    @Override
    public String savePlatoDia(PlatoDia instancia) throws Exception{
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = crearPlatoDiaJson(instancia);
        if((this.procesarConexion(requestJson)).equals("FALLO")){
            return null;
        }
        return instancia.getNombre();
    }
    @Override
    public String updatePlatoDia(int clave, String atributo, String valor) throws Exception{
        String requestJson = updatePlatoDiaJson(clave, atributo, valor);
        if((this.procesarConexion(requestJson)).equals("FALLO")){
            return null;
        }
        return atributo;
    }
    
    public String updatePlatoDiaJson(int clave, String atributo, String valor){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updatePlatoDia");
        protocol.addParameter("clave", ""+clave);
        protocol.addParameter("atributo", atributo);
        protocol.addParameter("valor", valor);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json enviado: "+requestJson);
        return requestJson;
    }
    /**
     * hace un update sobre la tabla menu especial en la base de datos
     * @param clave valor con el que se encontraran coincidencias, en este caso el nombre
     * @param atributo columna que se va a modificar
     * @param valor nuevo valor a establecer
     * @return 
     */
    @Override
    public String updatePlatoEspecial(int clave, String atributo, String valor) throws Exception{
        //estring en formato json que se enviara al servidor
        String requestJson = updateEspecialJson(clave, atributo, valor);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return atributo;
    }
    /**
     * genera el string en el formato json para ser enviado
     * @param clave 
     * @param atributo
     * @param valor
     * @return 
     */
    private String updateEspecialJson(int clave, String atributo, String valor){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updateEspecial");
        protocol.addParameter("clave", ""+clave);
        protocol.addParameter("atributo", atributo);
        protocol.addParameter("valor", valor);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json enviado: "+requestJson);
        return requestJson;
    }
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }
    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }
    /**
     * se crea el protocolo de comunicacion, en parameter van los atributos a guardar
     * OJO el orden debe ser exacto
     * @param instancia plato al que se el enviara la informacion
     * @return 
     */
    private String crearPlatoDiaJson(PlatoDia instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postPlatoDia");
        protocol.addParameter("nombre", instancia.getNombre());
        protocol.addParameter("precio", String.valueOf(instancia.getPrecio()));
        protocol.addParameter("bebida", instancia.getBebida());
        protocol.addParameter("carne", instancia.getCarne());
        protocol.addParameter("entrada", instancia.getEntrada());
        protocol.addParameter("principio", instancia.getPrincipio());
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }

    /**
     * se hace practicamente lo mismo que savePlatoEspecial
     * FALTA IMPLEMENTAR
     * @param plato
     * @return 
     */
    @Override
    public String savePlatoEspecial(PlatoEspecial plato) {
        System.out.println("aun no implementado");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //VERIFICAR el uso de este metodo para los platos.
      /**
     * Convierte jsonCustomer, proveniente del server socket, de json a un
     * objeto Customer
     *
     * @param jsonCustomer objeto cliente en formato json
     */
    /*private Customer jsonToCustomer(String jsonCustomer) {

        Gson gson = new Gson();
        Customer customer = gson.fromJson(jsonCustomer, Customer.class);

        return customer;

    }*/
}