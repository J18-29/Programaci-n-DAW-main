package src.Vista;

import src.Controlador.SuministraController;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SuministraView {

    private SuministraController controller;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public SuministraView() {
        controller = new SuministraController();
        scanner = new Scanner(System.in);
        // Formato esperado por el usuario
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    }

    public void menu() {

        int opcion;

        do {
            System.out.println("\n=== MENU SUMINISTRA ===");
            System.out.println("1. Insertar suministro");
            System.out.println("2. Listar suministros");
            System.out.println("3. Actualizar suministro");
            System.out.println("4. Borrar suministro");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    controller.listarSuministros();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    borrar();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // --- MÉTODOS CRUD ---

    private void insertar() {
        System.out.print("Codigo del proveedor: ");
        int codigoProveedor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Codigo de la pieza: ");
        int codigoPieza = scanner.nextInt();
        scanner.nextLine();

        LocalDateTime fechaHora = leerFecha("Fecha y hora (yyyy-MM-ddTHH:mm): ");
        if (fechaHora == null) return;

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        // Convertir LocalDateTime a Timestamp
        Timestamp fechaTimestamp = Timestamp.valueOf(fechaHora);

        controller.insertarSuministro(codigoProveedor, codigoPieza, fechaTimestamp, cantidad);
        System.out.println("Suministro insertado correctamente.");
    }

    private void actualizar() {
        System.out.print("Codigo del proveedor a actualizar: ");
        int codigoProveedor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo codigo de pieza: ");
        int codigoPieza = scanner.nextInt();
        scanner.nextLine();

        LocalDateTime fechaHora = leerFecha("Nueva fecha y hora (yyyy-MM-ddTHH:mm): ");
        if (fechaHora == null) return;

        System.out.print("Nueva cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        Timestamp fechaTimestamp = Timestamp.valueOf(fechaHora);

        controller.actualizarSuministro(codigoProveedor, codigoPieza, fechaTimestamp, cantidad);
        System.out.println("Suministro actualizado correctamente.");
    }

    private void borrar() {
        System.out.print("Codigo del proveedor: ");
        int codigoProveedor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Codigo de la pieza: ");
        int codigoPieza = scanner.nextInt();
        scanner.nextLine();

        controller.borrarSuministro(codigoProveedor, codigoPieza);
        System.out.println("Suministro borrado correctamente.");
    }

    // --- MÉTODO AUXILIAR PARA LEER FECHA ---

    private LocalDateTime leerFecha(String mensaje) {
        System.out.print(mensaje);
        String input = scanner.nextLine();
        try {
            return LocalDateTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha/hora incorrecto.");
            return null;
        }
    }
}
