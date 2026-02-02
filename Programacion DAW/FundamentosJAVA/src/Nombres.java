
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Nombres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>(); //Creacion de la lista vacia

        System.out.println("Introduce nombres (escribe 'fin' para terminar):");

        while (true) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            if (!nombres.contains(nombre)) {
                nombres.add(nombre);
            } else {
                System.out.println("Ese nombre ya fue introducido.");
            }
        }

        // Ordenar de forma alfabética sin distinguir mayúsculas/minúsculas
        Collections.sort(nombres, String.CASE_INSENSITIVE_ORDER);

        // Si quieres invertir el orden, podrías usar:
        // Collections.sort(nombres, (a, b) -> -1 * a.compareTo(b));

        System.out.println("\nNombres introducidos (ordenados):");
        for (String n : nombres) {
            System.out.println(n);
        }

        sc.close();
    }
}


