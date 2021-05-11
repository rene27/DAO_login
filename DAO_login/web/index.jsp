<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
    </head>
    <body>
        <h1>Inicio de Login</h1>
        <form action="IniciarSesion" method="post">
            Nombre:
            <input type="text" name="usuario"><br>
            Contraseña:
            <input type="password" name="password"><br>
            <input type="submit" value="inicio">
        </form>
    </body>
</html>
