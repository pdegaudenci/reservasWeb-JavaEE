/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;


import Entidades.Habitacion;
import java.util.List;

/**
 *
 * @author pdega
 */
public interface HabitacionesCRUD {
    boolean crear(Habitacion habitacion);

    void borrar(Habitacion habitacion);

    void actualizar(Habitacion habitacion);

    Habitacion buscar(Long id);

    List<Habitacion> listar();
}
