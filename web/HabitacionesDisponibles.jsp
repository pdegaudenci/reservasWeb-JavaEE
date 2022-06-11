<%-- 
    Document   : HabitacionesDisponibles
    Created on : 30-mar-2022, 16:58:32
    Author     : pdega
--%>

<%@page import="Entidades.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" href="formulario.css" type="text/css">
        <style type="text/css">

        </style>
        <title>Editar Empleados</title>
    </head>

    <body>
        <header>



        </header>
        <section>


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

                      

                    </header>
                    <section>


                        <table>

                            <caption>Empleados</caption>
                            <thead>
                            <th> Nombre             
                            </th>
                            <th> Numero              
                            </th>
                            <th> Tipo              
                            </th>
                            <th> Precio      </th>        


                            <th> Accion              
                            </th>

                            </thead>
                            <tbody>
                                <% List<Habitacion> listado = (List<Habitacion>) request.getSession().getAttribute("habitacionesLibres");

                                    if (listado != null) {
                                        for (Habitacion habitacion : listado) {

                                %>
                                <tr>
                                    <%                            Long id = habitacion.getId();
                                        String nombre = habitacion.getNombre();
                                        Long numero = habitacion.getNumeroHabi();
                                        Double precio = habitacion.getPrecioXNoche();
                                        String tipo = habitacion.getTipo();
                                    
                                    %>
                                    <td><%=nombre%></td>

                                    <td><%=numero%></td>

                                    <td><%=precio%></td>

                                    <td><%=tipo%></td>

                            <form action="SvAlta" method="POST">
                                <td>
                                    <input type="hidden" name="alta" value="alta">
                                    <input type="hidden" name="idHabitacion" value="<%=id%>">
                                    <input type="submit" value="Reservar">
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
