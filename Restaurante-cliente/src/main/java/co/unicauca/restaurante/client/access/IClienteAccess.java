/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.access;
import co.unicauca.restaurante.commons.domain.Plato;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import java.util.List;

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
    public String updatePlatoEspecial(int clave, String atributo, String valor)throws Exception;
    public String updatePlatoDia(int clave, String atributo, String valor)throws Exception;
    //eliminar
    public boolean deletePlatoDia(int idPlaD) throws Exception;
    public boolean deletePlatoEspecial(int idPlaE) throws Exception;
    //modificar
    //listar
    
    /**
     * Lista los menus por tipo y recibe por parametro el id del restaurante
     * 
     * @param resId
     * @return
     * @throws Exception 
     */
    public List<PlatoDia> listarMenuDia(int resId)throws Exception;
    public List<PlatoEspecial> listarMenuEspecial(int resId)throws Exception;
}
