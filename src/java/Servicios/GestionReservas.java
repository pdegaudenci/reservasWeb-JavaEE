package Servicios;

import Entidades.Empleado;
import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.Reserva;

import java.util.Date;
import java.util.List;
import repositorios.EmpleadosBD;
import repositorios.ReservasCRUD;

public class GestionReservas {

    private ReservasCRUD reservasBD;

    public GestionReservas(ReservasCRUD reservas) {
        this.reservasBD = reservas;
    }
    
    public List<Reserva> listar(){
        return this.reservasBD.listar();
    }

  
    public void borrar(Reserva reserva){
        this.reservasBD.borrar(reserva);
    }

    public void actualizar(Reserva reserva){
        this.reservasBD.actualizar(reserva);
    }

   public  Reserva buscar(Reserva reserva){
        return this.reservasBD.buscar(reserva);
    }
   
   public List<Reserva> buscarReservaPorFechas(Date fechainicio, Date fechaFin){
       return this.reservasBD.listar();
   }

    public void crearReservas(String dniHuesped, String nombreHuesped, String apellidoHuesped, String profesionHuesped, String direccionHuesped, Habitacion habitacion, String fechaIN, String fechaOUT, String usuario) {
        GestionEmpleados empleados=new GestionEmpleados(new EmpleadosBD());
        
        Empleado empleado=empleados.bucarPorNombreUsuario(usuario);
        
        Reserva reserva=new Reserva();
        reserva.setEmpleado(empleado);
        reserva.setFechaIN(Fechas.formatFechaStringToDate(fechaIN));
        reserva.setFechaOUT(Fechas.formatFechaStringToDate(fechaOUT));
        reserva.setHabitacion(habitacion);
        
        Huesped huesped=new Huesped();
        huesped.setApellido(apellidoHuesped);
        huesped.setDireccion(direccionHuesped);
        huesped.setDni(dniHuesped);
        huesped.setNombre(nombreHuesped);
        huesped.setReserva(reserva);
        huesped.setProfesion(profesionHuesped);
   
        reserva.setHuesped(huesped);
        
        this.reservasBD.crear(reserva);
        
        
    }

 

  
    }

