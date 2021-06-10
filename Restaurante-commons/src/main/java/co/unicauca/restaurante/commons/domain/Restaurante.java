package co.unicauca.restaurante.commons.domain;

/**
 *
 * @author EdynsonMJ
 */
public class Restaurante {
    private String nombre;
    private int id;

    public Restaurante() {}

    public Restaurante(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
