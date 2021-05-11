package com.emergentes.controlador;

import java.sql.*;

public class Consultas extends Conexion{
    
    public boolean autentificacion(String usuario, String contraseña){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta = "select * from usuarios where usuario=? and password=?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            if(rs.absolute(1)){
                return true;
            }
        }catch (Exception e){
            System.out.println("Error "+e);
        }finally{
            try{
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }catch (Exception e){
                System.out.println("Error "+e);
            }  
        }
        return false;
    }
    //public static void main(String[] args) {
    //    Consultas co = new Consultas();
    //    System.out.println(co.autentificacion("rene", "123"));
    //}

}


