/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.servidor.acceso;
import co.unicauca.restaurante.commons.domain.Plato;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.commons.infra.Protocol;
import java.util.List;

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
<<<<<<< HEAD
    /**
     * elimina una tupla en la base de datos
     * @param idPlaD id plato dia que e deea borrar
     * @return 
     */
    public boolean deletePlatoDia(int idPlaD);
    
    public boolean deletePlatoEspecial(int idPlaE);
=======
    public String listarMenuDia(int resId); 
    public String listarMenuEspecial(int resId);
>>>>>>> 8116ccf4c100a9c2deab7a532fc6fc116ebd1aeb
}