package Servicios;

import Entidades.Usuario;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import repositorios.UsuariosCRUD;

public class GestionUsuarios {

    UsuariosCRUD usuarios;

    public GestionUsuarios(UsuariosCRUD usuarios) {
        this.usuarios = usuarios;
    }

    public boolean usuarioValido(String nombre, String contraseña) {
        List<Usuario> listaUsuarios = this.listar();
        boolean valido = false;
     
    
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public List<Usuario> listar() {
        return this.usuarios.listar();
    }

    public boolean crearUsuario(Usuario usuario) {
        boolean creado=false;
        if (this.buscar(usuario.getNombreUsuario())==null) {
            return this.usuarios.crear(usuario);
        }
        return creado;

    }

    public void borrar(Usuario usuario) {
        this.usuarios.borrar(usuario);
    }

    public void actualizar(Usuario usuario) {
        this.usuarios.actualizar(usuario);
    }

    public Usuario buscar(String nombreUsuario) {
        
        return this.usuarios.buscar(nombreUsuario);
    }
}
