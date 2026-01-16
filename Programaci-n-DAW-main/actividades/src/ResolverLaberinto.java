public class ResolverLaberinto {

    // Método principal
    public static void main(String[] args) {
        // Ejemplo de laberinto
        char[][] laberinto = {
            {'0', '0', '#', '0'},
            {'#', '0', '#', '0'},
            {'0', '0', '0', '#'},
            {'0', '#', '0', '0'}
        };

        int N = laberinto.length;
        int[][] solucion = new int[N][N];

        if (resolverDesde(0, 0, laberinto, solucion)) {
            imprimirSolucion(solucion);
        } else {
            System.out.println("No existe camino");
        }
    }

    // Función recursiva que intenta encontrar un camino
    public static boolean resolverDesde(int x, int y, char[][] lab, int[][] sol) {
        int N = lab.length;

        // Caso base: si llegamos al final
        if (x == N - 1 && y == N - 1 && lab[x][y] == '0') {
            sol[x][y] = 1;
            return true;
        }

        // Verifica si (x, y) es una posición válida
        if (esSeguro(x, y, lab)) {
            // Marca la celda como parte de la solución
            sol[x][y] = 1;

            // Mover hacia abajo
            if (resolverDesde(x + 1, y, lab, sol))
                return true;

            // Mover hacia la derecha
            if (resolverDesde(x, y + 1, lab, sol))
                return true;

            // Mover hacia arriba
            if (resolverDesde(x - 1, y, lab, sol))
                return true;

            // Mover hacia la izquierda
            if (resolverDesde(x, y - 1, lab, sol))
                return true;

            // Si ninguna dirección funciona, desmarca (backtrack)
            sol[x][y] = 0;
        }

        return false;
    }

    // Verifica si la posición es válida para moverse
    public static boolean esSeguro(int x, int y, char[][] lab) {
        int N = lab.length;
        return (x >= 0 && x < N && y >= 0 && y < N && lab[x][y] == '0');
    }

    // Imprime la matriz de solución
    public static void imprimirSolucion(int[][] sol) {
        System.out.println("Camino encontrado:");
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[i].length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
