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
public class Plato {
    /**
     * nombre del alimento
     */
    private String nombre;
    /**
     * precio del alimento
     */
    private double precio;

    public Plato() {
    }

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
