/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.presentation;

import co.unicauca.restaurante.client.access.Factory;
import co.unicauca.restaurante.client.access.IClienteAccess;
import co.unicauca.restaurante.client.domain.clienteService;

/**
 * esta clase debe ejecutar las interfaces con lsa que interactua el cliente
 * @author EdynsonMJ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //esto debe ser usado en un metodo, desplegado con las interfaz grafica, segun corresponda
        //este solo es el registro de un restaurante
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);
    }
}
