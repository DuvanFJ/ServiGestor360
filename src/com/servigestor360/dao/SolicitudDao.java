package com.servigestor360.dao;

import com.servigestor360.config.ConexionBD;
import com.servigestor360.model.Solicitud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolicitudDao {

    // =========================
    // VALIDAR SALA
    // =========================
    private boolean salaDisponible(String sala, String fecha, String hora) {

        String sql = "SELECT * FROM solicitud WHERE sala = ? AND fechaCreacion = ? AND horaSolicitud = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, sala);
            stmt.setString(2, fecha);
            stmt.setString(3, hora);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return false; // ocupada
            }

        } catch (SQLException e) {
            System.out.println("Error al validar sala: " + e.getMessage());
        }

        return true;
    }

    // =========================
    // INSERTAR SOLICITUD
    // =========================
    public void insertarSolicitud(Solicitud solicitud) {

        // VALIDACIÓN 1: MOTIVO
        if (solicitud.getMotivo() == null || solicitud.getMotivo().trim().isEmpty()) {
            System.out.println("El motivo no puede estar vacío.");
            return;
        }

        // VALIDACIÓN 2: FECHA
        String fechaActual = java.time.LocalDate.now().toString();

        if (solicitud.getFechaCreacion().compareTo(fechaActual) < 0) {
            System.out.println("No puedes registrar una fecha pasada.");
            return;
        }

        // VALIDACIÓN 3: HORA
        if (!solicitud.getHoraSolicitud().matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            System.out.println("Formato de hora inválido. Usa HH:MM");
            return;
        }

        // VALIDAR SALA
        boolean disponible = salaDisponible(
                solicitud.getSala(),
                solicitud.getFechaCreacion(),
                solicitud.getHoraSolicitud()
        );

        if (!disponible) {
            System.out.println("Sala ocupada en esa fecha y hora.");
            return;
        }

        // VALIDACIÓN DE LÓGICA (APROBADO / RECHAZADO)
        String motivo = solicitud.getMotivo().toLowerCase();

        if (motivo.contains("estudio") ||
            motivo.contains("clase") ||
            motivo.contains("proyecto") ||
            motivo.contains("examen")) {

            solicitud.setEstado("Aprobado");

        } else {
            solicitud.setEstado("Rechazado");
        }

        String sql = "INSERT INTO solicitud (idCliente, fechaCreacion, horaSolicitud, descripcionProblema, direccionServicio, prioridad, motivo, observaciones, sala, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, solicitud.getIdCliente());
            stmt.setString(2, solicitud.getFechaCreacion());
            stmt.setString(3, solicitud.getHoraSolicitud());
            stmt.setString(4, solicitud.getDescripcionProblema());
            stmt.setString(5, solicitud.getDireccionServicio());
            stmt.setString(6, solicitud.getPrioridad());
            stmt.setString(7, solicitud.getMotivo());
            stmt.setString(8, solicitud.getObservaciones());
            stmt.setString(9, solicitud.getSala());
            stmt.setString(10, solicitud.getEstado());

            stmt.executeUpdate();

            System.out.println("Solicitud registrada con estado: " + solicitud.getEstado());

        } catch (SQLException e) {
            System.out.println("Error al insertar solicitud: " + e.getMessage());
        }
    }

    // =========================
    // LISTAR TODAS
    // =========================
    public void listarSolicitudes() {

        String sql = "SELECT * FROM solicitud";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("idSolicitud"));
                System.out.println("Cliente: " + rs.getInt("idCliente"));
                System.out.println("Fecha: " + rs.getString("fechaCreacion"));
                System.out.println("Hora: " + rs.getString("horaSolicitud"));
                System.out.println("Sala: " + rs.getString("sala"));
                System.out.println("Motivo: " + rs.getString("motivo"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar solicitudes: " + e.getMessage());
        }
    }

    // =========================
    // LISTAR POR CLIENTE
    // =========================
    public void listarSolicitudesPorCliente(int idCliente) {

        String sql = "SELECT * FROM solicitud WHERE idCliente = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("idSolicitud"));
                System.out.println("Fecha: " + rs.getString("fechaCreacion"));
                System.out.println("Hora: " + rs.getString("horaSolicitud"));
                System.out.println("Sala: " + rs.getString("sala"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}