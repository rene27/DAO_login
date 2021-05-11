package com.emergentes.controlador;
    import java.sql.*;
public class Conexion {
    static String url="jdbc:mysql://localhost:3306/bd_blog";
    static String usuario="root";
    static String password="";
    protected Connection conn=null;

    public Conexion(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url, usuario, password);
        if (conn !=null) {
            System.out.println("Conexion ok:"+ conn);
            }
        }catch (SQLException ex){
            System.out.println("Error de SQL:"+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            System.out.println("Error de SQL:"+ ex.getMessage());
        }
    }
    public Connection conectar(){
    return conn;
    }
    
    public void desconectar(){
    System.out.println("Cerrando la BD: "+conn);
    try{
            conn.close();
        }catch (SQLException ex){
            System.out.println("Error de SQL: "+ ex.getMessage());
        }
    }
    public Connection getConnection(){
        return conn;
    }
}
