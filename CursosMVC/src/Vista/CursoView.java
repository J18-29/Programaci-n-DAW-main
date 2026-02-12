package src.Vista;

import java.util.Scanner;

public class CursoView {

    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENÚ =====");
        System.out.println("1. Crear Alumno");
        System.out.println("2. Crear Profesor");
        System.out.println("3. Crear Asignatura");
        System.out.println("4. Crear Curso Escolar");
        System.out.println("5. Realizar Matrícula");
        System.out.println("6. Salir");
        System.out.print("Seleccione opción: ");

        int opcion = sc.nextInt();
        sc.nextLine(); 
        return opcion;
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }

    public int pedirEntero(String mensaje) {
        System.out.print(mensaje + ": ");
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine(); 
        return numero;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}