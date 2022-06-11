package repositorios;

import Entidades.Reserva;
import Servicios.Fechas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repositorios.exceptions.NonexistentEntityException;

public class ReservasBD implements ReservasCRUD {

    ReservaJpaController reservasBD = new ReservaJpaController();

    public ReservasBD() {

    }

    @Override
    public boolean crear(Reserva reserva) {
        Date[] rangoFecha = {reserva.getFechaIN(), reserva.getFechaOUT()};
        List<Reserva> reservas =  this.listar();
        boolean realizado = true;
        /*
         for (Reserva reservaActual : reservas) {
            Date[] rangoFechaActual = {reservaActual.getFechaIN(), reservaActual.getFechaOUT()};
            if (Fechas.fechasSolapas(rangoFecha, rangoFechaActual)) {
                realizado = false;
                break;
            }
        }
        */
       
        if (realizado) {
            try {
                reservasBD.create(reserva);
            } catch (Exception e) {
                System.out.println("Error al crear reserva " + e.getMessage());
            }

        }
        return realizado;
    }

    @Override
    public void borrar(Reserva reserva) {
        Reserva reservaBuscada = reservasBD.findReserva(reserva.getIdReserva());
        if (reservaBuscada != null) {
            try {
                reservasBD.destroy(reserva.getIdReserva());
            } catch (NonexistentEntityException e) {
                System.out.println("Error al borrar Reserva: " + e.getMessage());
            }
        }
    }

    @Override
    public void actualizar(Reserva reserva) {
        Reserva reservaBuscada = reservasBD.findReserva(reserva.getIdReserva());
        if (reservaBuscada != null) {
            try {
                reservasBD.edit(reserva);
            } catch (Exception e) {
                System.out.println("Error al actualizar reserva: "+e.getMessage());
            }
        }

    }

    @Override
    public Reserva buscar(Reserva reserva) {
        return reservasBD.findReserva(reserva.getIdReserva());
    }

    @Override
    public List<Reserva> listar() {
        return reservasBD.findReservaEntities();
    }

}
