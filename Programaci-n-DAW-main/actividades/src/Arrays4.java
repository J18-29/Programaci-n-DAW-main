import java.util.Scanner;

public class Arrays4 {
    public static void main(String[] args) {

        // Array con los números correctos de la Bonoloto
        int[] correcto = {5, 12, 23, 34, 45, 49};

        // Objeto Scanner para leer datos del usuario
        Scanner sc = new Scanner(System.in);

        // Array para almacenar los números introducidos por el usuario
        int[] usuario = new int[6];

        // Pedimos los 6 números al usuario
        System.out.println("Introduce tus 6 números de la Bonoloto:");
        for (int i = 0; i < 6; i++) {
            usuario[i] = sc.nextInt(); // Guardamos cada número en el array
        }

        int aciertos = 0; // Contador de aciertos

        // Comparamos cada número del usuario con cada número correcto
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // Si los números coinciden, aumentamos el contador
                if (usuario[i] == correcto[j]) {
                    aciertos++;
                }
            }
        }

        // Mostramos el número total de aciertos
        System.out.println("Número de aciertos: " + aciertos);
    }
}
