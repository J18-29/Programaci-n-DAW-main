import java.util.ArrayList;
import java.util.Scanner;

public class Arrays5 {
    public static void main(String[] args) {

        // Lista con los números correctos de la Bonoloto
        ArrayList<Integer> correcto = new ArrayList<>();
        correcto.add(5);
        correcto.add(12);
        correcto.add(23);
        correcto.add(34);
        correcto.add(45);
        correcto.add(49);

        // Scanner para leer los números introducidos por el usuario
        Scanner sc = new Scanner(System.in);

        // Lista donde guardaremos los números del usuario
        ArrayList<Integer> usuario = new ArrayList<>();

        // Pedimos al usuario que introduzca sus 6 números
        System.out.println("Introduce tus 6 números de la Bonoloto:");
        for (int i = 0; i < 6; i++) {
            usuario.add(sc.nextInt()); // Añadimos cada número a la lista
        }

        int aciertos = 0; // Contador de aciertos

        // Comprobamos cuántos números del usuario están en la lista "correcto"
        for (int n : usuario) {
            if (correcto.contains(n)) { // contains() verifica si el número está en la lista
                aciertos++;
            }
        }

        // Mostramos el número total de aciertos
        System.out.println("Número de aciertos: " + aciertos);
    }
}
