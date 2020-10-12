/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.presentation;

import co.unicauca.restaurante.client.access.Factory;
import co.unicauca.restaurante.client.access.IClienteAccess;
import co.unicauca.restaurante.client.domain.clienteService;
import co.unicauca.restaurante.commons.domain.Restaurante;

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
        /*
        Restaurante res = new Restaurante("primero",1);
        try{
            String resposse = servicioRestaurante.saveRestaurante(res);
            System.out.println("agregado restaurante con exito");
        }catch(Exception ex){
            System.out.println("atencion no se save si agrego restaurante");
        }
        
        
        int idPlaD = 90;
        try{
            String resposse = ""+servicioRestaurante.deletePlatoDia(idPlaD);
            System.out.println("plato eliminado con exito");
        }catch(Exception ex){
            System.out.println("no se pudo eliminar el plato");
        }
        */
        int idPlaE = 340;
        try{
            String resposse = ""+servicioRestaurante.deletePlatoEspecial(idPlaE);
            System.out.println("plato eliminado con exito");
        }catch(Exception ex){
            System.out.println("no se pudo eliminar el plato");
        }

    }
}
