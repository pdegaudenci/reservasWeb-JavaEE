<%-- 
    Document   : altaEmpleado
    Created on : 24-mar-2022, 19:56:55
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
    <link rel="stylesheet" href="formulario.css" type="text/css">
    <style type="text/css">

    </style>
    <title>Alta Empleado</title>
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
                <label for="nombre"></label>
                <input type="text" placeholder="Ingrese nombres" name="nombre" required>
            </div>
            <div class="campo">
                <label for="apellido"></label>
                <input type="text" placeholder="apellido" name="apellido" required>
            </div>
            <div class="campo">
                <label for="dni"></label>
                <input type="text" placeholder="Ingrese Documento de Identidad" name="dni" required>
            </div>

            <div class="campo">
                <label for="fechaNacimiento" style="font-size: 1.5em;opacity: 0.6;">Fecha nacimiento</label>
                <input type="date" name="fechaNacimiento" required>
            </div>
            <div class="campo">
                <label for="direccion"></label>
                <input type="text" placeholder="Ingrese Direccion" name="direccion" required>
            </div>
            <div class="campo">
                <label for="cargo"></label>
                <input type="text" placeholder="Ingrese cargo Actual" name="cargo" required>
            </div>
            <div class="campo">
                <label for="usuario"></label>
                <input type="text" placeholder="Ingrese nombre usuario" name="usuario" required>
            </div>
            <div class="campo">
                <label for="contraseña"></label>
                <input type="password" placeholder="Ingrese contraseña" name="contrasenia" required>
            </div>


            <div class="submit">
                <input type="hidden" name="alta" value="empleado">
                <input type="submit" value="Alta Empleado" id="form_button" />
            </div>
        </form>







    </section>
</body>

</html>
