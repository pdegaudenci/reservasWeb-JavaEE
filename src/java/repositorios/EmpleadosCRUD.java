
package repositorios;

import Entidades.Empleado;
import java.util.List;

public interface EmpleadosCRUD {
    boolean crear(Empleado empleado);

    void borrar(Empleado empleado);

    void actualizar(Empleado empleado);

    Empleado buscar(Long id);

    List<Empleado> listar(); 
}
