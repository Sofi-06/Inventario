
package com.usta.entities;

import java.util.Objects;


public class Equipo {
    
    private Integer codEquipo;
    private String nombreEquipo;
    private String inventarioEquipo;
    private String modeloEquipo;
    private String serieEquipo;
    private String marcaEquipo;
    private String mantemimientoEquipo;
    private String reqMantemimientoEquipo;
    private String estadoEquipo;

    public Equipo() {
    }

    public Equipo(Integer codEquipo, String nombreEquipo, String inventarioEquipo, String modeloEquipo, String serieEquipo, String marcaEquipo, String mantemimientoEquipo, String reqMantemimientoEquipo, String estadoEquipo) {
        this.codEquipo = codEquipo;
        this.nombreEquipo = nombreEquipo;
        this.inventarioEquipo = inventarioEquipo;
        this.modeloEquipo = modeloEquipo;
        this.serieEquipo = serieEquipo;
        this.marcaEquipo = marcaEquipo;
        this.mantemimientoEquipo = mantemimientoEquipo;
        this.reqMantemimientoEquipo = reqMantemimientoEquipo;
        this.estadoEquipo = estadoEquipo;
    }

  

    public Integer getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getInventarioEquipo() {
        return inventarioEquipo;
    }

    public void setInventarioEquipo(String inventarioEquipo) {
        this.inventarioEquipo = inventarioEquipo;
    }

    public String getModeloEquipo() {
        return modeloEquipo;
    }

    public void setModeloEquipo(String modeloEquipo) {
        this.modeloEquipo = modeloEquipo;
    }

    public String getSerieEquipo() {
        return serieEquipo;
    }

    public void setSerieEquipo(String serieEquipo) {
        this.serieEquipo = serieEquipo;
    }

    public String getMarcaEquipo() {
        return marcaEquipo;
    }

    public void setMarcaEquipo(String marcaEquipo) {
        this.marcaEquipo = marcaEquipo;
    }

    public String getMantemimientoEquipo() {
        return mantemimientoEquipo;
    }

    public void setMantemimientoEquipo(String mantemimientoEquipo) {
        this.mantemimientoEquipo = mantemimientoEquipo;
    }

    public String getReqMantemimientoEquipo() {
        return reqMantemimientoEquipo;
    }

    public void setReqMantemimientoEquipo(String reqMantemimientoEquipo) {
        this.reqMantemimientoEquipo = reqMantemimientoEquipo;
    }
    

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codEquipo);
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
        final Equipo other = (Equipo) obj;
        return Objects.equals(this.codEquipo, other.codEquipo);
    }

    @Override
    public String toString() {
        return "Equipo{" + "codEquipo=" + codEquipo + ", nombreEquipo=" + nombreEquipo + ", inventarioEquipo=" + inventarioEquipo + ", modeloEquipo=" + modeloEquipo + ", serieEquipo=" + serieEquipo + ", marcaEquipo=" + marcaEquipo + ", mantemimientoEquipo=" + mantemimientoEquipo + ", estadoEquipo=" + estadoEquipo + '}';
    }
    
    

}
