<%-- 
    Document   : login
    Created on : 21-mar-2022, 16:02:57
    Author     : pdega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="author" content="Pedro Sebastian Degaudenci Ferreira">
    <meta name="descripcion" content="Pagina sobre comidas regionales">
    <meta name="keywords" content="españa,comunidades autonomomas,comidas regionales">
    <meta name="date" content="2022-02-14T23:59:00+00:00">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="formulario.css" type="text/css">
    <title>Administracion Hotel</title>

    <style type="text/css">
        header h2 {
            text-align: center;
            color: grey;
            font-size: 5em;
            position: absolute;
            top: 30px;
            left: 700px;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            margin-bottom: 20px;
        }

        #boton {
            text-align: center;
        }
    </style>
</head>

<body>

    <header>

        <h2>Login</h2>

    </header>
    <section>
        <div id="formulario">



            <form action="SvLogin" method="POST" >
                <div><label for="nombreUsuario">Usuario</label>
                    <input type="text" class="texto" name="nombreUsuario" size="50"
                        placeholder="Ingresa tu nombre de Usuario" maxlength="50" required>
                </div>
                <div>
                    <label for="contrasenia">Contrase&ntilde;a</label>
                    <input type="password" class="texto" name="contrasenia" size="50" maxlength="50" required>
                </div>

                <div id="boton">

                    <input type=submit value="Ingresar" class="boton">

                </div>

            </form>

        </div>
    </section>

</body>

</html>
