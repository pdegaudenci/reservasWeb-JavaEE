<%-- 
    Document   : altaHabitacion
    Created on : 24-mar-2022, 13:59:01
    Author     : pdega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <title>Alta Habitacion</title>
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

        <form action="SvAlta" method="post" id="formulario">
            <div class="campo">
                <label for="numHabitacion"></label>
                <input type="text" placeholder="Numero de habitacion" name="numHabitacion" required>
            </div>
            <div class="campo">
                <label for="nombre"></label>
                <input type="text" placeholder="Nombre Tematico" name="nombreHabitacion" required>
            </div>
            <div class="campo">
                <label for="precio"></label>
                <input type="text" placeholder="Precio por noche" name="precio" required>
            </div>
            <div class="tipo">
                <label for="tipo"></label>
                <select placeholder="Ingresar tipo de habitacion" name="tipo" id="tipo" required>
                    <option disabled hidden selected>-</option>
                    <option value="single">SINGLE</option>
                    <option value="double">DOUBLE</option>
                    <option value="triple">TRIPLE</option>
                    <option value="multiple">MULTIPLE</option>
                </select>
            </div>

            <div class="submit">
                <input type="hidden" name="alta" value="habitacion">
                <input type="submit" value="Alta Habitacion" id="form_button" />
            </div>
        </form>







    </section>
</body>
</html>
