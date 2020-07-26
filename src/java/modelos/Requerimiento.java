/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author DellPC
 */
public class Requerimiento {
    private long codigo;
    private Gerencia gerencia;
    private String descripcion;
    
  public Requerimiento(){}

    public Requerimiento(long codigo, Gerencia gerencia, String descripcion) {
        this.codigo = codigo;
        this.gerencia = gerencia;
        this.descripcion = descripcion;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Gerencia getGerencia() {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
  
}
