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
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


/**
 *
 * @author EdynsonMJ
 * @author Jhonny Rosero
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
        protocol.addParameter("pdia_id", String.valueOf(instancia.getId()));
        protocol.addParameter("mdia_id", String.valueOf(instancia.getMenuId()));
        protocol.addParameter("nombre", instancia.getNombre());
        protocol.addParameter("descripcion", instancia.getDescripcion());
        protocol.addParameter("dia", String.valueOf(instancia.getDiaSemana()));
        protocol.addParameter("entrada", instancia.getEntrada());
        protocol.addParameter("principio", instancia.getPrincipio());
        protocol.addParameter("bebida", instancia.getBebida());
        protocol.addParameter("carne", instancia.getCarne());
        protocol.addParameter("precio", String.valueOf(instancia.getPrecio()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    /**
     * se hace practicamente lo mismo que savePlatoEspecial
     * FALTA IMPLEMENTAR
     * @param instancia
     * @return 
     * @throws java.lang.Exception 
     */
    @Override
    public String savePlatoEspecial(PlatoEspecial instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = crearPlatoEspecialJson(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return instancia.getNombre();

    }
    private String crearPlatoEspecialJson(PlatoEspecial instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postPlatoEspecial");
        protocol.addParameter("pesp_id", String.valueOf(instancia.getId()));
        protocol.addParameter("mesp_id", String.valueOf(instancia.getMenuEsp()));
        protocol.addParameter("nombre", instancia.getNombre());
        protocol.addParameter("descripcion", instancia.getDescripcion());
        protocol.addParameter("precio", String.valueOf(instancia.getPrecio()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    /**
     * envia la solicitud al servidor para eliminar un plato dia
     * @param idPlaD id del plato dia que se quiere eliminar
     * @return
     * @throws Exception
     */
    @Override
    public String deletePlatoDia(int idPlaD) throws Exception {
        String respJson = deletePlatoDiaJson(idPlaD);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+idPlaD;
    }
    /**
     * se crea el protocolo de comunicacion, en parameter van los datos del plato a borrar
     * OJO el orden debe ser exacto
     * @param idPlaD
     * @return
     * @throws Exception 
     */
    public String deletePlatoDiaJson(int idPlaD) throws Exception {
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("eliminarPlatoDia");
        protocol.addParameter("id", ""+idPlaD);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        
        return requestJson;
    }
    /**
     * envia la solicitud al servidor para eliminar un plato dia
     * @param idPlaE id del plato dia que se quiere eliminar
     * @return
     * @throws Exception
     */
    @Override
    public String deletePlatoEspecial(int idPlaE) throws Exception {
        String respJson = deletePlatoEspecialJson(idPlaE);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+idPlaE;
    }
    /**
     * se crea el protocolo de comunicacion, en parameter van los datos del plato a borrar
     * OJO el orden debe ser exacto
     * @param idPlaE
     * @return
     * @throws Exception 
     */
    public String deletePlatoEspecialJson(int idPlaE) throws Exception {
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("eliminarPlatoEspecial");
        protocol.addParameter("id", ""+idPlaE);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        
        return requestJson;
    }
    
    /**
     * Envia el id de un restaurante y devuelve la lista llegada desde el servidor 
     * el cual transforma el json recibido desde este
     * en una lista de PLlato dia que conforma un menu por dias
     * 
     * @param resId
     * @return
     * @throws Exception 
     */
    @Override
    public List<PlatoDia> listarMenuDia(int resId) throws Exception{
        String resource="administrador";
        String accion="listarMenuDia";
        String requestJson = createlistMenuJson(resource,accion,resId);
        String response=procesarConexion(requestJson);
        return jsonListarMenuDia(response);
    }
    
    /**
     * Envia el id de un restaurante y devuelve la lista llegada desde el servidor 
     * el cual transforma el json recibido desde este
     * en una lista de PlatoEspecial que conforma un menu especial
     * 
     * @param resId
     * @return
     * @throws Exception 
     */
    @Override
    public List<PlatoEspecial> listarMenuEspecial(int resId)throws Exception {
        String resource="administrador";
        String accion="listarMenuEspecial";
        String requestJson = createlistMenuJson(resource,accion,resId);
        String response= procesarConexion(requestJson);
        return jsonListarMenuEspecial(response);
    }
    
    /**
     * Crea el plato recibido en un json para el envio por el sockect al servidor
     * 
     * @param resource
     * @param accion
     * @param resId
     * @return 
     */
    private String createlistMenuJson(String resource,String accion,int resId){
        Protocol protocol=new Protocol();
        protocol.setResource(resource);
        protocol.setAction(accion);
        protocol.addParameter("resId", String.valueOf(resId));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    
    /**
     * Convierte un json en una lista de tipo plato dia
     * 
     * @param jsonListarMenu
     * @return 
     */
    private List<PlatoDia> jsonListarMenuDia(String jsonListarMenu){
        Gson gson=new Gson();
        Type list = new TypeToken<List<PlatoDia>>(){}.getType();
        return gson.fromJson(jsonListarMenu, list);
    }
    
    /**
     * Convierte un json en una lista de tipo plato especial
     * 
     * @param jsonListarMenu
     * @return 
     */
    private List<PlatoEspecial> jsonListarMenuEspecial(String jsonListarMenu){
        Gson gson=new Gson();
        Type list = new TypeToken<List<PlatoEspecial>>(){}.getType();
        return gson.fromJson(jsonListarMenu, list);
    }
}