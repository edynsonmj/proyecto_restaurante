/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.commons.domain;

/**
 *
 * @author EdynsonMJ
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
