package co.unicauca.restaurante.servidor.app;

import co.unicauca.restaurante.servidor.infra.RestauranteServerSocket;

/**
 *
 * @author Camilo Gonzalez, Jhonny Rosero, Edynson Muñoz, James Silva, Jhonfer Ruiz
 */
public class AplicacionRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //se crea el socket
        RestauranteServerSocket server = new RestauranteServerSocket();
        //se inicia
        server.start();
    }
}
