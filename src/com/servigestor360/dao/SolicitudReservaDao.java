package com.servigestor360.dao;

import com.servigestor360.config.ConexionBD;
import com.servigestor360.model.SolicitudReserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolicitudReservaDao {

    // =========================
    // VALIDAR DISPONIBILIDAD
    // =========================
    private boolean espacioDisponible(String espacio,
                                      String fecha,
                                      String hora) {

        String sql = "SELECT * FROM solicitud_reserva WHERE espacio = ? AND fechaReserva = ? AND horaReserva = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, espacio);
            stmt.setString(2, fecha);
            stmt.setString(3, hora);

            ResultSet rs = stmt.executeQuery();

            return !rs.next();

        } catch (SQLException e) {
            System.out.println("Error al validar espacio: " + e.getMessage());
        }

        return false;
    }

    // =========================
    // INSERTAR RESERVA
    // =========================
    public void insertarReserva(SolicitudReserva reserva) {

        boolean disponible = espacioDisponible(
                reserva.getEspacio(),
                reserva.getFechaReserva(),
                reserva.getHoraReserva()
        );

        if (!disponible) {
            System.out.println("El espacio ya está reservado.");
            return;
        }

        String motivo = reserva.getMotivo().toLowerCase();

        if (motivo.contains("clase") ||
            motivo.contains("estudio") ||
            motivo.contains("reunion") ||
            motivo.contains("proyecto")) {

            reserva.setEstado("Aprobada");

        } else {
            reserva.setEstado("Pendiente");
        }

        String sql = "INSERT INTO solicitud_reserva (idUsuario, fechaReserva, horaReserva, motivo, espacio, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getIdUsuario());
            stmt.setString(2, reserva.getFechaReserva());
            stmt.setString(3, reserva.getHoraReserva());
            stmt.setString(4, reserva.getMotivo());
            stmt.setString(5, reserva.getEspacio());
            stmt.setString(6, reserva.getEstado());

            stmt.executeUpdate();

            System.out.println("Reserva registrada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar reserva: " + e.getMessage());
        }
    }

    // =========================
    // LISTAR RESERVAS
    // =========================
    public void listarReservas() {

        String sql = "SELECT * FROM solicitud_reserva";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                System.out.println("ID Reserva: " + rs.getInt("idReserva"));
                System.out.println("Usuario: " + rs.getInt("idUsuario"));
                System.out.println("Fecha: " + rs.getString("fechaReserva"));
                System.out.println("Hora: " + rs.getString("horaReserva"));
                System.out.println("Espacio: " + rs.getString("espacio"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        }
    }
}