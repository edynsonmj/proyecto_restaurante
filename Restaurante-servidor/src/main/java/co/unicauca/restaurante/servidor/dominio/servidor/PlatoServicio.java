package co.unicauca.restaurante.servidor.dominio.servidor;

import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.servidor.acceso.IPlatoRepositorio;

/**
 *comunicacion con la capa de bajo nivel
 * metodos contra la base de datos
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class PlatoServicio {
    /**
     * repositorio de platos, via de comunicacion a bajo nivel
     */
    IPlatoRepositorio repositorio;

    /**
    * constructor parametrizado que hace inyeccion de dependencias
    * @param repositorio repositorio a la base de datos, tipo IPlatoRepositorio
    */
    public PlatoServicio(IPlatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    
    /**
     * envia la solicitud a la capa de bajo nivel para guardar un plato del dia en la base de datos
     * @param plato instancia a guardar
     * @return 
     */
    public String savePlatoDia(PlatoDia plato){
        return repositorio.savePlatoDia(plato);
    }

    /**
     * envia la solicitud a la capa de bajo nivel para guardar un plato especial en la base de datos
     * @param plato instancia de plato especial a guardar
     * @return 
     */
    public String savePlatoEspecial(PlatoEspecial plato){
        return repositorio.savePlatoEspecial(plato);
    }

    public String saveRestaurante(Restaurante res){
        return repositorio.saveRestaurante(res);
    }

    /**
     * modifica un plato especial en la base de datos
     * @param clave identificador del plato
     * @param atributo columna de la base de datos a modificar
     * @param valor nuevo valor de la celda
     * @return retorna "FALLO" en caso en caso de errar
     */
    public String updatePlatoEspecial(String clave, String atributo, String valor){
        return repositorio.updatePlatoEspecial(clave, atributo, valor);
    }

    /**
     * modifica un plato del dia en la base de datos
     * @param clave identificador del plato
     * @param atributo columna de la base de datos a modificar
     * @param valor nuevo valor para la celda
     * @return retorno "FALLO" en caso de error
     */
    public String updatePlatoDia(String clave, String atributo, String valor){
        return repositorio.updatePlatoDia(clave, atributo, valor);
    }

    /**
     * envia la solicitud a la capa de bajo nivel para eliminar un plato dia
     * @param idPlaD instancia de plato especial a guardar
     * @return 
     */
    public String deletePlatoDia(int idPlaD){
        return repositorio.deletePlatoDia(idPlaD);
    }

    /**
     * envia la solicitud a la capa de bajo nivel para eliminar un plato especial
     * @param idPlaE instancia de plato especial a guardar
     * @return 
     */
    public String deletePlatoEspecial(int idPlaE){
        return repositorio.deletePlatoEspecial(idPlaE);
    }

    public String listarMenuDia(int resId){
        return repositorio.listarMenuDia(resId);
    }

    public String listarMenuEspecial(int resId){
        return repositorio.listarMenuEspecial(resId);
    }
}
