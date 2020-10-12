/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.servidor.dominio.servidor;

import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.servidor.acceso.IPlatoRepositorio;

/**
 *comunicacion con la capa de bajo nivel
 * metodos contra la base de datos
 * @author EdynsonMJ
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
        //hacer validaciones aqui OJO aqui no se han hecho pero deben hacerse
        //comprobar que los datos enviados sean correctos y en caso de ids que no esten repetidos
        return repositorio.savePlatoDia(plato);
    }
    /**
     * envia la solicitud a la capa de bajo nivel para guardar un plato especial
     * @param plato instancia de plato especial a guardar
     * @return 
     */
    public String savePlatoEspecial(PlatoEspecial plato){
        //hacer validaciones aqui
        return repositorio.savePlatoEspecial(plato);
    }
    
    public String saveRestaurante(Restaurante res){
        return repositorio.saveRestaurante(res);
    }
    
    public boolean deletePlatoDia(int idPlaD){
        //hacer validaciones aqui OJO aqui no se han hecho pero deben hacerse
        //comprobar que los datos enviados sean correctos y en caso de ids que no esten repetidos
        return repositorio.deletePlatoDia(idPlaD);
    }
    
    public boolean deletePlatoEspecial(int idPlaE){
        //hacer validaciones aqui OJO aqui no se han hecho pero deben hacerse
        //comprobar que los datos enviados sean correctos y en caso de ids que no esten repetidos
        return repositorio.deletePlatoEspecial(idPlaE);
    }
}
