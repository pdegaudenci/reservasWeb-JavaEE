package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

    @Id
    private Long idReserva;

    @Temporal(TemporalType.DATE)
    private Date fechaIN;
    @Temporal(TemporalType.DATE)
    private Date fechaOUT;
  @OneToOne(cascade =  CascadeType.PERSIST)
    private Huesped huesped;
    @OneToOne
    private Empleado empleado;
 @OneToOne
    private Habitacion habitacion;

    public Reserva() {
    }

    public Reserva(Long idReserva, Date fechaIN, Date fechaOUT, Huesped huesped, Empleado empleado, Habitacion habitacion) {
        this.idReserva = idReserva;
        this.fechaIN = fechaIN;
        this.fechaOUT = fechaOUT;
        this.huesped = huesped;
        this.empleado = empleado;
        this.habitacion = habitacion;
    }



    public Date getFechaIN() {
        return fechaIN;
    }

    public void setFechaIN(Date fechaIN) {
        this.fechaIN = fechaIN;
    }

    public Date getFechaOUT() {
        return fechaOUT;
    }

    public void setFechaOUT(Date fechaOUT) {
        this.fechaOUT = fechaOUT;
    }

    public Empleado getIdEmpleando() {
        return empleado;
    }

    public void setIdEmpleando(Empleado empleado) {
        this.empleado = empleado;
    }

    public Habitacion getIdHabitacion() {
        return habitacion;
    }

    public void setIdHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fechaIN=" + fechaIN + ", fechaOUT=" + fechaOUT + ", huesped=" + huesped + ", empleado=" + empleado + ", habitacion=" + habitacion + '}';
    }

  
}
