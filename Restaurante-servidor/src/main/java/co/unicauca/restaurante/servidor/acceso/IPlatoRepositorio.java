/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.servidor.acceso;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;

/**
 *interface del repositorio de platos, usarla mediante inyeccion de dependencias
 * @author EdynsonMJ
 */
public interface IPlatoRepositorio {
    /**
     * registrar una tupla en la base de datos
     * @param instancia objeto plato dia que se desea almacenar
     * @return 
     */
    public String savePlatoDia(PlatoDia instancia);
    /**
     * registra una tupla en la base de datos
     * @param plato objeto plato especial que se desea almacenar
     * @return 
     */
    public String savePlatoEspecial(PlatoEspecial plato);
    public String saveRestaurante(Restaurante res);

    /**
     * hace un update sobre la tabla platoEspecial
     * @param clave valor con el que se encuentra la tupla
     * @param atributo columna a modificar
     * @param valor nuevo valor
     * @return 
     */
    public String updatePlatoEspecial(String clave, String atributo, String valor);
    public String updatePlatoDia(String clave, String atributo, String valor);
    /*
     * elimina una tupla en la base de datos
     * @param idPlaD id plato  que e desea borrar
     * @return 
     */
    public String deletePlatoDia(int idPlaD);
    public String deletePlatoEspecial(int idPlaE);
    /**
     * lista todas las tuplas de los menus
     * @param resId id del restaurante del que se va a mostrar el menu
     * @return 
     */
    public String listarMenuDia(int resId); 
    public String listarMenuEspecial(int resId);
}