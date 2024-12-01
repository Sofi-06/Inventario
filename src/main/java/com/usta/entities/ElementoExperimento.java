package com.usta.entities;

import java.util.Objects;

public class ElementoExperimento {

    private Integer codElementoExperimento;
    private Elemento codElemento;
    private Experimento codExperimento;
    private Integer cantAccesorios;

    public ElementoExperimento() {
    }

    public ElementoExperimento(Integer codElementoExperimento, Elemento codElemento, Experimento codExperimento, Integer cantAccesorios) {
        this.codElementoExperimento = codElementoExperimento;
        this.codElemento = codElemento;
        this.codExperimento = codExperimento;
        this.cantAccesorios = cantAccesorios;
    }

    public Integer getCodElementoExperimento() {
        return codElementoExperimento;
    }

    public void setCodElementoExperimento(Integer codElementoExperimento) {
        this.codElementoExperimento = codElementoExperimento;
    }



    public Elemento getCodElemento() {
        return codElemento;
    }

    public void setCodElemento(Elemento codElemento) {
        this.codElemento = codElemento;
    }

    public Experimento getCodExperimento() {
        return codExperimento;
    }

    public void setCodExperimento(Experimento codExperimento) {
        this.codExperimento = codExperimento;
    }

    public Integer getCantAccesorios() {
        return cantAccesorios;
    }

    public void setCantAccesorios(Integer cantAccesorios) {
        this.cantAccesorios = cantAccesorios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codElemento);
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
        final ElementoExperimento other = (ElementoExperimento) obj;
        return Objects.equals(this.codElemento, other.codElemento);
    }

    @Override
    public String toString() {
        return "ElementoExperimento{" + "codElemento=" + codElemento + ", codExperimento=" + codExperimento + ", cantAccesorios=" + cantAccesorios + '}';
    }

}
