public class OchoReinasMaquina {
    static final int N = 8;
    static int contador = 0; // Contador de soluciones

    public static void main(String[] args) {
        int[][] tablero = new int[N][N];
        resolver(tablero, 0);
        System.out.println("Número total de soluciones: " + contador);
    }

    static void resolver(int[][] tablero, int fila) {
        // Si ya colocó las 8 reinas, imprimir la solución
        if (fila == N) {
            contador++;
            System.out.println("Solución #" + contador + ":");
            imprimirTablero(tablero);
            System.out.println();
            return; // No detener, seguir buscando otras soluciones
        }

        // Intentar colocar una reina en cada columna de la fila
        for (int col = 0; col < N; col++) {
            if (esSeguro(tablero, fila, col)) {
                tablero[fila][col] = 1; // Coloca la reina
                resolver(tablero, fila + 1); // Continuar con la siguiente fila
                tablero[fila][col] = 0; // Retroceder
            }
        }
    }

    static boolean esSeguro(int[][] tablero, int fila, int col) {
        // Verificar columna
        for (int i = 0; i < fila; i++)
            if (tablero[i][col] == 1)
                return false;

        // Verificar diagonal superior izquierda
        for (int i = fila - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (tablero[i][j] == 1)
                return false;

        // Verificar diagonal superior derecha
        for (int i = fila - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (tablero[i][j] == 1)
                return false;

        return true;
    }

    static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int casilla : fila)
                System.out.print((casilla == 1 ? "Q " : ". "));
            System.out.println();
        }
    }
}
