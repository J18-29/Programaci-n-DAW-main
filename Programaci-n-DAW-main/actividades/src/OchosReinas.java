import java.util.Scanner;

public class OchosReinas {

    static final int N = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] tablero = new int[N][N];

        System.out.print("Introduce la columna (1-8) para la primera reina: ");
        int primeraColumna = sc.nextInt();

        // Validar entrada
        if (primeraColumna < 1 || primeraColumna > 8) {
            System.out.println("Columna fuera de rango. Debe ser entre 1 y 8.");
            sc.close();
            return;
        }

        // Colocar la primera reina en la fila 0 (ajuste de índice)
        tablero[0][primeraColumna - 1] = 1;

        // Intentar resolver el resto
        if (resolver(tablero, 1)) {
            System.out.println("\nSolución encontrada:");
            imprimirTablero(tablero);
        } else {
            System.out.println("No hay solución con la reina en esa columna.");
        }

        sc.close();
    }

    // Función recursiva que intenta colocar una reina por fila
    static boolean resolver(int[][] tablero, int fila) {
        if (fila == N) return true; // Todas las reinas colocadas

        for (int col = 0; col < N; col++) {
            if (esSeguro(tablero, fila, col)) {
                tablero[fila][col] = 1;
                if (resolver(tablero, fila + 1)) return true;
                tablero[fila][col] = 0; // backtrack
            }
        }
        return false;
    }

    // Comprueba si es seguro colocar una reina en (fila, col)
    static boolean esSeguro(int[][] tablero, int fila, int col) {
        // Comprobar columna
        for (int i = 0; i < fila; i++)
            if (tablero[i][col] == 1)
                return false;

        // Diagonal superior izquierda
        for (int i = fila - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (tablero[i][j] == 1)
                return false;

        // Diagonal superior derecha
        for (int i = fila - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (tablero[i][j] == 1)
                return false;

        return true;
    }

    // Imprime el tablero con las reinas colocadas
    static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}
