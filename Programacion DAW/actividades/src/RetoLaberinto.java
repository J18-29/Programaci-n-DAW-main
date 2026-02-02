import java.util.Scanner;

public class RetoLaberinto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === LABERINTOS DE PRUEBA ===
        char[][] laberinto1 = {
            {'0', '#', '0', '0', '0'},
            {'0', '#', '0', '#', '0'},
            {'0', '0', '0', '#', '0'},
            {'#', '#', '0', '0', '0'},
            {'0', '0', '#', '#', '0'}
        };

        char[][] laberinto2 = {
            {'0', '0', '0', '#', '0', '0'},
            {'#', '#', '0', '#', '0', '#'},
            {'0', '0', '0', '0', '0', '0'},
            {'0', '#', '#', '#', '#', '0'},
            {'0', '0', '0', '0', '#', '0'},
            {'#', '#', '#', '0', '#', '0'}
        };

        char[][] laberinto3 = {
            {'0', '#', '0', '0', '0', '#', '0'},
            {'0', '#', '0', '#', '0', '#', '0'},
            {'0', '#', '0', '#', '0', '0', '0'},
            {'0', '0', '0', '#', '#', '#', '0'},
            {'#', '#', '0', '0', '0', '#', '0'},
            {'0', '0', '0', '#', '0', '0', '0'},
            {'0', '#', '#', '#', '#', '#', '0'}
        };

        char[][] laberinto4 = {
            {'0', '#', '0'},
            {'#', '#', '0'},
            {'0', '0', '#'}
        };

        // === MENÚ DE SELECCIÓN ===
        System.out.println("=== SELECCIÓN DE LABERINTO ===");
        System.out.println("1. Laberinto 1 (5x5)");
        System.out.println("2. Laberinto 2 (6x6)");
        System.out.println("3. Laberinto 3 (7x7)");
        System.out.println("4. Laberinto 4 (3x3)");
        System.out.print("Elige el número del laberinto que deseas resolver: ");

        int opcion = sc.nextInt();

        char[][] laberintoSeleccionado = null;
        String nombre = "";

        switch (opcion) {
            case 1 -> {
                laberintoSeleccionado = laberinto1;
                nombre = "Laberinto 1";
            }
            case 2 -> {
                laberintoSeleccionado = laberinto2;
                nombre = "Laberinto 2";
            }
            case 3 -> {
                laberintoSeleccionado = laberinto3;
                nombre = "Laberinto 3";
            }
            case 4 -> {
                laberintoSeleccionado = laberinto4;
                nombre = "Laberinto 4";
            }
            default -> {
                System.out.println("Opción no válida.");
                System.exit(0);
            }
        }

        int N = laberintoSeleccionado.length;
        int[][] solucion = new int[N][N];
        boolean[][] visitado = new boolean[N][N]; // <--- NUEVO

        System.out.println("\n=== " + nombre + " ===");
        if (resolverDesde(0, 0, laberintoSeleccionado, solucion, visitado)) {
            imprimirSolucion(solucion);
        } else {
            System.out.println("No existe camino");
        }

        sc.close();
    }

    // === FUNCIÓN resolverDesde ===
    public static boolean resolverDesde(int x, int y, char[][] laberinto, int[][] solucion, boolean[][] visitado) {
        int N = laberinto.length;

        // Caso base: llegada a la salida
        if (x == N - 1 && y == N - 1 && laberinto[x][y] == '0') {
            solucion[x][y] = 1;
            return true;
        }

        if (esSeguro(x, y, laberinto) && !visitado[x][y]) {
            // Marcar como parte del camino
            solucion[x][y] = 1;
            visitado[x][y] = true; // <--- EVITA CICLOS

            // Moverse en las cuatro direcciones
            if (resolverDesde(x + 1, y, laberinto, solucion, visitado)) return true;
            if (resolverDesde(x, y + 1, laberinto, solucion, visitado)) return true;
            if (resolverDesde(x - 1, y, laberinto, solucion, visitado)) return true;
            if (resolverDesde(x, y - 1, laberinto, solucion, visitado)) return true;

            // Retroceder
            solucion[x][y] = 0;
            return false;
        }

        return false;
    }

    // === FUNCIÓN esSeguro ===
    public static boolean esSeguro(int x, int y, char[][] laberinto) {
        int N = laberinto.length;
        return (x >= 0 && x < N && y >= 0 && y < N && laberinto[x][y] == '0');
    }

    // === FUNCIÓN imprimirSolucion ===
    public static void imprimirSolucion(int[][] solucion) {
        System.out.println("Camino encontrado:");
        for (int[] fila : solucion) {
            for (int celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}

