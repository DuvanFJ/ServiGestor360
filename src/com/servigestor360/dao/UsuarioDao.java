package com.servigestor360.dao;

import com.servigestor360.config.ConexionBD;
import com.servigestor360.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    // =========================
    // INSERTAR USUARIO
    // =========================
    public void insertarUsuario(Usuario usuario) {

        String sql = "INSERT INTO usuario (nombres, apellidos, tipoDocumento, numeroDocumento, telefono, correoElectronico, rol, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getTipoDocumento());
            stmt.setString(4, usuario.getNumeroDocumento());
            stmt.setString(5, usuario.getTelefono());
            stmt.setString(6, usuario.getCorreoElectronico());
            stmt.setString(7, usuario.getRol());
            stmt.setBoolean(8, usuario.isActivo());

            stmt.executeUpdate();

            System.out.println("Usuario registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    // =========================
    // LISTAR USUARIOS
    // =========================
    public void listarUsuarios() {

        String sql = "SELECT * FROM usuario";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("idUsuario"));
                System.out.println("Nombre: " + rs.getString("nombres"));
                System.out.println("Apellido: " + rs.getString("apellidos"));
                System.out.println("Documento: " + rs.getString("numeroDocumento"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Correo: " + rs.getString("correoElectronico"));
                System.out.println("Rol: " + rs.getString("rol"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
    }

    // =========================
    // ELIMINAR USUARIO
    // =========================
    public void eliminarUsuario(int idUsuario) {

        String sql = "DELETE FROM usuario WHERE idUsuario = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}