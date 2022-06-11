/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import Entidades.Habitacion;
import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;
import repositorios.exceptions.NonexistentEntityException;

/**
 *
 * @author pdega
 */
public class HabitacionesBD implements HabitacionesCRUD {
private final HabitacionJpaController ctrlHab=new HabitacionJpaController();

/**
 * Crea habitacion si no existe (En funcion del numero de habitacion)
 * @param habitacion
 * @return boolean : verdadero si se pudo crear la habitacion o falso en caso de que exista esa habitacion
 */
    public HabitacionesBD() {
    }

    @Override
    public boolean crear(Habitacion habitacion) {
        //
        List<Habitacion> habitaciones;
        habitaciones = this.listar().stream()
                .filter(elemento -> Objects.equals(elemento.getNumeroHabi(), habitacion.getNumeroHabi()))
                .collect(Collectors.toList());
        if(habitaciones.isEmpty()){
            this.ctrlHab.create(habitacion);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void borrar(Habitacion habitacion) {
       if(this.ctrlHab.findHabitacion(habitacion.getId())!=null){
           try {
               this.ctrlHab.destroy(habitacion.getId());
           } catch (NonexistentEntityException ex) {
               System.err.println("Error al borrar habitacion: "+ex.getMessage());
           }
       }
    }

    @Override
    public void actualizar(Habitacion habitacion) {
       if(this.ctrlHab.findHabitacion(habitacion.getId())!=null){
           try {
               this.ctrlHab.edit(habitacion);
           } catch (Exception ex) {
               System.err.println("Error al actualizar habitacion: "+ex.getMessage());
           }
       }
    }

    @Override
    public Habitacion buscar(Long id) {
       return this.ctrlHab.findHabitacion(id);
    }

    @Override
    public List<Habitacion> listar() {
        return this.ctrlHab.findHabitacionEntities();
    }
    
}
