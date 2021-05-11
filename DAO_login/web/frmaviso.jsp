<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${blog.id == 0}">Nuevo</c:if>
            <c:if test="${blog.id != 0}">Editar</c:if>
            Blog
        </h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${blog.id}"/>
        <table>
            <tr>
                <td>Fecha:</td>
                <td><input type="date" name="fecha" value="${blog.fecha}"/></td>
            </tr>
            <tr>
                <td>Titulo:</td>
                <td><input type="text" name="titulo" value="${blog.titulo}"/></td>
            </tr>
            <tr>
                <td>Contenido:</td>
                <td><textarea name="contenido" rows="4" cols="20">${blog.contenido}
                    </textarea></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"/></td>
            </tr>
        </table> 
        </form>
    </body>
</html>
