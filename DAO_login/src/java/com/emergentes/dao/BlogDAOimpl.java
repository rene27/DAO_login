package com.emergentes.dao;

import com.emergentes.modelo.Blog;
import com.emergentes.controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOimpl extends Conexion implements BlogDAO{
    @Override
    public void insert(Blog blog) throws Exception{
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into post (fecha, titulo, contenido) values(?,?,?)");
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
            
        }finally{
            this.desconectar();
        }
    }
    
    @Override
    public void update(Blog blog) throws Exception{
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE post set fecha=?, titulo=?, contenido=? where id=?");
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setInt(4, blog.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }
    @Override
    public void delete(int id) throws Exception{
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE from post where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }
    @Override
    public Blog getById(int id) throws Exception{
        Blog bg = new Blog();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * from post Where id=? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bg.setId(rs.getInt("id"));
                bg.setFecha(rs.getString("fecha"));
                bg.setTitulo(rs.getString("titulo"));
                bg.setContenido(rs.getString("contenido"));
            }
        }catch (Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return bg;
    }
    @Override
    public List<Blog> getAll() throws Exception{
        List<Blog> lista=null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * from post");
            ResultSet rs= ps.executeQuery();
            
            lista=new ArrayList<Blog>();
            while(rs.next()){
            Blog bg = new Blog();
            bg.setId(rs.getInt("id"));
            bg.setFecha(rs.getString("fecha"));
            bg.setTitulo(rs.getString("titulo"));
            bg.setContenido(rs.getString("contenido"));
            lista.add(bg);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
}
