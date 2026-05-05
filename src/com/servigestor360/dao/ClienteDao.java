package com.servigestor360.dao;

import com.servigestor360.config.ConexionBD;
import com.servigestor360.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
    // Insertar nuevo cliente
    public void insertarCliente(Cliente cliente) {

        String sql = "INSERT INTO cliente (nombres, apellidos, tipoDocumento, numeroDocumento, telefono, correoElectronico, direccion, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, cliente.getNombres());
            statement.setString(2, cliente.getApellidos());
            statement.setString(3, cliente.getTipoDocumento());
            statement.setString(4, cliente.getNumeroDocumento());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getCorreoElectronico());
            statement.setString(7, cliente.getDireccion());
            statement.setBoolean(8, cliente.isActivo());

            statement.executeUpdate();

            System.out.println("Cliente registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    // Listar todos los clientes
    public void listarClientes() {

        String sql = "SELECT * FROM cliente";

        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                System.out.println("ID: " + resultSet.getInt("idCliente"));
                System.out.println("Nombre: " + resultSet.getString("nombres"));
                System.out.println("Apellido: " + resultSet.getString("apellidos"));
                System.out.println("Documento: " + resultSet.getString("numeroDocumento"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correoElectronico"));
                System.out.println("Dirección: " + resultSet.getString("direccion"));
                System.out.println("----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
    }

    // Actualizar cliente por ID
    public void actualizarCliente(Cliente cliente) {

        String sql = "UPDATE cliente SET nombres = ?, apellidos = ?, tipoDocumento = ?, numeroDocumento = ?, telefono = ?, correoElectronico = ?, direccion = ?, activo = ? WHERE idCliente = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, cliente.getNombres());
            statement.setString(2, cliente.getApellidos());
            statement.setString(3, cliente.getTipoDocumento());
            statement.setString(4, cliente.getNumeroDocumento());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getCorreoElectronico());
            statement.setString(7, cliente.getDireccion());
            statement.setBoolean(8, cliente.isActivo());
            statement.setInt(9, cliente.getIdCliente());

            int filas = statement.executeUpdate();

            if (filas > 0) {
                System.out.println("Cliente actualizado correctamente.");
            } else {
                System.out.println("No se encontró el cliente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    // Eliminar cliente por ID
    public void eliminarCliente(int idCliente) {

        String sql = "DELETE FROM cliente WHERE idCliente = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, idCliente);

            int filas = statement.executeUpdate();

            if (filas > 0) {
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("No se encontró el cliente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }

}