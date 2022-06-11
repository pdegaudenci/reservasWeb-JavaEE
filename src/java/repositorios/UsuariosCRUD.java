package repositorios;

import Entidades.Usuario;
import java.util.List;

public interface UsuariosCRUD {

    boolean crear(Usuario usuario);

    void borrar(Usuario usuario);

    void actualizar(Usuario usuario);

    Usuario buscar(String nombre);

    List<Usuario> listar();
}
