package repositorios;

import Entidades.Reserva;

import java.util.List;

public interface ReservasCRUD {

    boolean crear(Reserva reserva);

    void borrar(Reserva reserva);

    void actualizar(Reserva reserva);

    Reserva buscar(Reserva reserva);

    List<Reserva> listar();
}
