package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private Long numeroHabi;
    private String nombre;
    private double precioXNoche;
    private String tipo;

    public Habitacion() {
    }

    public Habitacion(Long id, Long numeroHabi, String nombre, String tipo, double precioXNoche) {
        this.id = id;
        this.numeroHabi = numeroHabi;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioXNoche = precioXNoche;
    }

    public Long getNumeroHabi() {
        return numeroHabi;
    }

    public void setNumeroHabi(Long numeroHabi) {
        this.numeroHabi = numeroHabi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioXNoche() {
        return precioXNoche;
    }

    public void setPrecioXNoche(double precioXNoche) {
        this.precioXNoche = precioXNoche;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", precioXNoche=" + precioXNoche + '}';
    }

}
