<%-- 
    Document   : mostrarEmpleados
    Created on : 23-mar-2022, 20:51:38
    Author     : pdega
--%>

<%@page import="Entidades.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="Servicios.GestionHabitaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
        <title>Editar Habitaciones</title>
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

                <caption>Habitaciones</caption>
                <thead>
                <th> Numero              
                </th>
                <th> Nombre              
                </th>
                <th> Tipo              
                </th>
                <th> Precio      </th>   
                <th colspan="2">Acciones</th>



                </thead>
                <tbody>
                    <% List<Habitacion> listado = (List<Habitacion>) request.getSession().getAttribute("habitaciones");

                        if (listado != null) {
                            for (Habitacion habitacion : listado) {

                    %>
                    <tr>
                        <%                            
                            Long id=habitacion.getId();
                            long numero = habitacion.getNumeroHabi();
                            String nombre = habitacion.getNombre();
                            double precio = habitacion.getPrecioXNoche();
                            String tipo = habitacion.getTipo();

                        %>
                        <td><%=numero%></td>

                        <td><%=nombre%></td>

                        <td><%=tipo%></td>

                        <td><%=precio%></td>


                <form action="SvModificar" method="POST">
                    <td>
                        <input type="hidden" name="accion" value="eliminarHabitacion">
                        <input type="hidden" name="idHabitacion" value="<%=id%>">
                        <input type="submit" value="Eliminar">
                    </td>
                </form>

                <form action="SvModificar" method="POST">
                    <td>
                        <input type="hidden" name="accion" value="modificarHabitacion">
                        <input type="hidden" name="idHabitacion" value="<%=id%>">
                        <input type="submit" value="Modificar">
                    </td>

                </form>

                </tr>

                <% }
                    }%>
                </tbody>
            </table>
        </section>
    </body>

</html>
