/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Habitacion;
import Entidades.Usuario;
import Servicios.Fechas;
import Servicios.GestionEmpleados;
import Servicios.GestionHabitaciones;
import Servicios.GestionReservas;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositorios.EmpleadosBD;
import repositorios.ReservasBD;

/**
 *
 * @author pdega
 */
public class SvAlta extends HttpServlet {

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
        String accion = request.getParameter("alta");
        GestionHabitaciones habitaciones = new GestionHabitaciones();
        GestionReservas reservas=new GestionReservas(new ReservasBD());
        boolean hecho = false;
        switch (accion) {
            case "habitacion":

                String nombreHabitacion = request.getParameter("nombreHabitacion");
                long numero = Integer.parseInt(request.getParameter("numHabitacion"));
                double precio = Double.parseDouble(request.getParameter("precio"));
                String tipo = request.getParameter("tipo").toUpperCase();
                //TODO: Verificar que se guarde tipo correctamente (Guarda 0)
                // Habitacion.Tipo tipo = Habitacion.Tipo.valueOf(tipoRecibido);
                hecho = habitaciones.crearHabitacion(numero, nombreHabitacion, precio, tipo);
                request.getSession().setAttribute("habitaciones", habitaciones.listar());
                response.sendRedirect("editarHabitaciones.jsp");
                break;

            case "empleado":
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
                GestionEmpleados empleados = new GestionEmpleados(new EmpleadosBD());
                String nombreEmpleado = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String dni = request.getParameter("dni");
                String direccion = request.getParameter("direccion");
                String cargo = request.getParameter("cargo");
                String usuario = request.getParameter("usuario");
                String contraseña = request.getParameter("contrasenia");
                String fecha = request.getParameter("fechaNacimiento");
                empleados.crearEmpleado(nombreEmpleado, apellido, dni, direccion, cargo, usuario, contraseña, fecha);
                request.getSession().setAttribute("listado", empleados.listar());
                response.sendRedirect("editarEmpleados.jsp");

            case "pre-altaReserva":

                String fechaIN = request.getParameter("fechaIN");
                String fechaOUT = request.getParameter("fechaOUT");
                Date fechaInicio = Fechas.formatFechaStringToDate(fechaIN);
                Date fechaFin = Fechas.formatFechaStringToDate(fechaOUT);
                request.getSession().setAttribute("habitacionesLibres", habitaciones.buscarHabitacionesLibres(fechaInicio, fechaFin));
                request.getSession().setAttribute("fechaIN", fechaIN);
                request.getSession().setAttribute("fechaOUT", fechaOUT);
                response.sendRedirect("HabitacionesDisponibles.jsp");
                break;

            case "alta":
                request.getSession().setAttribute("habitacionesLibres", null);
                Long id = Long.parseLong(request.getParameter("idHabitacion"));
                Habitacion habitacion = habitaciones.buscar(id);
                int diasEstadia = Fechas.diferenciaDeDias(
                        Fechas.formatFechaStringToDate((String) request.getSession().getAttribute("fechaIN")),
                        Fechas.formatFechaStringToDate((String) request.getSession().getAttribute("fechaOUT"))
                );
                request.getSession().setAttribute("habitacion", habitacion);
                request.getSession().setAttribute("dias", diasEstadia);
                request.getSession().setAttribute("precio", diasEstadia * habitacion.getPrecioXNoche());
                response.sendRedirect("altaHuesped.jsp");
                break;

            case "confirmacionAlta":
                String dniHuesped=request.getParameter("dni");
                String nombreHuesped=request.getParameter("nombre");
                String apellidoHuesped=request.getParameter("apellido");
                String profesionHuesped=request.getParameter("profesion");
                String direccionHuesped=request.getParameter("direccion");
                reservas.crearReservas(dniHuesped,nombreHuesped,apellidoHuesped,profesionHuesped,direccionHuesped, (Habitacion)request.getSession().getAttribute("habitacion"),(String)request.getSession().getAttribute("fechaIN"),(String)request.getSession().getAttribute("fechaOUT"),(String)request.getSession().getAttribute("usuario"));
                break;

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
//TODO verificar funcion (Incorporarla al case de alta de metodo doPost)

}
