
package com.usta.entities;

import java.util.Objects;


public class Elemento {
    
    private Integer codElemento;
    private String nombreElemento;
    private String inventarioElemento;
    private Integer cantidadElemento;
    private String referenciaElemento;


    public Elemento() {
    }

    public Elemento(Integer codElemento, String nombreElemento, String inventarioElemento, Integer cantidadElemento, String referenciaElemento) {
        this.codElemento = codElemento;
        this.nombreElemento = nombreElemento;
        this.inventarioElemento = inventarioElemento;
        this.cantidadElemento = cantidadElemento;
        this.referenciaElemento = referenciaElemento;
    }

    public Elemento(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getCodElemento() {
        return codElemento;
    }

    public void setCodElemento(Integer codElemento) {
        this.codElemento = codElemento;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public String getInventarioElemento() {
        return inventarioElemento;
    }

    public void setInventarioElemento(String inventarioElemento) {
        this.inventarioElemento = inventarioElemento;
    }

    public Integer getCantidadElemento() {
        return cantidadElemento;
    }

    public void setCantidadElemento(Integer cantidadElemento) {
        this.cantidadElemento = cantidadElemento;
    }

    public String getReferenciaElemento() {
        return referenciaElemento;
    }

    public void setReferenciaElemento(String referenciaElemento) {
        this.referenciaElemento = referenciaElemento;
    }

    @Override
    public String toString() {
        return "Elemento{" + "codElemento=" + codElemento + ", nombreElemento=" + nombreElemento + ", inventarioElemento=" + inventarioElemento + ", cantidadElemento=" + cantidadElemento + ", referenciaElemento=" + referenciaElemento + '}';
    }

    


    
    
}
