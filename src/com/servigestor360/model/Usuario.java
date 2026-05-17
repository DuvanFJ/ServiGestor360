package com.servigestor360.model;

public class Usuario {

    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String correoElectronico;
    private String rol;
    private boolean activo;

    // =========================
    // CONSTRUCTOR VACÍO
    // =========================
    public Usuario() {
    }

    // =========================
    // CONSTRUCTOR SIN ID
    // =========================
    public Usuario(String nombres, String apellidos,
                   String tipoDocumento, String numeroDocumento,
                   String telefono, String correoElectronico,
                   String rol, boolean activo) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
        this.activo = activo;
    }

    // =========================
    // CONSTRUCTOR CON ID
    // =========================
    public Usuario(int idUsuario, String nombres, String apellidos,
                   String tipoDocumento, String numeroDocumento,
                   String telefono, String correoElectronico,
                   String rol, boolean activo) {

        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
        this.activo = activo;
    }

    // =========================
    // GETTERS
    // =========================

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getRol() {
        return rol;
    }

    public boolean isActivo() {
        return activo;
    }

    // =========================
    // SETTERS
    // =========================

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}