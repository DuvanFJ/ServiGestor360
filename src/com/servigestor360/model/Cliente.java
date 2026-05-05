package com.servigestor360.model;

public class Cliente {

    private int idCliente;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String correoElectronico;
    private String direccion;
    private boolean activo;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor SIN id (para insertar)
    public Cliente(String nombres, String apellidos, String tipoDocumento,
                   String numeroDocumento, String telefono,
                   String correoElectronico, String direccion, boolean activo) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.activo = activo;
    }

    // Constructor CON id (para actualizar)
    public Cliente(int idCliente, String nombres, String apellidos, String tipoDocumento,
                   String numeroDocumento, String telefono,
                   String correoElectronico, String direccion, boolean activo) {

        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.activo = activo;
    }

    // ===== GETTERS =====

    public int getIdCliente() {
        return idCliente;
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

    public String getDireccion() {
        return direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    // ===== SETTERS =====

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}