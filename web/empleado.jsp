<%-- 
    Document   : empleado.jsp
    Created on : 29-mar-2022, 19:52:13
    Author     : pdega
--%>

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
        <link rel="stylesheet" href="botones.css" type="text/css">
        <style type="text/css">

        </style>
        <title>Reservas</title>
    </head>

    <body>

        <section>
            <div class="item">
                <form action="SvAlta" method="POST">  
                    <div class="campo">
                        <label for="fechaIN" style="opacity:0.6;">Fecha nacimiento</label>
                        <input type="date" name="fechaIN" required>
                        <label for="fechaOUT" style="opacity: 0.6;">Fecha nacimiento</label>
                        <input type="date" name="fechaOUT" required>
                    </div>
                    <input type="hidden" name="alta" value="pre-altaReserva"/>
                   <input type="submit" class="boton" value="Nueva reserva" /></form>

            </div>
            <div class="item">
                <input type="hidden" name="reserva" value="modificar"/>
                <form><input type="submit" class="boton" value="Modificar reserva" /></form>

            </div>
            <div class="item">
                <form> 
                    <input type="hidden" name="reserva" value="buscar"/>
                    <input type="submit" class="boton" value="Buscar Reserva" />
                </form>


            </div>
        </section>





    </section>
</body>

</html>
