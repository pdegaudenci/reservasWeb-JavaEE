<%-- 
    Document   : mostrarEmpleados
    Created on : 25-mar-2022, 20:43:49
    Author     : pdega
--%>

<%@page import="Servlets.Fechas"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidades.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="repositorios.EmpleadosBD"%>
<%@page import="Servicios.GestionEmpleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="author" content="Pedro Sebastian Degaudenci Ferreira">
        <meta name="descripcion" content="">
        <meta name="keywords" content="">
        <meta name="date" content="2022-02-14T23:59:00+00:00">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilosGenerales.css" type="text/css">
        <link rel="stylesheet" href="tablas.css" type="text/css">
        <style type="text/css">

        </style>
        <title>Editar Empleados</title>
    </head>

    <body>
        <header>

            <nav>

            <ul>
                <li> <a href="#">Empleados</a>
                    <ul>
                        <li><a href="altaEmpleado.jsp">Alta Empleado</a></li>
                        <li><a href="editarEmpleados.jsp">Editar Empleado</a></li>
                    </ul>
                </li>
                <li> <a href="#">Habitaciones</a>
                    <ul>
                        <li><a href="altaEmpleado.jsp">Alta Habitacion</a></li>
                        <li><a href="editarHabitaciones.jsp">Editar Habitacion</a></li>
                    </ul>
                </li>
                <li><a href="#">Reportes</a></a></li>
            </ul>

        </nav>

        </header>
        <section>


            <table>

                <caption>Empleados</caption>
                <thead>
                <th> DNI              
                </th>
                <th> Nombre              
                </th>
                <th> Apellido              
                </th>
                <th> Fecha      </th>        

                <th> Direccion              

                </th>

                <th> Cargo              
                </th>
                <th> Usuario              
                </th>
                <th colspan="2"> Accion              
                </th>

                </thead>
                <tbody>
                    <% List<Empleado> listado=(List<Empleado>)  request.getSession().getAttribute("listado");
                  
                    if(listado!=null){
                        for (Empleado empleado : listado) {

                    %>
                    <tr>
                        <%                            String dni = empleado.getDni();
                            String nombre = empleado.getNombre();
                            String apellido = empleado.getApellido();
                            String fecha = Fechas.formatFechaDateToString(empleado.getFecha_nacimiento());
                            String direccion = empleado.getDireccion();
                            String cargo = empleado.getCargo();
                            String usuario = empleado.getUsuario().getNombreUsuario();
                            long id = empleado.getIdEmpleado();
                        %>
                        <td><%=dni%></td>

                        <td><%=nombre%></td>

                        <td><%=apellido%></td>

                        <td><%=fecha%></td>

                        <td><%=direccion%></td>
                          <td><%=cargo%></td>

                        <td><%=usuario%></td>
                <form action="SvModificar" method="POST">
                    <td>
                        <input type="hidden" name="accion" value="eliminar">
                        <input type="hidden" name="idEmpleado" value="<%=id%>">
                        <input type="submit" value="Eliminar">
                    </td>
                </form>

                <form action="SvModificar" method="POST">
                    <td>
                        <input type="hidden" name="accion" value="modificar">
                        <input type="hidden" name="idEmpleado" value="<%=id%>">
                        <input type="submit" value="Modificar">
                    </td>

                </form>

                </tr>

                <% } }%>
                </tbody>
            </table>
        </section>
    </body>

</html>
