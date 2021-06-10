package co.unicauca.restaurante.commons.domain;

/**
 *
 * @author Camilo Gonzalez, Jhonny Rosero, Edynson Muñoz, James Silva, Jhonfer Ruiz
 */
public class PlatoDia extends Plato{
    private DiaEnum diaSemana;
    /**
     * una preparacion de tipo entrada
     */
    private String entrada;
    /**
     * una preparacion de tipo carne, pollo, res etc
     */
    private String carne;
    /**
     * una preparacion de tipo principio
     */
    private String principio;
    /**
     * una preparacion de tipo bebida
     */
    private String bebida;
    
    private int menuId;

    public PlatoDia() {}
    
    /**
     * constructor parametrizado para crear un plato
     * @param id
     * @param entrada
     * @param carne 
     * @param descripcion 
     * @param dia 
     * @param principio 
     * @param bebida
     * @param nombre el nombre que tendra el plato
     * @param precio el precio que tendra el plato
     * @param menuId el id del menu al que pertenece
     */
    public PlatoDia(int id, String nombre, double precio, String descripcion,DiaEnum dia,String entrada,String principio,String carne,String bebida,int menuId) {
        super(id, nombre, precio, descripcion);
        this.diaSemana=dia;
        this.entrada=entrada;
        this.principio=principio;
        this.carne=carne;
        this.bebida=bebida;
        this.menuId=menuId;
    }

    public DiaEnum getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaEnum diaSemana) {
        this.diaSemana = diaSemana;
    }
    
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getPrincipio() {
        return principio;
    }

    public void setPrincipio(String principio) {
        this.principio = principio;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId=menuId;
    }
}
