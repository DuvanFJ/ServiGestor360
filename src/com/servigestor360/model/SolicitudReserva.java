package com.servigestor360.model;

public class SolicitudReserva {

    private int idReserva;
    private int idUsuario;
    private String fechaReserva;
    private String horaReserva;
    private String motivo;
    private String espacio;
    private String estado;

    // =========================
    // CONSTRUCTOR VACÍO
    // =========================
    public SolicitudReserva() {
    }

    // =========================
    // CONSTRUCTOR SIN ID
    // =========================
    public SolicitudReserva(int idUsuario, String fechaReserva,
                            String horaReserva, String motivo,
                            String espacio, String estado) {

        this.idUsuario = idUsuario;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.motivo = motivo;
        this.espacio = espacio;
        this.estado = estado;
    }

    // =========================
    // CONSTRUCTOR CON ID
    // =========================
    public SolicitudReserva(int idReserva, int idUsuario,
                            String fechaReserva, String horaReserva,
                            String motivo, String espacio,
                            String estado) {

        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.motivo = motivo;
        this.espacio = espacio;
        this.estado = estado;
    }

    // =========================
    // GETTERS
    // =========================

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getEspacio() {
        return espacio;
    }

    public String getEstado() {
        return estado;
    }

    // =========================
    // SETTERS
    // =========================

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}