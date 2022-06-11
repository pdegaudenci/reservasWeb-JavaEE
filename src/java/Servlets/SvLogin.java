package Servlets;




import Servicios.GestionEmpleados;
import Servicios.GestionHabitaciones;
import Servicios.GestionUsuarios;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositorios.EmpleadosBD;
import repositorios.UsuariosBD;


public class SvLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String nombreUsuario = request.getParameter("nombreUsuario");
        String contraseña = request.getParameter("contrasenia");

        // Obtener sesion y guardar atributos
        GestionUsuarios gestionUsu = new GestionUsuarios(new UsuariosBD());
        if (gestionUsu.usuarioValido(nombreUsuario, contraseña)) {
            if(nombreUsuario.equals("admin")){
                 GestionEmpleados empleados=new GestionEmpleados((new EmpleadosBD()));
            GestionHabitaciones habitaciones=new GestionHabitaciones();
            request.getSession().setAttribute("usuario", nombreUsuario);
            request.getSession().setAttribute("listado", empleados.listar());
            request.getSession().setAttribute("habitaciones",habitaciones.listar() );
            response.sendRedirect("admin.jsp");
            }
            else{
                request.getSession().setAttribute("usuario", nombreUsuario);
                response.sendRedirect("empleado.jsp");
            }
           
            
        }
        else{
              response.sendRedirect("index.jsp");
        }
      
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
