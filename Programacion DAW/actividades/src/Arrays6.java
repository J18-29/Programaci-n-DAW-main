import java.util.Arrays;

public class Arrays6 {
    public static void main(String[] args) {

        // Primera matriz de enteros
        int[][] matriz1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Segunda matriz de enteros
        int[][] matriz2 = {
            {7, 8, 9},
            {10, 11, 12}
        };

        // Llamamos al método que combina las matrices
        double[][] resultado = combinarMatrices(matriz1, matriz2);

        // Mostramos la matriz resultado
        System.out.println("Matriz resultado:");
        for (double[] fila : resultado) {
            System.out.println(Arrays.toString(fila));
        }
    }

    // Método que combina dos matrices realizando suma, producto y media por filas
    public static double[][] combinarMatrices(int[][] m1, int[][] m2) {

        // Número de filas y columnas, asumimos que ambas matrices tienen el mismo tamaño
        int filas = m1.length;
        int columnas = m1[0].length;

        // Matriz resultado: cada fila tendrá 3 valores -> suma, producto, media
        double[][] resultado = new double[filas][3];

        // Recorremos cada fila
        for (int i = 0; i < filas; i++) {

            int suma = 0;      // Acumula la suma de elementos correspondientes
            int producto = 1;  // Acumula el producto de elementos correspondientes

            // Recorremos las columnas de la fila
            for (int j = 0; j < columnas; j++) {

                // Sumamos los elementos de ambas matrices
                suma += m1[i][j] + m2[i][j];

                // Multiplicamos los elementos de ambas matrices
                producto *= m1[i][j] * m2[i][j];
            }

            // Calculamos la media de la suma total por número de columnas
            double media = suma / (double) columnas;

            // Guardamos los valores obtenidos en la matriz resultado
            resultado[i][0] = suma;
            resultado[i][1] = producto;
            resultado[i][2] = media;
        }

        // Devolvemos la matriz resultante
        return resultado;
    }
}
