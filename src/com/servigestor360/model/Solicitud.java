package com.servigestor360.model;

public class Solicitud {

    private int idSolicitud;
    private int idCliente;
    private String fechaCreacion;
    private String horaSolicitud;
    private String descripcionProblema;
    private String direccionServicio;
    private String prioridad;
    private String motivo;
    private String observaciones;
    private String sala;
    private String estado;

    // =========================
    // CONSTRUCTOR VACÍO
    // =========================
    public Solicitud() {
    }

    // =========================
    // CONSTRUCTOR SIN ID (INSERTAR)
    // =========================
    public Solicitud(int idCliente, String fechaCreacion, String horaSolicitud,
                     String descripcionProblema, String direccionServicio,
                     String prioridad, String motivo, String observaciones,
                     String sala, String estado) {

        this.idCliente = idCliente;
        this.fechaCreacion = fechaCreacion;
        this.horaSolicitud = horaSolicitud;
        this.descripcionProblema = descripcionProblema;
        this.direccionServicio = direccionServicio;
        this.prioridad = prioridad;
        this.motivo = motivo;
        this.observaciones = observaciones;
        this.sala = sala;
        this.estado = estado;
    }

    // =========================
    // CONSTRUCTOR CON ID (ACTUALIZAR)
    // =========================
    public Solicitud(int idSolicitud, int idCliente, String fechaCreacion, String horaSolicitud,
                     String descripcionProblema, String direccionServicio,
                     String prioridad, String motivo, String observaciones,
                     String sala, String estado) {

        this.idSolicitud = idSolicitud;
        this.idCliente = idCliente;
        this.fechaCreacion = fechaCreacion;
        this.horaSolicitud = horaSolicitud;
        this.descripcionProblema = descripcionProblema;
        this.direccionServicio = direccionServicio;
        this.prioridad = prioridad;
        this.motivo = motivo;
        this.observaciones = observaciones;
        this.sala = sala;
        this.estado = estado;
    }

    // =========================
    // NORMALIZAR DATOS (MEJORA)
    // =========================
    public void normalizarDatos() {
        if (motivo != null) {
            motivo = motivo.trim().toLowerCase();
        }
        if (sala != null) {
            sala = sala.trim();
        }
    }

    // =========================
    // GETTERS
    // =========================

    public int getIdSolicitud() { return idSolicitud; }
    public int getIdCliente() { return idCliente; }
    public String getFechaCreacion() { return fechaCreacion; }
    public String getHoraSolicitud() { return horaSolicitud; }
    public String getDescripcionProblema() { return descripcionProblema; }
    public String getDireccionServicio() { return direccionServicio; }
    public String getPrioridad() { return prioridad; }
    public String getMotivo() { return motivo; }
    public String getObservaciones() { return observaciones; }
    public String getSala() { return sala; }
    public String getEstado() { return estado; }

    // =========================
    // SETTERS
    // =========================

    public void setIdSolicitud(int idSolicitud) { this.idSolicitud = idSolicitud; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public void setHoraSolicitud(String horaSolicitud) { this.horaSolicitud = horaSolicitud; }
    public void setDescripcionProblema(String descripcionProblema) { this.descripcionProblema = descripcionProblema; }
    public void setDireccionServicio(String direccionServicio) { this.direccionServicio = direccionServicio; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public void setSala(String sala) { this.sala = sala; }
    public void setEstado(String estado) { this.estado = estado; }
}