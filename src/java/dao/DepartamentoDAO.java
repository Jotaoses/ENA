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
import modelos.Departamento;

/**
 *
 * @author DellPC
 */
public class DepartamentoDAO extends Conexion {
    
    public Departamento obtenerDepartamento(int id) throws SQLException{
        String sentencia = "select * from departamento where id=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Departamento(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public Departamento obtenerDepartamento(String nombre) throws SQLException{
        String sentencia = "select * from departamento where nombre=?";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Departamento(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Departamento> obtenerDepartamentos() throws SQLException{
        String sentencia = "select * from departamento";
        try{
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Departamento> departamentos = new ArrayList();
            while(rs.next()){
                departamentos.add(new Departamento(rs.getInt("id"),rs.getString("nombre")));
            }
            return departamentos;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
