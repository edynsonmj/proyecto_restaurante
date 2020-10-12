/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.presentation;

import co.unicauca.restaurante.client.access.Factory;
import co.unicauca.restaurante.client.access.IClienteAccess;
import co.unicauca.restaurante.client.domain.clienteService;
import co.unicauca.restaurante.commons.domain.DiaEnum;
import co.unicauca.restaurante.commons.domain.MenuDia;
import co.unicauca.restaurante.commons.domain.MenuEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;


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
        Restaurante res = new Restaurante("primero",1);
        MenuDia menuDia = new MenuDia(11);
        MenuEspecial menuEspecial = new MenuEspecial(15);
        PlatoDia platoDia = new PlatoDia(444,"Corrientaso",7000,"",DiaEnum.Lunes,"Sancocho","Frijoles","Res Asado","Tomate",menuDia.getId());
        PlatoEspecial platoEspecial = new PlatoEspecial(4444,"Bandeja Paisa",14000,"PAISITA :3",menuEspecial.getId());
        try{
            String platoE = servicioRestaurante.savePlatoEspecial(platoEspecial);
            String paltoD = servicioRestaurante.savePlatoDia(platoDia);
            System.out.println("agregado restaurante con exito");
        }catch(Exception ex){
            System.out.println("atencion no se save si agrego restaurante");
        }
    }
}
