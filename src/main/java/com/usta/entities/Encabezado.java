
package com.usta.entities;

import java.util.Date;
import java.util.Objects;


public class Encabezado {
    private Integer codEncabezado;
    private String edificioEncabezado;
    private String laboratorioEncabezado;
    private String semestreEncabezado;
    private Date fechaActualizacionEncabezado;
    private Persona codPersona;

    public Encabezado() {
    }

    public Encabezado(Integer codEncabezado, String edificioEncabezado, String laboratorioEncabezado, String semestreEncabezado, Date fechaActualizacionEncabezado, Persona codPersona) {
        this.codEncabezado = codEncabezado;
        this.edificioEncabezado = edificioEncabezado;
        this.laboratorioEncabezado = laboratorioEncabezado;
        this.semestreEncabezado = semestreEncabezado;
        this.fechaActualizacionEncabezado = fechaActualizacionEncabezado;
        this.codPersona = codPersona;
    }


    public Integer getCodEncabezado() {
        return codEncabezado;
    }

    public void setCodEncabezado(Integer codEncabezado) {
        this.codEncabezado = codEncabezado;
    }

    public String getEdificioEncabezado() {
        return edificioEncabezado;
    }

    public void setEdificioEncabezado(String edificioEncabezado) {
        this.edificioEncabezado = edificioEncabezado;
    }

    public String getLaboratorioEncabezado() {
        return laboratorioEncabezado;
    }

    public void setLaboratorioEncabezado(String laboratorioEncabezado) {
        this.laboratorioEncabezado = laboratorioEncabezado;
    }

    public String getSemestreEncabezado() {
        return semestreEncabezado;
    }

    public void setSemestreEncabezado(String semestreEncabezado) {
        this.semestreEncabezado = semestreEncabezado;
    }

    public Date getFechaActualizacionEncabezado() {
        return fechaActualizacionEncabezado;
    }

    public void setFechaActualizacionEncabezado(Date fechaActualizacionEncabezado) {
        this.fechaActualizacionEncabezado = fechaActualizacionEncabezado;
    }

  

    public Persona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Persona codPersona) {
        this.codPersona = codPersona;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.codEncabezado);
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
        final Encabezado other = (Encabezado) obj;
        return Objects.equals(this.codEncabezado, other.codEncabezado);
    }

    @Override
    public String toString() {
        return "Encabezado{" + "codEncabezado=" + codEncabezado + ", edificioEncabezado=" + edificioEncabezado + ", laboratorioEncabezado=" + laboratorioEncabezado + ", semestreEncabezado=" + semestreEncabezado + ", fechaActualizacionEncabezado=" + fechaActualizacionEncabezado + ", codPersona=" + codPersona + '}';
    }
    
    
    
    
}
