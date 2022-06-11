<%-- 
    Document   : editarEmpleado
    Created on : 26-mar-2022, 10:47:34
    Author     : pdega
--%>

<%@page import="Servicios.Fechas"%>

<%@page import="java.util.Date"%>
<%@page import="Entidades.Empleado"%>
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


            
                
                    <% 
                       
                      Empleado empleado= (Empleado)request.getSession().getAttribute("empleado");

                    %>
                    <tr>
                        <%  String dni = empleado.getDni();
                            String nombre = empleado.getNombre();
                            String apellido = empleado.getApellido();
                            String fecha = Fechas.formatFechaDateToString(empleado.getFecha_nacimiento());
                            String direccion = empleado.getDireccion();
                            String cargo = empleado.getCargo();
                            String usuario = empleado.getUsuario().getNombreUsuario();
                            long id = empleado.getIdEmpleado();
                        %>
                           <form action="SvModificar" method="get" id="formulario">
            <div class="campo">
                <label for="nombre"></label>
                <input type="text" placeholder="Nombre= <%=nombre%>" name="nombre" value ="<%=nombre%>"required>
            </div>
            <div class="campo">
                <label for="apellido"></label>
                <input type="text" placeholder="Apellido= <%=apellido%>" name="apellido" value="<%=apellido%>" required>
            </div>
            <div class="campo">
                <label for="dni"></label>
                <input type="text" placeholder="DNI= <%=dni%>" value="<%=dni%>" name="dni" required>
            </div>

            <div class="campo">
                <label for="fechaNacimiento" style="font-size: 1.5em;opacity: 0.6;">Fecha nacimiento</label>
                <input type="date" name="fecha" value="<%=fecha%>" required>
            </div>
            <div class="campo">
                <label for="direccion"></label>
                <input type="text" placeholder="Direccion= <%=direccion%>" value="<%=direccion%>" name="direccion" required>
            </div>
            <div class="campo">
                <label for="cargo"></label>
                <input type="text" placeholder="Cargo= <%=cargo%>" value="<%=cargo%>" name="cargo" required>
            </div>
            <div class="campo">
                <label for="usuario"></label>
                <input type="text" placeholder="Usuario= <%=usuario%>" value="<%=usuario%>" name="usuario" required>
            </div>
         
            <div class="submit">
                <input type="hidden" name="idEmpleado" value="<%=id%>">
                <input type="submit" value="Editar" id="form_button" />
            </div>
        </form>
        </section>
    </body>

</html>
