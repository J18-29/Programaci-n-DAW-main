package src.Vista;



import src.Controlador.PiezaController;

import java.util.Scanner;

public class PiezaView {

    private PiezaController controller;
    private Scanner scanner;

    public PiezaView() {
        controller = new PiezaController();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcion;

        do {
            System.out.println("\n=== MENU PIEZA ===");
            System.out.println("1. Insertar pieza");
            System.out.println("2. Listar piezas");
            System.out.println("3. Actualizar pieza");
            System.out.println("4. Borrar pieza");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    controller.listarPiezas();
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

    private void insertar() {
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Codigo Categoria (PERTENECE): ");
        int codigoCategoria = scanner.nextInt();

        controller.insertarPieza(codigo, nombre, color, precio, codigoCategoria);
    }

    private void actualizar() {
        System.out.print("Codigo de la pieza a actualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo color: ");
        String color = scanner.nextLine();

        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Nuevo codigo categoria: ");
        int codigoCategoria = scanner.nextInt();

        controller.actualizarPieza(codigo, nombre, color, precio, codigoCategoria);
    }

    private void borrar() {
        System.out.print("Codigo de la pieza a borrar: ");
        int codigo = scanner.nextInt();

        controller.borrarPieza(codigo);
    }
}
