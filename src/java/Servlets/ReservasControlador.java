/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Empleado;
import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.Reserva;
import Entidades.Usuario;
import Servicios.GestionEmpleados;
import Servicios.GestionReservas;
import Servicios.GestionUsuarios;
import java.util.Date;
import repositorios.EmpleadosBD;
import repositorios.ReservasBD;
import repositorios.UsuariosBD;


public class ReservasControlador {


    public static void main(String[] args) {
        /*
        ReservasBD reservas=new ReservasBD();
        GestionReservas gestion=new GestionReservas(reservas);
    
        Date fechain=new Date("13/1/2020");
        Date fechaout=new Date("13/2/2020");
        Usuario usuario=new Usuario(null,1 , "admin", "admin");
        Empleado empleado=new Empleado(null, usuario, "222", "nombre", "apellido", fechain, "direccion", "cargo");
        Habitacion habitacion=new Habitacion(Long.MIN_VALUE, "habitacion", Habitacion.Tipo.TRIPLE, 0);
        Huesped  huesped=new Huesped(Long.MIN_VALUE, "13", "2121", "dsd", "jk", "cargp");
        Reserva reserva=new Reserva(new Long(122), fechain, fechaout, huesped, empleado, habitacion);
        reservas.borrar(reserva);
        
         GestionUsuarios usuarios=new GestionUsuarios(new UsuariosBD());
        
        Usuario usuario=new Usuario();
        usuario.setNombreUsuario("admin");
        usuario.setContraseña("admin");
        usuario.setNivelAcceso(3);
        
      
GestionEmpleados usu=new GestionEmpleados(new EmpleadosBD());
for (Empleado emp:usu.listar()){
    System.out.println(emp);
}
        GestionEmpleados empleados=new GestionEmpleados(new EmpleadosBD());
        Empleado empleado=new Empleado( null, "2323", "pepe", "pepe", "jkjk", "",usuario, new Date());
        
      
        */    
           GestionUsuarios usuarios=new GestionUsuarios(new UsuariosBD());
        Usuario usuario=new Usuario();
        usuario.setNombreUsuario("admin");
        usuario.setContraseña("admin");
        usuario.setNivelAcceso(3);
        
        usuarios.crearUsuario(usuario);
       
    }
    
}
