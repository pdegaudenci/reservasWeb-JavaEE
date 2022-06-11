/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Empleado;
import Entidades.Habitacion;
import Entidades.Usuario;
import Servicios.GestionEmpleados;
import Servicios.GestionHabitaciones;
import Servicios.GestionUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositorios.EmpleadosBD;
import repositorios.UsuariosBD;

/**
 *
 * @author pdega
 */
public class SvModificar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvModificar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvModificar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario").equals("admin")) {

            if (request.getParameter("idEmpleado") != null) {

                SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                Long id = Long.parseLong(request.getParameter("idEmpleado"));
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String dni = request.getParameter("dni");
                String direccion = request.getParameter("direccion");
                String cargo = request.getParameter("cargo");
                String usuario = request.getParameter("usuario");
                Date fecha_nacimiento = null;
                try {
                    fecha_nacimiento = formateador.parse(request.getParameter("fecha"));
                } catch (ParseException ex) {
                    System.out.println("Error al parsera Fecha: " + ex.getMessage());
                }

                GestionUsuarios usuarios = new GestionUsuarios(new UsuariosBD());
                GestionEmpleados empleados = new GestionEmpleados((new EmpleadosBD()));
                Empleado empleado = empleados.buscar(id);
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setDireccion(direccion);
                empleado.setFecha_nacimiento(fecha_nacimiento);
                empleado.setCargo(cargo);
                Usuario usu = usuarios.buscar(usuario);
                usu.setNombreUsuario(usuario);
                empleado.setUsuario(usu);
                empleado.setDni(dni);

                empleados.actualizar(empleado);

                request.getSession().setAttribute("listado", empleados.listar());

                request.getSession().setAttribute("empleado", null);

                response.sendRedirect("editarEmpleados.jsp");
            }
            if (request.getSession().getAttribute("habitacion") != null) {
                Long numero = Long.parseLong(request.getParameter("numero"));
                String nombre = request.getParameter("nombre");
                String tipo = request.getParameter("tipo");
                double precio = Double.parseDouble(request.getParameter("precio"));
                Long id = Long.parseLong(request.getParameter("idHabitacion"));

                GestionHabitaciones habitaciones = new GestionHabitaciones();
                Habitacion habitacion = habitaciones.buscar(id);
                habitacion.setNombre(nombre);
                habitacion.setNumeroHabi(numero);
                habitacion.setPrecioXNoche(precio);
                habitacion.setTipo(tipo);

                habitaciones.actualizar(habitacion);

                request.getSession().setAttribute("habitaciones", habitaciones.listar());
                request.getSession().setAttribute("habitacion", null);
                response.sendRedirect("editarHabitaciones.jsp");

            } 
        }
        else {
                response.sendRedirect("error.jsp");
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionEmpleados empleados = new GestionEmpleados(new EmpleadosBD());
        GestionHabitaciones habitaciones = new GestionHabitaciones();
        String accion = request.getParameter("accion");

        HttpSession sesion = request.getSession();
        switch (accion) {
            case "eliminar":
                Long id = Long.parseLong(request.getParameter("idEmpleado"));
                empleados.borrar(id);
                sesion.setAttribute("listado", empleados.listar());
                response.sendRedirect("editarEmpleados.jsp");
                break;
            case "modificar":
                id = Long.parseLong(request.getParameter("idEmpleado"));
                Empleado empleado = empleados.buscar(id);
                sesion.setAttribute("empleado", empleado);
                response.sendRedirect("editarEmpleado.jsp");
                break;
            case "eliminarHabitacion":
                Long idHabitacion = Long.parseLong(request.getParameter("idHabitacion"));
                habitaciones.borrar(idHabitacion);
                sesion.setAttribute("habitaciones", habitaciones.listar());
                response.sendRedirect("editarHabitaciones.jsp");
                break;
            case "modificarHabitacion":
                idHabitacion = Long.parseLong(request.getParameter("idHabitacion"));
                Habitacion habitacion = habitaciones.buscar(idHabitacion);
                sesion.setAttribute("habitacion", habitacion);
                response.sendRedirect("editarHabitacion.jsp");
                break;

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
