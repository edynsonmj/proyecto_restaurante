/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.access;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import java.util.List;

/**
 * entidad abstracta del los servicios que el cliente puede solicitar al servidor
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public interface IClienteAccess {
    //no confundirlos con guardar en la base de datos, estas son solicitudes al servidor
    //el servidor es quien trabaja la base de datos
    public String savePlatoDia(PlatoDia instancia) throws Exception;
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception;
    public String saveRestaurante(Restaurante res) throws Exception;

    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para plato especial
     * @param clave identificador del plato
     * @param atributo columna a ser modificada
     * @param valor nuevo valor a almacenar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updatePlatoEspecial(int clave, String atributo, String valor)throws Exception;
    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para plato del dia
     * @param clave identificador del plato
     * @param atributo columna a ser modificada
     * @param valor nuevo valor a almacenar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updatePlatoDia(int clave, String atributo, String valor)throws Exception;
    //actualizar
    //eliminar
    public String deletePlatoDia(int idPlaD) throws Exception;
    public String deletePlatoEspecial(int idPlaE) throws Exception;
    //modificar
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
