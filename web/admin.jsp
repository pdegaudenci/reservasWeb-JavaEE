

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

    <style type="text/css">
        h1#noLogin{
            text-align: center;
            font-size: 45px;
            color:white;
            text-decoration: underline;
            margin-top: 10%;
        }
    </style>
    <title>Pagina de Administrador</title>
</head>
    <body>
        <% HttpSession sesion=request.getSession(); 
        if(sesion.getAttribute("usuario")!=null &&sesion.getAttribute("usuario").equals("admin") ){
        %>
        <h1>Pagina Administracion</h1>
        <p>Datos de sesion:</p>
        <p>Nombre usuario: <%=sesion.getAttribute("usuario") %>
            
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
                        <li><a href="altaHabitacion.jsp">Alta Habitacion</a></li>
                        <li><a href="editarHabitaciones.jsp">Editar Habitacion</a></li>
                    </ul>
                </li>
                <li><a href="#">Reportes</a></a></li>
            </ul>

        </nav>

    </header>

                
            
            <% } else{  %>
            
            <h1 id="noLogin">NO ESTAS LOGUEADO</h1>
            <a href="index.jsp" style="  text-align: center;
            text-align: center;
               font-size: 20px;
            color:white;
            text-decoration: underline;
            margin-top: 10%;
            ">Loguearse</a>
            
            <%} %>
    </body>
</html>
