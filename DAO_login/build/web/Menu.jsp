<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index">Salir</a>
        <h1 align="center">Blog de Salud</h1>
        <p><a style="color:blue" href="Inicio?action=add">Nuevo Entrada</a></p>
        
            <c:forEach var="item" items="${blogs}">
                    <p>---------------------------------------</p>
                    <br>${item.fecha}<br>
                    <h2>${item.titulo}</h2>
                    ${item.contenido}<br>
                    
                    <br>Autor: Administrador
                    <a href="Inicio?action=edit&id=${item.id}">Editar</a>
                    <a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro'))">
                        Eliminar</a><br>
            </c:forEach>
        
    </body>
</html>
