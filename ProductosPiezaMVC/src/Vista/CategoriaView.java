package src.Vista;

import src.Controlador.CategoriaController;
import src.Modelo.Categoria;

import java.util.Scanner;

public class CategoriaView {

    private CategoriaController controller;
    private Scanner scanner;

    public CategoriaView() {
        controller = new CategoriaController();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcion;

        do {
            System.out.println("\n=== MENU CATEGORIA ===");
            System.out.println("1. Insertar categoria");
            System.out.println("2. Listar categorias");
            System.out.println("3. Buscar categoria por codigo");
            System.out.println("4. Actualizar categoria");
            System.out.println("5. Borrar categoria");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    controller.listarCategorias();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    actualizar();
                    break;
                case 5:
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

        controller.insertarCategoria(codigo, nombre);
    }

    private void buscar() {
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();

        Categoria categoria = controller.buscarCategoria(codigo);

        if (categoria != null) {
            System.out.println("Encontrada: " +
                    categoria.getId () + " - " +
                    categoria.getNombre());
        } else {
            System.out.println("No existe la categoria.");
        }
    }

    private void actualizar() {
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        controller.actualizarCategoria(codigo, nombre);
    }

    private void borrar() {
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();

        controller.borrarCategoria(codigo);
    }
}
