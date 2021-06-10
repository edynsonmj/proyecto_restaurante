package co.unicauca.restaurante.client.access;

import co.unicauca.restaurante.commons.infra.Utilities;

/**
 * fabrica que retorna una instancia para el acceso al servidor
 * @author Camilo Gonzalez, Jhonny Rosero, Edynson Muñoz, James Silva, Jhonfer Ruiz
 */
public class Factory {
    private static Factory instance;
    
    private Factory(){
        
    }

    public static Factory getInstance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }

    /**
     * crea una clase concreta de ClienteAccessSocket que realiza la comunicacion
     * @return 
     */
    public IClienteAccess getClienteService(){
        IClienteAccess result = null;
        String type = Utilities.loadProperty("customer.service");
        switch (type){
            case "default":
                result =new ClienteAccessSocket();
                break;
        }
        return result;
    }
}
