package com.emergentes.controlador;
import com.emergentes.dao.BlogDAOimpl;
import com.emergentes.modelo.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.BlogDAO;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try{
          BlogDAO dao= new BlogDAOimpl();
          int id;
          Blog bg= new Blog();
          String action=(request.getParameter("action") !=null) ? request.getParameter("action") : "view";
          
          switch(action){
              case "add":
                  request.setAttribute("blog", bg);
                  request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                  break;
              case "edit":
                  id= Integer.parseInt(request.getParameter("id"));
                  bg= dao.getById(id);
                  System.out.println(bg);
                  request.setAttribute("blog", bg);
                  request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                  break;
              case "delete":
                  id=Integer.parseInt(request.getParameter("id"));
                  dao.delete(id);
                  response.sendRedirect(request.getContextPath()+"/Inicio");
                  break;
              case "view":
                  List<Blog> lista = dao.getAll();
                  request.setAttribute("blogs", lista);
                  request.getRequestDispatcher("Menu.jsp").forward(request, response);
              default:
                  break;
          }
      }catch (Exception ex){
          System.out.println("Error "+ ex.getMessage());
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id=Integer.parseInt(request.getParameter("id"));
       String fecha=request.getParameter("fecha");
       String titulo=request.getParameter("titulo");
       String contenido= request.getParameter("contenido");
       
       Blog bg= new Blog();
       bg.setId(id);
       bg.setFecha(fecha);
       bg.setTitulo(titulo);
       bg.setContenido(contenido);
       
       if (id==0){
           try{
               BlogDAO dao= new BlogDAOimpl();
               dao.insert(bg);
               response.sendRedirect(request.getContextPath()+ "/Inicio");
               
           }catch (Exception ex){
               System.out.println("Error " + ex.getMessage());
           }
       }
       else{
           try{
               BlogDAO dao=new BlogDAOimpl();
               dao.update(bg);
               response.sendRedirect(request.getContextPath()+"/Inicio");
           }catch (Exception ex){
               System.out.println("Error "+ ex.getMessage());
           }
       }
    }
}
