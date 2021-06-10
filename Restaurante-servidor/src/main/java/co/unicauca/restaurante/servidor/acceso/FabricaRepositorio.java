package co.unicauca.restaurante.servidor.acceso;

/**
 *fabrica que instacia un repositorio concreto, este repositorio accede a la base de datos
 * @author Camilo Gonzalez, Jhonny Rosero, Edynson Muñoz, James Silva, Jhonfer Ruiz
 */
public class FabricaRepositorio {
    private static FabricaRepositorio instance;
    
    private FabricaRepositorio(){}

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
        return repositorio;
    }
}
