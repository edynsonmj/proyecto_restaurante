package co.unicauca.restaurante.commons.domain;

/**
 *
 * @author fallen
 */
public class Plato {
    private int id;
    /**
     * nombre del alimento
     */
    private String nombre;
    private String descripcion;
    /**
     * precio del alimento
     */
    private double precio;
    
    public Plato(){}
    
    public Plato(int id,String nombre, double precio,String descripcion){
        this.id=id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion=descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
