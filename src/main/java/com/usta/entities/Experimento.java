package com.usta.entities;

import java.util.Date;
import java.util.Objects;

public class Experimento {

    private Integer codExperimento;
    private String codInventario;
    private String nombreExperimento;
    private String marcaExperimento;
    private String fotoExperimento;
    private Boolean manualExperimento;
    private String actaExperimento;
    private Integer costoExperimento;
    private Date fechaCompraExperimento;

    public Experimento() {
    }

    public Experimento(Integer codExperimento, String codInventario, String nombreExperimento, String marcaExperimento, String fotoExperimento, Boolean manualExperimento, String actaExperimento, Integer costoExperimento, Date fechaCompraExperimento) {
        this.codExperimento = codExperimento;
        this.codInventario = codInventario;
        this.nombreExperimento = nombreExperimento;
        this.marcaExperimento = marcaExperimento;
        this.fotoExperimento = fotoExperimento;
        this.manualExperimento = manualExperimento;
        this.actaExperimento = actaExperimento;
        this.costoExperimento = costoExperimento;
        this.fechaCompraExperimento = fechaCompraExperimento;
    }

    public Integer getCodExperimento() {
        return codExperimento;
    }

    public void setCodExperimento(Integer codExperimento) {
        this.codExperimento = codExperimento;
    }

    public String getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(String codInventario) {
        this.codInventario = codInventario;
    }

    public String getNombreExperimento() {
        return nombreExperimento;
    }

    public void setNombreExperimento(String nombreExperimento) {
        this.nombreExperimento = nombreExperimento;
    }



    public String getMarcaExperimento() {
        return marcaExperimento;
    }

    public void setMarcaExperimento(String marcaExperimento) {
        this.marcaExperimento = marcaExperimento;
    }

    public String getFotoExperimento() {
        return fotoExperimento;
    }

    public void setFotoExperimento(String fotoExperimento) {
        this.fotoExperimento = fotoExperimento;
    }

    public Boolean getManualExperimento() {
        return manualExperimento;
    }

    public void setManualExperimento(Boolean manualExperimento) {
        this.manualExperimento = manualExperimento;
    }

    public String getActaExperimento() {
        return actaExperimento;
    }

    public void setActaExperimento(String actaExperimento) {
        this.actaExperimento = actaExperimento;
    }

    public Integer getCostoExperimento() {
        return costoExperimento;
    }

    public void setCostoExperimento(Integer costoExperimento) {
        this.costoExperimento = costoExperimento;
    }

    public Date getFechaCompraExperimento() {
        return fechaCompraExperimento;
    }

    public void setFechaCompraExperimento(Date fechaCompraExperimento) {
        this.fechaCompraExperimento = fechaCompraExperimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codExperimento);
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
        final Experimento other = (Experimento) obj;
        return Objects.equals(this.codExperimento, other.codExperimento);
    }

}
