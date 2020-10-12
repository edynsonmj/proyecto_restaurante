/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        //inyeccion de dependencias par hacer la inyeccion
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
     * estpera platoD que el cliente se conecte y devuelve un socket
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
    //----------------SOLO MODIFICAR DESDE AQUI--------------------------------------
    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    private void processRequest(String requestJson) {
        // Convertir la solicitud platoD objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);
        Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.INFO, "procesar solicitud");
        //saca de request la persona que ha hecho la solicitud, en nuestro caso administrador o comprador
        switch (protocolRequest.getResource()) {
            case "administrador":
                Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "solicitud administrador recibida");
                //se berifica el tipo de solicitud y se llama al metodo responsable
                //post informacion para guardar
                //palabra clave post
                if (protocolRequest.getAction().equals("postPlatoDia")) {
                    // Agregar un elemento por parte de administrador  
                    administradorRegistrarPlatoDia(protocolRequest);

                }
                //funciona exactamente igual platoD postPlatoDia
                if(protocolRequest.getAction().equals("postPlatoEspecial")){
                    administradorRegistrarPlatoEspecial(protocolRequest);               
                }
                
                if(protocolRequest.getAction().equals("postRestaurante")){
                    this.clienteResgistrarRestaurante(protocolRequest);
                }
                break;
            //comprador solo tendra la opcion de visualizar, es decir un selec sobre la base de datos y enviarlos platoD cliente
            case "comprador":
                break;
                
        }
    }
        
    private void clienteResgistrarRestaurante(Protocol protocolRequest){
        Restaurante res = new Restaurante();
        res.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        res.setNombre(protocolRequest.getParameters().get(1).getValue());
        String response=null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.saveRestaurante(res);
        output.println(response);
    }
        /**
     * Procesa la solicitud de registrar implato dia que ha enviado el cliente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void administradorRegistrarPlatoDia(Protocol protocolRequest) {
        //crea la instancia
        PlatoDia platoD = new PlatoDia();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
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
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response=null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.savePlatoDia(platoD);
        output.println(response);
    }
    private void administradorRegistrarPlatoEspecial(Protocol protocolRequest) {
        //crea la instancia
        PlatoEspecial platoE = new PlatoEspecial();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        platoE.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        platoE.setMenuEsp(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        platoE.setNombre(protocolRequest.getParameters().get(2).getValue());
        platoE.setDescripcion(protocolRequest.getParameters().get(3).getValue());
        platoE.setPrecio(Double.parseDouble(protocolRequest.getParameters().get(4).getValue()));
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response=null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
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