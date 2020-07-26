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
import modelos.Encargado;

/**
 *
 * @author DellPC
 */
public class EncargadoDAO extends Conexion {
    public Encargado obtenerEncargado(int id) throws SQLException{
        String sentencia = "select * from encargado where id=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Encargado(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public Encargado obtenerEncargado(String nombre) throws SQLException{
        String sentencia = "select * encargado where nombre=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Encargado(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Encargado> obtenerEncargados() throws SQLException{
        String sentencia = "select * from encargado";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Encargado> encargados = new ArrayList();
            while(rs.next()){
                encargados.add(new Encargado(rs.getInt("id"),rs.getString("nombre")));
            }
            return encargados;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
