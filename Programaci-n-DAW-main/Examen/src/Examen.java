package Examen.src;
import java.util.Arrays;
import java.util.Random;

public class Examen {
    
    public static void main(String[] args) {
        // Crear una matriz de 5x5
        int[][] matriz = new int[5][5];
        Random rand = new Random();
          

        // Llenar la matriz con números aleatorios entre 0 y 50
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = rand.nextInt(51); // nextInt(101) genera números de 0 a 50
            }
        }

        // Mostrar la matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

    }
     
    // Método para imprimir la matriz en consola
    public static void imprimirMatriz(int[][] mat) {
        for (int[] fila : mat) {
            System.out.println(Arrays.toString(fila)); // Imprime cada fila como un array
        }
    }
   
}
