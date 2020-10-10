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
public class PlatoDia extends Plato{
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

    /**
     * constructor parametrizado para crear un plato
     * @param entrada
     * @param carne 
     * @param principio 
     * @param bebida
     * @param nombre el nombre que tendra el plato
     * @param precio el precio que tendra el plato
     */
    public PlatoDia(String entrada, String carne, String principio, String bebida, String nombre, double precio) {
        super(nombre, precio);
        this.entrada = entrada;
        this.carne = carne;
        this.principio = principio;
        this.bebida = bebida;
    }
    
    public PlatoDia(){}

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
    
}