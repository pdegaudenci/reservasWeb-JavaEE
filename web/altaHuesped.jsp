<%-- 
    Document   : altaHuesped
    Created on : 04-abr-2022, 16:21:00
    Author     : pdega
--%>

<%@page import="Entidades.Habitacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="author" content="Pedro Sebastian Degaudenci Ferreira">
        <meta name="descripcion" content="">
        <meta name="keywords" content="">
        <meta name="date" content="2022-02-14T23:59:00+00:00">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilosGenerales.css" type="text/css">
        <link rel="stylesheet" href="formulario.css" type="text/css">
        <style type="text/css">
            h2{
                text-align: center;
                font-size: 45px;
                color:white;
                text-decoration: underline;
                margin-top: 10%;
            }
        </style>
        <title>Alta Huesoed</title>
    </head>
    <body>
        <section>




            <%

                Habitacion habitacion = (Habitacion) request.getSession().getAttribute("habitacion");
                if (habitacion != null) {
                    HttpSession sesion = request.getSession();
            %>
            <tr>
                <%  String nombre = habitacion.getNombre();
                    String tipo = habitacion.getTipo().toUpperCase();
                    Long numero = habitacion.getNumeroHabi();
                    Double precio = habitacion.getPrecioXNoche();
                    Double precioTotal = (Double) sesion.getAttribute("precio");
                    Integer dias = (Integer) sesion.getAttribute("dias");
                %>
            <form action="SvAlta" method="POST" id="formulario">
                <div class="campo">
                    <label for="nombre"></label>
                    <input type="text"  name="nombre" value ="<%=nombre%>" disabled autocomplete="on">
                </div>
                <div class="campo">
                    <label for="numero"></label>
                    <input type="text"  name="numero" value="<%=numero%>" disabled autocomplete="on">
                </div>
                <div class="campo">
                    <label for="tipo"></label>
                    <input type="text"  value="<%=tipo%>" disabled autocomplete="on">
                </div>


                <div class="campo">
                    <label for="precio">Precio por noche:</label>
                    <input type="text"  value="<%=precio%>" name="precio" disabled autocomplete="on">
                </div>

                <div class="campo">
                    <label for="dias">Dias de estadia:</label>
                    <input type="text"  value="<%=dias%>" name="dias" disabled autocomplete="on">
                </div>

                <div class="campo">
                    <label for="dias">Precio total:</label>
                    <input type="text"  value="<%=precioTotal%>" name="precio" disabled autocomplete="on">
                </div>

                <h2>Datos del huesped</h2>

                <div class="campo">
                    <label for="dni"></label>
                    <input type="text"  placeholder="DNI" name="dni"  required>
                </div>
                <div class="campo">
                    <label for="nombre"></label>
                    <input type="text"  placeholder="Nombres" name="nombre"  required>
                </div>
                
                <div class="campo">
                    <label for="apellido"></label>
                    <input type="text"  placeholder="Apellido" name="apellido"  required>
                </div>
                
                <div class="campo">
                    <label for="profesion"></label>
                    <input type="text"  placeholder="Profesion" name="profesion"  required>
                </div>
                
                 <div class="campo">
                    <label for="direccion"></label>
                    <input type="text"  placeholder="Direccion" name="direccion"  required>
                </div>
                
                
                <div class="submit">
                    <input type="hidden" name="alta" value="confirmacionAlta" />
                    <input type="submit" value="Confirmar Reserva" id="form_button" />
                </div>
            </form>
        </section>
        <% }%>
    </body>
</html>
