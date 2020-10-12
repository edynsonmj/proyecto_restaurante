/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.presentation;

import co.unicauca.restaurante.client.access.Factory;
import co.unicauca.restaurante.client.access.IClienteAccess;
import co.unicauca.restaurante.client.domain.clienteService;
import co.unicauca.restaurante.commons.domain.Plato;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import java.util.List;

/**
 * esta clase debe ejecutar las interfaces con lsa que interactua el cliente
 * @author EdynsonMJ
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //esto debe ser usado en un metodo, desplegado con las interfaz grafica, segun corresponda
        //este solo es el registro de un restaurante
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);
<<<<<<< HEAD
=======
        
>>>>>>> 8116ccf4c100a9c2deab7a532fc6fc116ebd1aeb
        /*
        Restaurante res = new Restaurante("primero",1);
        try{
            String resposse = servicioRestaurante.saveRestaurante(res);
            System.out.println("agregado restaurante con exito");
        }catch(Exception ex){
            System.out.println("atencion no se save si agrego restaurante");
        }*/
        /*
        List<PlatoDia> lista;
        int resId=1;
        try {
            lista=servicioRestaurante.listarMenuDia(resId);
            System.out.println("Lista menu dia con exito");
            for (PlatoDia lis : lista) {
                System.out.println("Nombre: "+lis.getNombre());
                System.out.println("Descripcion: "+lis.getDescripcion());
                System.out.println("Dia semana: "+lis.getDiaSemana().name());
                System.out.println("Precio: "+lis.getPrecio());
                System.out.println("Entrada: "+lis.getEntrada());
                System.out.println("Principio: "+lis.getPrincipio());
                System.out.println("Carne: "+lis.getCarne());
                System.out.println("Bebida: "+lis.getBebida());
            }
        } catch (Exception e) {
            System.out.println("No listo el menu dia");
        }*/
        
        int resId=2;
        List<PlatoEspecial> list;
        try {
            list=servicioRestaurante.listarMenuEspecial(resId);
            System.out.println("Lista menu  especial con exito");
            for (PlatoEspecial lis : list) {
                System.out.println("Nombre: " + lis.getNombre());
                System.out.println("Descripcion: " + lis.getDescripcion());
                System.out.println("Precio: " + lis.getPrecio());
            }
        }catch (Exception ex) {
            System.out.println("atencion no se listo Menu");
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
