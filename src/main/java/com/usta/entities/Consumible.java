
package com.usta.entities;

import java.util.Objects;


public class Consumible {
    private Integer codConsumible;
    private String nombreConsumible;
    private String referenciaConsumible;
    private String marcaConsumible;
    private Integer cantidadConsumible;
    private String fotoConsumible;
    private String observacionConsumible;
    private Integer numeroGabineteConsumible; 

    public Consumible() {
    }

    public Consumible(Integer codConsumible, String nombreConsumible, String referenciaConsumible, String marcaConsumible, Integer cantidadConsumible, String fotoConsumible, String observacionConsumible, Integer numeroGabineteConsumible) {
        this.codConsumible = codConsumible;
        this.nombreConsumible = nombreConsumible;
        this.referenciaConsumible = referenciaConsumible;
        this.marcaConsumible = marcaConsumible;
        this.cantidadConsumible = cantidadConsumible;
        this.fotoConsumible = fotoConsumible;
        this.observacionConsumible = observacionConsumible;
        this.numeroGabineteConsumible = numeroGabineteConsumible;
    }

    public Integer getCodConsumible() {
        return codConsumible;
    }

    public void setCodConsumible(Integer codConsumible) {
        this.codConsumible = codConsumible;
    }

    public String getNombreConsumible() {
        return nombreConsumible;
    }

    public void setNombreConsumible(String nombreConsumible) {
        this.nombreConsumible = nombreConsumible;
    }

    public String getReferenciaConsumible() {
        return referenciaConsumible;
    }

    public void setReferenciaConsumible(String referenciaConsumible) {
        this.referenciaConsumible = referenciaConsumible;
    }

    public String getMarcaConsumible() {
        return marcaConsumible;
    }

    public void setMarcaConsumible(String marcaConsumible) {
        this.marcaConsumible = marcaConsumible;
    }

    public Integer getCantidadConsumible() {
        return cantidadConsumible;
    }

    public void setCantidadConsumible(Integer cantidadConsumible) {
        this.cantidadConsumible = cantidadConsumible;
    }

    public String getFotoConsumible() {
        return fotoConsumible;
    }

    public void setFotoConsumible(String fotoConsumible) {
        this.fotoConsumible = fotoConsumible;
    }

    public String getObservacionConsumible() {
        return observacionConsumible;
    }

    public void setObservacionConsumible(String observacionConsumible) {
        this.observacionConsumible = observacionConsumible;
    }

    public Integer getNumeroGabineteConsumible() {
        return numeroGabineteConsumible;
    }

    public void setNumeroGabineteConsumible(Integer numeroGabineteConsumible) {
        this.numeroGabineteConsumible = numeroGabineteConsumible;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.codConsumible);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consumible other = (Consumible) obj;
        return Objects.equals(this.codConsumible, other.codConsumible);
    }

    @Override
    public String toString() {
        return "Consumible{" + "codConsumible=" + codConsumible + ", nombreConsumible=" + nombreConsumible + ", referenciaConsumible=" + referenciaConsumible + ", marcaConsumible=" + marcaConsumible + ", cantidadConsumible=" + cantidadConsumible + ", fotoConsumible=" + fotoConsumible + ", observacionConsumible=" + observacionConsumible + ", numeroGabineteConsumible=" + numeroGabineteConsumible + '}';
    }

   
    }

    
    
    

