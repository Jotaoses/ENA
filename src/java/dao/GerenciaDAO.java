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
import modelos.Gerencia;

/**
 *
 * @author DellPC
 */
public class GerenciaDAO extends Conexion {
    
    
    public Gerencia obtenerGerencia(int id) throws SQLException{
        String sentencia = "select * from gerencia where id=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Gerencia(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public Gerencia obtenerGerencia(String nombre) throws SQLException{
        String sentencia = "select * from gerencia where nombre=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Gerencia(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Gerencia> obtenerGerencias() throws SQLException{
        String sentencia = "select * from gerencia";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Gerencia> gerencias = new ArrayList();
            while(rs.next()){
                gerencias.add(new Gerencia(rs.getInt("id"),rs.getString("nombre")));
            }
            return gerencias;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
