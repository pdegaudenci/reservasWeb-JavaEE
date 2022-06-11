package Servicios;

import Entidades.Empleado;
import Entidades.Habitacion;
import Entidades.Reserva;
import static Entidades.Reserva_.habitacion;
import Entidades.Tipo;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import repositorios.HabitacionesBD;
import repositorios.ReservasBD;

public class GestionHabitaciones {

    private HabitacionesBD habitacionesBD = new HabitacionesBD();
    private GestionReservas reservas = new GestionReservas(new ReservasBD());

    public GestionHabitaciones() {

    }

    public List<Habitacion> listar() {
        return this.habitacionesBD.listar();
    }

    public boolean crearHabitacion(Long numero, String nombre, double precio, String tipo) {
        Habitacion habitacion = new Habitacion();
        habitacion.setNombre(nombre);
        habitacion.setNumeroHabi(numero);
        habitacion.setPrecioXNoche(precio);
        habitacion.setTipo(tipo);
        return this.habitacionesBD.crear(habitacion);

    }

    private Tipo obtenerTipo(String parameter) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.name().equalsIgnoreCase(parameter)) {
                return Tipo.valueOf(parameter);
            }
        }
        return null;
    }

    public void borrar(Long id) {
        Habitacion habitacion = this.buscar(id);
        if (habitacion != null) {
            this.habitacionesBD.borrar(habitacion);
        }
    }

    public void actualizar(Habitacion habitacion) {
        this.habitacionesBD.actualizar(habitacion);
    }

    public Habitacion buscar(Long id) {
        return this.habitacionesBD.buscar(id);
    }

    public Collection<Habitacion> buscarHabitacionesLibres(Date fechaInicio, Date fechaFin) {
        List<Habitacion> habitacionesLibres = habitacionesBD.listar();
        
        for(Reserva reserva: reservas.listar()){
            Date[] fechas1={reserva.getFechaIN(),reserva.getFechaOUT()};
            Date[] fecha2={fechaInicio,fechaFin};
            if(Fechas.fechasSolapas(fecha2, fecha2)) {
                habitacionesLibres.remove(reserva.getHabitacion());
            }
        }
        
        return habitacionesLibres;

    }
}
