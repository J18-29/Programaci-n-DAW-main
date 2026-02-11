package src.vista;

import java.util.List;
import java.util.Scanner;

import src.controlador.LibroController;
import src.modelo.Libro;

public class LibroView {

    private LibroController controller;
    private Scanner scanner;

    public LibroView() {
        controller = new LibroController();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ LIBROS ---");
            System.out.println("1. Crear libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Eliminar libro");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    private void crearLibro() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Año: ");
        int año = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        controller.crearLibro(isbn, titulo, año, descripcion);
        System.out.println("Libro creado correctamente.");
    }

    private void listarLibros() {
        List<Libro> libros = controller.obtenerLibros();

        for (Libro l : libros) {
            System.out.println("ID: " + l.getId());
            System.out.println("ISBN: " + l.getIsbn());
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Año: " + l.getAnyo());
            System.out.println("Descripción: " + l.getDescripcion());
            System.out.println("----------------------");
        }
    }

    private void eliminarLibro() {
        System.out.print("ID del libro a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        controller.eliminarLibro(id);
        System.out.println("Libro eliminado.");
    }
}
