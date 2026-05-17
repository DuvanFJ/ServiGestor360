package com.servigestor360;

import com.servigestor360.config.ConexionBD;
import com.servigestor360.dao.UsuarioDao;
import com.servigestor360.dao.SolicitudReservaDao;
import com.servigestor360.model.Usuario;
import com.servigestor360.model.SolicitudReserva;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== PROBANDO CONEXIÓN ===");
        ConexionBD.obtenerConexion();

        UsuarioDao usuarioDao = new UsuarioDao();
        SolicitudReservaDao reservaDao = new SolicitudReservaDao();

        int opcion;

        do {

            System.out.println("\n====== SISTEMA DE RESERVAS ======");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Registrar reserva");
            System.out.println("4. Ver reservas");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // =========================
                // REGISTRAR USUARIO
                // =========================
                case 1:

                    System.out.println("\n--- REGISTRAR USUARIO ---");

                    System.out.print("Nombres: ");
                    String nombres = sc.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();

                    System.out.print("Tipo Documento: ");
                    String tipoDocumento = sc.nextLine();

                    System.out.print("Número Documento: ");
                    String numeroDocumento = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Correo Electrónico: ");
                    String correo = sc.nextLine();

                    System.out.print("Rol (Estudiante/Docente): ");
                    String rol = sc.nextLine();

                    Usuario usuario = new Usuario(
                            nombres,
                            apellidos,
                            tipoDocumento,
                            numeroDocumento,
                            telefono,
                            correo,
                            rol,
                            true
                    );

                    usuarioDao.insertarUsuario(usuario);
                    break;

                // =========================
                // LISTAR USUARIOS
                // =========================
                case 2:

                    System.out.println("\n--- LISTA DE USUARIOS ---");
                    usuarioDao.listarUsuarios();
                    break;

                // =========================
                // REGISTRAR RESERVA
                // =========================
                case 3:

                    System.out.println("\n--- REGISTRAR RESERVA ---");

                    System.out.print("ID Usuario: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Fecha Reserva (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.print("Hora Reserva (HH:MM): ");
                    String hora = sc.nextLine();

                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();

                    System.out.print("Espacio: ");
                    String espacio = sc.nextLine();

                    SolicitudReserva reserva = new SolicitudReserva(
                            idUsuario,
                            fecha,
                            hora,
                            motivo,
                            espacio,
                            "Pendiente"
                    );

                    reservaDao.insertarReserva(reserva);
                    break;

                // =========================
                // LISTAR RESERVAS
                // =========================
                case 4:

                    System.out.println("\n--- LISTA DE RESERVAS ---");
                    reservaDao.listarReservas();
                    break;

                // =========================
                // ELIMINAR USUARIO
                // =========================
                case 5:

                    System.out.println("\n--- ELIMINAR USUARIO ---");

                    System.out.print("Ingrese ID Usuario: ");
                    int idEliminar = sc.nextInt();

                    usuarioDao.eliminarUsuario(idEliminar);
                    break;

                // =========================
                // SALIR
                // =========================
                case 6:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}