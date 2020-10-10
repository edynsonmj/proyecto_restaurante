/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.servidor.app;

import co.unicauca.restaurante.servidor.infra.RestauranteServerSocket;

/**
 *
 * @author EdynsonMJ
 */
public class AplicacionRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //EL SERVIDOR NO REQUIERE DE INTERFAZ, ESTO PUEDE QUEDAR ASI
        //se crea el socket
        RestauranteServerSocket server = new RestauranteServerSocket();
        //se inicia
        server.start();
    }
    
}
