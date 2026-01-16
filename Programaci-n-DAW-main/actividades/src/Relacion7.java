

import java.util.Scanner;

public class Relacion7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int positivos = 0;  // Contador para números positivos
        int negativos = 0;  // Contador para números negativos
        int numero;

        System.out.println("Introduce números (0 para terminar):");

        do {
            numero = sc.nextInt();  // Lee un número que introduces

            if (numero > 0) {
                positivos++;  // Si es positivo, aumenta contador positivo
            } else if (numero < 0) {
                negativos++;  // Si es negativo, aumenta contador negativo
            }
            // Si es 0, termina el bucle
        } while (numero != 0);

        // Mostrar resultados
        System.out.println("Has introducido " + positivos + " números positivos.");
        System.out.println("Has introducido " + negativos + " números negativos.");

        sc.close();
    }
}
