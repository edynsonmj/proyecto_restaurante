package co.unicauca.restaurante.servidor.infra;

import co.unicauca.restaurante.commons.domain.DiaEnum;
import co.unicauca.restaurante.commons.domain.Plato;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.commons.infra.JsonError;
import co.unicauca.restaurante.commons.infra.Protocol;
import co.unicauca.restaurante.commons.infra.Utilities;
import co.unicauca.restaurante.servidor.acceso.FabricaRepositorio;
import co.unicauca.restaurante.servidor.dominio.servidor.PlatoServicio;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.unicauca.restaurante.servidor.acceso.IPlatoRepositorio;

/**
 * esta clase se encarga de establecer y gestionar la conexion entre el servidor y los clientes
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class RestauranteServerSocket implements Runnable{
    /**
     * servicio del plato, continene el mecanismo para comunicar platoD la base de datos y sus operaciones
     */
    private final PlatoServicio service; //se debe iniciializar obligatorioamente

    /**
     * servicio para el socket, "orejita"
     */
    private static ServerSocket ssock;

    /**
     * socket por donde se hace la peticion/respuesta
     */
    private static Socket socket;

    /**
     * permite leer un flujo de datos del socket
     */
    private Scanner input;

    /**
     * permite escibir un flujo de datos en el socket
     */
    private PrintStream output;

    /**
     * Puerto por donde se escucha el server socket
     */
    private static final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
    
    /**
     * constructor obtiene el servidor mediante la fabrica
 instancia platoD servicio pasando el repositorio obtenido
     */
    public RestauranteServerSocket(){
        IPlatoRepositorio repository = FabricaRepositorio.getInstance().getRepository();
        service = new PlatoServicio(repository);
    }

    /**
     * instancia el server socket y abre el puerto respectivo
     */
    private static void openPort(){
        try{
            ssock = new ServerSocket(PORT);
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        }catch(IOException ex){
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Error del server socket al abrir el puerto", ex);
        }
    }

    /**
     * espera platoD que el cliente se conecte y devuelve un socket
     */
    private static void waitToClient(){
        try{
            //en este punto el socket espera platoD que accept reciba una conexion
            socket = ssock.accept();
            //informara si hubo conexion
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        }catch (IOException ex) {
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Eror al abrir un socket", ex);
        }
    }
    
    /**
     * lanza el hilo, un hilo individual atendera platoD el cliente
     */
    private static void  throwThread(){
        new Thread(new RestauranteServerSocket()).start();
    }

    /**
     * arranca el servidor y hace la estructura completa
     */
    public void start(){
        openPort();
        while(true){
            waitToClient();
            throwThread();
        }
    }
    
    /**
     * hilo que atiende platoD un cliente
     */
    @Override
    public void run() {
        try{
            //crea el flujo de datos, inicializa input y output, entrada y salida de datos
            createStreams();
            //crea el flujo de datos para la lectura del socket
            readStream();
            //cierra flujo
            closeStream();
        }catch (IOException ex){
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Eror al leer el flujo", ex);
        }
    }

    /**
     * crea o inicializa los atributos encargados de leer y escribir, flujos con el socket
     * @throws IOException 
     */
    private void createStreams() throws IOException{
        output = new PrintStream(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());
    }

    /**
     * lee el flujo del socket
     */
    private void readStream(){
        if(input.hasNextLine()){//verifica si hay contenido en el flujo de entrada
            String request = input.nextLine();
            processRequest(request);
        }else{
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    private void processRequest(String requestJson) {
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);
        switch (protocolRequest.getResource()) {
            case "administrador":
                if (protocolRequest.getAction().equals("postPlatoDia")) {
                    administradorRegistrarPlatoDia(protocolRequest);
                }
                
                if(protocolRequest.getAction().equals("postPlatoEspecial")){
                    administradorRegistrarPlatoEspecial(protocolRequest);               
                }
                
                if(protocolRequest.getAction().equals("postRestaurante")){
                    this.clienteResgistrarRestaurante(protocolRequest);
                }

                if(protocolRequest.getAction().equals("updateEspecial")){
                    administradorUpdateEspecial(protocolRequest);
                }
                
                if(protocolRequest.getAction().equals("updatePlatoDia")){
                    administradorUpdatePlatoDia(protocolRequest);
                }

                if(protocolRequest.getAction().equals("eliminarPlatoDia")){
                    this.administradorEliminarPlatoDia(protocolRequest);
                }

                if(protocolRequest.getAction().equals("eliminarPlatoEspecial")){
                    this.administradorEliminarPlatoEspecial(protocolRequest);
                }

                if (protocolRequest.getAction().equals("listarMenuDia")) {
                    this.listarMenuDia(protocolRequest);
                }

                if (protocolRequest.getAction().equals("listarMenuEspecial")) {
                    this.listarMenuEspecial(protocolRequest);
                }
                break;
            case "comprador":
                Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.INFO.SEVERE, "solicitud comprador recibida");
                if (protocolRequest.getAction().equals("listarMenuDia")) {
                    this.listarMenuDia(protocolRequest);
                }
                if (protocolRequest.getAction().equals("listarMenuEspecial")) {
                    this.listarMenuEspecial(protocolRequest);
                }
                break;
            }
    }

    /**
     * recibe un protocolo con la informacion necesarioa para modificar el plato del dia en la base de datos.
     * @param protocol protocolo en formato Json
     */
    private void administradorUpdatePlatoDia(Protocol protocol){
        String clave = protocol.getParameters().get(0).getValue();
        String atributo = protocol.getParameters().get(1).getValue();
        String valor = protocol.getParameters().get(2).getValue();
        String response = null;
        response = service.updatePlatoDia(clave, atributo, valor);
        output.println(response);
        Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "response: "+response+" clave:"+clave+" atributo:"+atributo+" valor: "+valor);
    }

    /**
     * recibe un protocolo con la informacion necesarioa para modificar el plato especial en la base de datos.
     * @param protocol 
     */
    private void administradorUpdateEspecial(Protocol protocol){
        String clave = protocol.getParameters().get(0).getValue();
        String atributo = protocol.getParameters().get(1).getValue();
        String valor = protocol.getParameters().get(2).getValue();
        String response = null;
        response = service.updatePlatoEspecial(clave, atributo, valor);
        output.println(response);
        Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "response: "+response+" clave:"+clave+" atributo:"+atributo+" valor: "+valor);
    }

    /**
     * Recibe la peticion del cliente, manda el id del restaurante
     * y manda esta peticion procesada al repositorio del servidor
     * para el menu por dias
     * 
     * @param protocolRequest 
     */
    private void listarMenuDia(Protocol protocolRequest){
        int resId =Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String response;
        response=service.listarMenuDia(resId);
        output.println(response);
    }

    /**
     * Recibe la peticion del cliente, manda el id del restaurante
     * y manda esta peticion procesada al repositorio del servidor
     * para el menu especial
     * 
     * @param protocolRequest 
     */
    private void listarMenuEspecial(Protocol protocolRequest){
        int resdId=Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String response;
        response=service.listarMenuEspecial(resdId);
        output.println(response);
    }
    
    private void clienteResgistrarRestaurante(Protocol protocolRequest){
        Restaurante res = new Restaurante();
        res.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        res.setNombre(protocolRequest.getParameters().get(1).getValue());
        String response=null;
        response = service.saveRestaurante(res);
        output.println(response);
    }

    /**
     * Procesa la solicitud de eliminar el plato dia que ha enviado el cliente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void administradorEliminarPlatoDia(Protocol protocolRequest){
        int idPlaD;
        idPlaD = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String response=null;
        response = service.deletePlatoDia(idPlaD);
        output.println(response);
    }

    /**
     * Procesa la solicitud de eliminar el plato especial que ha enviado el cliente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void administradorEliminarPlatoEspecial(Protocol protocolRequest){
        int idPlaE;
        idPlaE = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String response=null;
        response = service.deletePlatoEspecial(idPlaE);
        output.println(response);
    }

    /**
     * Procesa la solicitud de registrar un plato del dia que ha enviado el cliente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void administradorRegistrarPlatoDia(Protocol protocolRequest) {
        PlatoDia platoD = new PlatoDia();
        platoD.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        platoD.setMenuId(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        platoD.setNombre(protocolRequest.getParameters().get(2).getValue());
        platoD.setDescripcion(protocolRequest.getParameters().get(3).getValue());
        platoD.setDiaSemana(DiaEnum.valueOf(protocolRequest.getParameters().get(4).getValue()));
        platoD.setEntrada(protocolRequest.getParameters().get(5).getValue());
        platoD.setPrincipio(protocolRequest.getParameters().get(6).getValue());
        platoD.setBebida(protocolRequest.getParameters().get(7).getValue());
        platoD.setCarne(protocolRequest.getParameters().get(8).getValue());
        platoD.setPrecio(Double.parseDouble(protocolRequest.getParameters().get(9).getValue()));
        String response=null;
        response = service.savePlatoDia(platoD);
        output.println(response);
    }

    /**
     * Procesa la solicitud de registrar un plato Especial que ha enviado el cliente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void administradorRegistrarPlatoEspecial(Protocol protocolRequest) {
        PlatoEspecial platoE = new PlatoEspecial();
        platoE.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        platoE.setMenuEsp(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        platoE.setNombre(protocolRequest.getParameters().get(2).getValue());
        platoE.setDescripcion(protocolRequest.getParameters().get(3).getValue());
        platoE.setPrecio(Double.parseDouble(protocolRequest.getParameters().get(4).getValue()));
        String response=null;
        response = service.savePlatoEspecial(platoE);
        output.println(response);
    }

    /**
     * Genera un ErrorJson genérico
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);
        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);
        return errorJson;
    }

    /**
     * Genera un ErrorJson de cliente no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Cliente no encontrado. Cédula no existe");
        errors.add(error);
        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);
        return errorsJson;
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        socket.close();
    }

    /**
     * Convierte el objeto Customer platoD json para que el servidor lo envie como
 respuesta por el socket
     * @param customer cliente
     * @return customer en formato json
     */
    private String objectToJSONAlimento(Plato customer) {
        Gson gson = new Gson();
        String strObject = gson.toJson(customer);
        return strObject;
    }
}
