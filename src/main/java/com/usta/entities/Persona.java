
package com.usta.entities;


public class Persona {
    private Integer codPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String documentoPersona;
    private String correoPersona;
    private String telefonoPersona;
    private String usuarioPersona;
    private String contrasennaPersona;
    private String nivelAccesoPersona;

    public Persona() {
    }

    public Persona(Integer codPersona, String nombrePersona, String apellidoPersona, String documentoPersona, String correoPersona, String telefonoPersona, String usuarioPersona, String contrasennaPersona, String nivelAccesoPersona) {
        this.codPersona = codPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.documentoPersona = documentoPersona;
        this.correoPersona = correoPersona;
        this.telefonoPersona = telefonoPersona;
        this.usuarioPersona = usuarioPersona;
        this.contrasennaPersona = contrasennaPersona;
        this.nivelAccesoPersona = nivelAccesoPersona;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getDocumentoPersona() {
        return documentoPersona;
    }

    public void setDocumentoPersona(String documentoPersona) {
        this.documentoPersona = documentoPersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getUsuarioPersona() {
        return usuarioPersona;
    }

    public void setUsuarioPersona(String usuarioPersona) {
        this.usuarioPersona = usuarioPersona;
    }

    public String getContrasennaPersona() {
        return contrasennaPersona;
    }

    public void setContrasennaPersona(String contrasennaPersona) {
        this.contrasennaPersona = contrasennaPersona;
    }

    public String getNivelAccesoPersona() {
        return nivelAccesoPersona;
    }

    public void setNivelAccesoPersona(String nivelAccesoPersona) {
        this.nivelAccesoPersona = nivelAccesoPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "codPersona=" + codPersona + ", nombrePersona=" + nombrePersona + ", apellidoPersona=" + apellidoPersona + ", documentoPersona=" + documentoPersona + ", correoPersona=" + correoPersona + ", telefonoPersona=" + telefonoPersona + ", usuarioPersona=" + usuarioPersona + ", contrasennaPersona=" + contrasennaPersona + ", nivelAccesoPersona=" + nivelAccesoPersona + '}';
    }

    
    
}
