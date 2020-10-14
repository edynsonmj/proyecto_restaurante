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
import java.util.List;

/**
 * servicios que el cliente puede usar del servidor (mascaras)
 * se comunica con la capa de bajo nivel que envia la solicitud
 * @author EdynsonMJ
 * @author Jhonny Rosero
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
        return service.savePlatoDia(plato); //fklsjdklfjslkdj
    }
    public String saveRestaurante(Restaurante res) throws Exception{
        return service.saveRestaurante(res);
    }
    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para plato especial
     * @param clave identificador del plato
     * @param atributo columna a ser modificada
     * @param valor nuevo valor a almacenar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updatePlatoEspecial(int clave, String atributo, String valor) throws Exception{
        //validaciones
        return service.updatePlatoEspecial(clave, atributo, valor);
    }
    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para plato dia
     * @param clave identificador del plato
     * @param atributo columna a ser modificada
     * @param valor nuevo valor a almacenar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updatePlatoDia(int clave, String atributo, String valor) throws Exception{
        //validaciones
        return service.updatePlatoDia(clave, atributo, valor);
    }
    
    public List<PlatoDia> listarMenuDia(int resId)throws Exception{
        return service.listarMenuDia(resId);
    }
    public List<PlatoEspecial> listarMenuEspecial(int resId) throws Exception{
        return service.listarMenuEspecial(resId);
    }
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception{
        return service.savePlatoEspecial(plato);
    }
    
    //aqui los otros servicios, eliminar, modificar listar etc

    public String deletePlatoDia(int idPlaD) throws Exception{
        return service.deletePlatoDia(idPlaD);
    }
    public String deletePlatoEspecial(int idPlaE) throws Exception{
        return service.deletePlatoEspecial(idPlaE);
    }
}
