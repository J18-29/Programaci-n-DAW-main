import java.util.Random;
import java.util.Arrays;

public class Arrays7 {
    public static void main(String[] args) {

        // Crear una matriz de 5x5
        int[][] matriz = new int[5][5];
        Random rand = new Random();

        // Llenar la matriz con números aleatorios entre 0 y 100
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = rand.nextInt(101); // nextInt(101) genera números de 0 a 100
            }
        }

        // Mostrar la matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Rotar la matriz 90 grados en sentido horario
        int[][] rotada = rotarMatriz(matriz);

        // Mostrar la matriz rotada
        System.out.println("Matriz rotada una posición en sentido horario:");
        imprimirMatriz(rotada);
    }

    // Método para rotar una matriz cuadrada 90 grados en sentido horario
    public static int[][] rotarMatriz(int[][] mat) {
        int n = mat.length; // Número de filas/columnas (matriz cuadrada)
        int[][] nueva = new int[n][n]; // Matriz resultante

        // Recorremos cada elemento y lo colocamos en la nueva posición
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ni = j;          // Nueva fila = columna original
                int nj = n - 1 - i;  // Nueva columna = fila original invertida
                nueva[ni][nj] = mat[i][j];
            }
        }

        return nueva; // Devolver la matriz rotada
    }

    // Método para imprimir la matriz en consola
    public static void imprimirMatriz(int[][] mat) {
        for (int[] fila : mat) {
            System.out.println(Arrays.toString(fila)); // Imprime cada fila como un array
        }
    }
}
