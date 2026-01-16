import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Arrays2 {
    public static void main(String[] args) {

        // Crear un Scanner para leer datos del usuario
        Scanner sc = new Scanner(System.in);

        // Preguntar cuántos números desea introducir el usuario
        System.out.print("¿Cuántos números deseas introducir? ");
        int n = sc.nextInt();

        // Crear un array de tipo Integer con tamaño n
        // Usamos Integer en lugar de int para poder usar Collections.reverseOrder()
        Integer[] numeros = new Integer[n];

        // Bucle para leer los números introducidos por el usuario
        for (int i = 0; i < n; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        // Mostrar el vector original
        System.out.println("Vector original: " + Arrays.toString(numeros));

        // Ordenar el array de mayor a menor usando Arrays.sort con Collections.reverseOrder()
        Arrays.sort(numeros, Collections.reverseOrder());

        // Mostrar el vector ordenado
        System.out.println("Vector ordenado de mayor a menor: " + Arrays.toString(numeros));
    }
}
