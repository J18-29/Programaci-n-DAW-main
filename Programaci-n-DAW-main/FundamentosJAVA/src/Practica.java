public class Practica {
    // PRÁCTICA RECORRER MATRICES

    public static void main(String[] args) {
        // Matriz irregular (diferente cantidad de columnas por fila)
        int[][] matriz2 = {
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5},
            {3, 4, 5},
            {4, 5},
            {5}
        };

        // Recorre filas
        for (int i = 0; i < matriz2.length; i++) {
            // Recorre columnas
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}

