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
    private String descripcion;
    /**
     * contructor parametrizado para la creacion de un plato especial
     * @param descripcion descripcion que tendrta el plato
     * @param nombre nombre del plato
     * @param precio precio para la venta
     */
    public PlatoEspecial(String descripcion, String nombre, double precio) {
        super(nombre, precio);
        this.descripcion = descripcion;
    }
    
}
