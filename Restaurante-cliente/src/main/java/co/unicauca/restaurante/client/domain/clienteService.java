/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.domain;

import co.unicauca.restaurante.client.access.IClienteAccess;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;

/**
 * servicios que el cliente puede usar del servidor (mascaras)
 * se comunica con la capa de bajo nivel que envia la solicitud
 * @author EdynsonMJ
 */
public class clienteService {
    private final IClienteAccess service;
    /**
     * inyeccion de dependencias
     * @param service un clase concreta que implementa la interfaz de acceso, se instancia con una fabrica
     */
    public clienteService(IClienteAccess service) {
        this.service = service;
    }
    /**
     * mascara para guardar un platodeldia, la solicitud se envia al acceso
     * @param plato instancia concreta a enviar su informacion
     * @return
     * @throws Exception 
     */
    public String savePlatoDia(PlatoDia plato) throws Exception{
        return service.savePlatoDia(plato);
    }
    public String saveRestaurante(Restaurante res) throws Exception{
        return service.saveRestaurante(res);
    }
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception{
        return service.savePlatoEspecial(plato);
    }
    //aqui los otros servicios, eliminar, modificar listar etc
}
