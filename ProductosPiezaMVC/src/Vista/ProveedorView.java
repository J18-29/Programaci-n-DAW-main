package src.Vista;

import java.util.Scanner;


import src.Controlador.ProveedorController;


public class ProveedorView {

    private ProveedorController controller;
    private Scanner scanner;

    public ProveedorView() {
        controller = new ProveedorController();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcion;

        do {
            System.out.println("\n=== MENU PROVEEDOR ===");
            System.out.println("1. Insertar proveedor");
            System.out.println("2. Listar proveedores");
            System.out.println("3. Actualizar proveedor");
            System.out.println("4. Borrar proveedor");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    controller.listarProveedores();
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

        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Provincia: ");
        String provincia = scanner.nextLine();

       

        controller.insertarProveedor(codigo, direccion, ciudad, provincia);
    }

    private void actualizar() {
        System.out.print("Codigo del proveedor a actualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nueva direccion: ");
        String direccion = scanner.nextLine();

        System.out.print("Nueva ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Nueva provincia: ");
        String provincia = scanner.nextLine();

       

        

        controller.actualizarProveedor(codigo, direccion, ciudad, provincia );
    }

    private void borrar() {
        System.out.print("Codigo del proveedor a borrar: ");
        int codigo = scanner.nextInt();

        controller.borrarProveedor(codigo);
    }
}


