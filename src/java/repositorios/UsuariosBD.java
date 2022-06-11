
package repositorios;

import Entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuariosBD implements UsuariosCRUD {
UsuarioJpaController usuarioBD=new UsuarioJpaController();
        
       
    @Override
    public boolean crear(Usuario usuario) {
       
      usuarioBD.create(usuario);
      return true;
    }

    @Override
    public void borrar(Usuario usuario) {
         if(this.usuarioBD.findUsuario(usuario.getNombreUsuario())!=null){
           try {
               this.usuarioBD.destroy(usuario.getNombreUsuario());
           } catch (Exception ex) {
               Logger.getLogger(UsuariosBD.class.getName()).log(Level.SEVERE, null, ex);
           }
         }
    }

    @Override
    public void actualizar(Usuario usuario) {
       if(this.usuarioBD.findUsuario(usuario.getNombreUsuario())!=null){
           try {
               this.usuarioBD.edit(usuario);
           } catch (Exception ex) {
               Logger.getLogger(UsuariosBD.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }

    @Override
    public Usuario buscar(String nombreUsuario) {
       return this.usuarioBD.findUsuario(nombreUsuario);
    }
        

    @Override
    public List<Usuario> listar() {
        return this.usuarioBD.findUsuarioEntities();
    }
    
}
