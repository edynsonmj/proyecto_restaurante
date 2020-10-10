/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.servidor.acceso;

/**
 *fabrica que instacia un repositorio concreto, este repositorio accede a la base de datos
 * @author EdynsonMJ
 */
public class FabricaRepositorio {
    
    private static FabricaRepositorio instance;
    
    private FabricaRepositorio(){
    }
    /**
     * retorno solo una instancia de fabrica
     * singleton
     * @return instancia de FabricaRepositorio
     */
    public static FabricaRepositorio getInstance(){
        if(instance == null){
            instance = new FabricaRepositorio();
        }
        return instance;
    }
    /**
     * retorna un repositorio
     * @return instancia del repositorio
     */
    public IPlatoRepositorio getRepository(){
        IPlatoRepositorio repositorio = new RestauranteRepositorioMysql();
        //IPlatoRepositorio repositorio = new RestauranteRepositorioDeveloper();
        return repositorio;
    }
}