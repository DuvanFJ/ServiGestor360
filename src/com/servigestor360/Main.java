package com.servigestor360;

import com.servigestor360.config.ConexionBD;
import com.servigestor360.dao.ClienteDao;
import com.servigestor360.dao.SolicitudDao;
import com.servigestor360.model.Cliente;
import com.servigestor360.model.Solicitud;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // PRUEBA DE CONEXIÓN
        System.out.println("=== PROBANDO CONEXIÓN ===");
        ConexionBD.obtenerConexion();

        ClienteDao clienteDao = new ClienteDao();
        SolicitudDao solicitudDao = new SolicitudDao();

        int opcion;

        do {
            System.out.println("\n====== SERVIGESTOR 360 ======");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Registrar solicitud");
            System.out.println("4. Ver solicitudes");
            System.out.println("5. Ver solicitudes por cliente"); // NUEVO
            System.out.println("6. Eliminar cliente"); // SE MANTIENE
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // =========================
                // REGISTRAR CLIENTE
                // =========================
                case 1:

                    System.out.println("\n--- REGISTRAR CLIENTE ---");

                    System.out.print("Nombres: ");
                    String nombres = sc.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();

                    System.out.print("Tipo Documento: ");
                    String tipoDoc = sc.nextLine();

                    System.out.print("Número Documento: ");
                    String numDoc = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    Cliente cliente = new Cliente(
                            nombres, apellidos, tipoDoc, numDoc,
                            telefono, correo, direccion, true
                    );

                    clienteDao.insertarCliente(cliente);
                    break;

                // =========================
                // LISTAR CLIENTES
                // =========================
                case 2:
                    System.out.println("\n--- LISTA DE CLIENTES ---");
                    clienteDao.listarClientes();
                    break;

                // =========================
                // REGISTRAR SOLICITUD
                // =========================
                case 3:

                    System.out.println("\n--- REGISTRAR SOLICITUD ---");

                    System.out.print("ID Cliente: ");
                    int idCliente = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.print("Hora (HH:MM): ");
                    String hora = sc.nextLine();

                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();

                    System.out.print("Sala: ");
                    String sala = sc.nextLine();

                    Solicitud solicitud = new Solicitud(
                            idCliente,
                            fecha,
                            hora,
                            "Solicitud de espacio",
                            "Universidad",
                            "Normal",
                            motivo,
                            "Sin observaciones",
                            sala,
                            "Pendiente"
                    );

                    // VALIDACIÓN EXTRA
                    solicitud.normalizarDatos();

                    solicitudDao.insertarSolicitud(solicitud);
                    break;

                // =========================
                // LISTAR SOLICITUDES
                // =========================
                case 4:
                    System.out.println("\n--- LISTA DE SOLICITUDES ---");
                    solicitudDao.listarSolicitudes();
                    break;

                // =========================
                // SOLICITUDES POR CLIENTE
                // =========================
                case 5:

                    System.out.println("\n--- SOLICITUDES POR CLIENTE ---");

                    System.out.print("Ingrese ID del cliente: ");
                    int idBuscar = sc.nextInt();

                    solicitudDao.listarSolicitudesPorCliente(idBuscar);
                    break;

                // =========================
                // ELIMINAR CLIENTE
                // =========================
                case 6:

                    System.out.println("\n--- ELIMINAR CLIENTE ---");

                    System.out.print("Ingrese ID del cliente: ");
                    int idEliminar = sc.nextInt();

                    clienteDao.eliminarCliente(idEliminar);
                    break;

                // =========================
                // SALIR
                // =========================
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}