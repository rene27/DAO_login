package com.emergentes.proceso;

import com.emergentes.controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("password");
        
        Consultas co = new Consultas();
        if(co.autentificacion(usuario, contraseña)){
            response.sendRedirect("Menu.jsp");
        }
        else{
            response.sendRedirect("index.jsp");
        }
        }
    
}
