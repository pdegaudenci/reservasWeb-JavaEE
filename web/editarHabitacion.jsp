<%-- 
    Document   : editarHabitacion
    Created on : 28-mar-2022, 17:14:14
    Author     : pdega
--%>

<%@page import="Entidades.Habitacion"%>
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
        <title>Editar Habitacion</title>
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
                       
                     Habitacion habitacion= (Habitacion)request.getSession().getAttribute("habitacion");

                    %>
                    <tr>
                        <%  Long id=habitacion.getId();
                            Long numero=habitacion.getNumeroHabi();
                           String nombre= habitacion.getNombre();
                            String tipo=habitacion.getTipo();
                            double precio=habitacion.getPrecioXNoche();
                        %>
                           <form action="SvModificar" method="get" id="formulario">
            <div class="campo">
                <label for="numero"></label>
                <input type="text" placeholder="numero= <%=numero%>" name="numero" value ="<%=numero%>"required>
            </div>
            
             <div class="campo">
                <label for="nombre"></label>
                <input type="text" placeholder="nombre= <%=nombre%>" name="nombre" value ="<%=nombre%>"required>
            </div>
   
                <div class="tipo">
                <label for="tipo"></label>
                <select placeholder="Ingresar tipo de habitacion" name="tipo" id="tipo" required>
                    <option   selected><%=tipo%></option>
                    <option value="single">SINGLE</option>
                    <option value="double">DOUBLE</option>
                    <option value="triple">TRIPLE</option>
                    <option value="multiple">MULTIPLE</option>
                </select>
            </div>
            
            <div class="campo">
                <label for="dni"></label>
                <input type="text" placeholder="Precio= <%=precio%>" value="<%=precio%>" name="precio" required>
            </div>

         
            <div class="submit">
                <input type="hidden" name="idHabitacion" value="<%=id%>">
                <input type="submit" value="Editar" id="form_button" />
            </div>
        </form>
        </section>
    </body>
</html>
