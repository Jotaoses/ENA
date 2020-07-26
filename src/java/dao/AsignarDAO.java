/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Asignar;

/**
 *
 * @author DellPC
 */
public class AsignarDAO extends Conexion {
    
    public Asignar obtenerAsignar(int id) throws SQLException{
        String sentencia = "select * from asignar where id=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Asignar(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public Asignar obtenerAsignar(String nombre) throws SQLException{
        String sentencia = "select * from asignar where nombre=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Asignar(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Asignar> obtenerAsignados() throws SQLException{
        String sentencia = "select * from asignar";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Asignar> asignados = new ArrayList();
            while(rs.next()){
                asignados.add(new Asignar(rs.getInt("id"),rs.getString("nombre")));
            }
            return asignados;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
