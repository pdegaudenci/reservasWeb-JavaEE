package Servicios;

import Entidades.Empleado;

import Entidades.Usuario;
import java.util.List;

import repositorios.EmpleadosCRUD;

public class GestionEmpleados {

    EmpleadosCRUD empleados;

    public GestionEmpleados(EmpleadosCRUD empleados) {
        this.empleados = empleados;
    }

    public List<Empleado> listar() {
        
        return this.empleados.listar();
    }

    public boolean crearEmpleado(String nombre, String apellido, String dni, String direccion, String cargo, String nombreUsuario, String contraseña, String fechaNacimiento) {

        Empleado empleado = new Empleado();
        empleado.setApellido(apellido);
        empleado.setNombre(nombre);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setCargo(cargo);
        empleado.setFecha_nacimiento(Fechas.formatFechaStringToDate(fechaNacimiento));
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setNivelAcceso(2);
        usuario.setContraseña(contraseña);
        empleado.setUsuario(usuario);
        return this.empleados.crear(empleado);

    }

    public void borrar(Long id) {
        Empleado empleado = this.buscar(id);
        if (empleado != null) {
            this.empleados.borrar(empleado);
        }

    }

    public void actualizar(Empleado empleado) {
        this.empleados.actualizar(empleado);
    }
    public Empleado bucarPorNombreUsuario(String nombre){
        List<Empleado> lista=this.listar();
        Empleado empleadoBuscado=null;
        for(Empleado empleado: lista){
            if(empleado.getUsuario().getNombreUsuario().equals(nombre)){
                return empleado;
            }
        }
        return empleadoBuscado;
        
    }

    public Empleado buscar(Long id) {
        return this.empleados.buscar(id);
    }
}
