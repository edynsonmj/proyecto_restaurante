/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.access;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;

/**
 * entidad abstracta del los servicios que el cliente puede solicitar al servidor
 * @author EdynsonMJ
 */
public interface IClienteAccess {
    //no confundirlos con guardar en la base de datos, estas son solicitudes al servidor
    //el servidor es quien trabaja la base de datos
    public String savePlatoDia(PlatoDia instancia) throws Exception;
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception;
    public String saveRestaurante(Restaurante res) throws Exception;
    //eliminar
    public boolean deletePlatoDia(int idPlaD) throws Exception;
    public boolean deletePlatoEspecial(int idPlaE) throws Exception;
    //modificar
    //listar
}
