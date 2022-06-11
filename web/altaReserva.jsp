<%-- 
    Document   : altaReserva
    Created on : 30-mar-2022, 22:54:22
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
        <title>Editar Empleados</title>
    </head>

    <body>
       
        <section>


            
                
                    <% 
                       
                      Habitacion habitacion= (Habitacion)request.getSession().getAttribute("habitacion");
HttpSession sesion=request.getSession();
                    %>
                    <tr>
                        <%  String nombre = habitacion.getNombre();
                            String tipo = habitacion.getTipo().toUpperCase();
                           Long numero=habitacion.getNumeroHabi();
                           Double precio=habitacion.getPrecioXNoche();
                           Double precioTotal=(Double)sesion.getAttribute("precio");
                           Integer dias=(Integer)sesion.getAttribute("dias");
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
          
            <div class="submit">
                <input type="hidden" name="alta" value="altaConfirmada" />
                <input type="submit" value="Confirmar Reserva" id="form_button" />
            </div>
        </form>
        </section>
    </body>

</html>
