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
import modelos.Requerimiento;

/**
 *
 * @author DellPC
 */
public class RequerimientoDAO extends Conexion {
    public int registrar(Requerimiento requerimiento) throws SQLException{
        try{
            String sentencia ="Insert into requerimiento values (?,?,?)";
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, requerimiento.getCodigo());
            ps.setInt(2, requerimiento.getGerencia().getId());
            ps.setString(3, requerimiento.getDescripcion());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    
    public Requerimiento obtenerRequerimiento(long codigo) throws SQLException{
        try{
            String sentencia = "select * from requerimiento where codigo = ?";
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            Requerimiento po = null;
            GerenciaDAO gd = new GerenciaDAO();
            if(rs.next()){
                po = new Requerimiento(rs.getLong("codigo"),gd.obtenerGerencia(rs.getInt("id")),rs.getString("descripcion"));
            }
            
            return po;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public ArrayList<Requerimiento> obtenerRequerimientos() throws SQLException{
        try{
            String sentencia = "select * from requerimiento";
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Requerimiento> requerimientos = new ArrayList();
            while(rs.next()){
                Gerencia gd = new Gerencia(rs.getInt("id"),rs.getString("nombre"));
                requerimientos.add(new Requerimiento(rs.getLong("codigo"),gd,rs.getString("descripcion")));
            }
            return requerimientos;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
