package repositorios;

import Entidades.Empleado;
import Servicios.GestionUsuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import repositorios.exceptions.NonexistentEntityException;


public class EmpleadosBD implements EmpleadosCRUD {

   private EmpleadoJpaController empleados = new EmpleadoJpaController();
   private  GestionUsuarios usuarios=new GestionUsuarios(new UsuariosBD());

    public EmpleadosBD() {

    }

    @Override
    public boolean crear(Empleado empleado) {
boolean creado=false;
        List<Empleado> listadoEmpleados=  this.listar();

        List<Empleado> listado = listadoEmpleados.stream().filter((empleadoActual) -> (empleado.getUsuario().getNombreUsuario().equalsIgnoreCase(empleadoActual.getUsuario().getNombreUsuario()))).collect(Collectors.toList());

       if(listado.isEmpty()) {
            this.empleados.create(empleado);
           
            usuarios.actualizar(empleado.getUsuario());
            creado=true;
       }
       return creado;

    }

    @Override
    public void borrar(Empleado empleado) {
      
           
        try {
            empleados.destroy(empleado.getIdEmpleado());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
     
    }

    @Override
    public void actualizar(Empleado empleado) {
        try {
            empleados.edit(empleado);
        } catch (Exception e) {
            System.out.println("Error al editar Usuario: " + e.getMessage());
        }
    }

    @Override
    public Empleado buscar(Long id) {
        return empleados.findEmpleado(id);
    }

    @Override
    public List<Empleado> listar() {
        return empleados.findEmpleadoEntities();
    }

}
