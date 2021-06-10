package co.unicauca.restaurante.commons.domain;

/**
 *
 * @author Camilo Gonzalez, Jhonny Rosero, Edynson Muñoz, James Silva, Jhonfer Ruiz
 */
public class PlatoEspecial extends Plato{
    private int menuEsp;

    public PlatoEspecial(){};

    /**
     * contructor parametrizado para la creacion de un plato especial
     * @param id
     * @param descripcion descripcion que tendrta el plato
     * @param nombre nombre del plato
     * @param precio precio para la venta
     * @param menuEsp
     */
    public PlatoEspecial(int id, String nombre, double precio, String descripcion, int menuEsp) {
        super(id, nombre, precio, descripcion);
        this.menuEsp=menuEsp;
    }

    public int getMenuEsp() {
        return menuEsp;
    }

    public void setMenuEsp(int menuEsp) {
        this.menuEsp = menuEsp;
    }
}
