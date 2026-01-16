package Prueba;

import java.util.*;

public class RuletaCasino {

    private static final Map<Integer, String> colores = new HashMap<>();
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    // Inicializar colores según ruleta europea
    static {
        colores.put(0, "VERDE");

        int[] rojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
        for (int r : rojos) colores.put(r, "ROJO");

        int[] negros = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
        for (int n : negros) colores.put(n, "NEGRO");
    }

    public static void main(String[] args) {
        System.out.println("===== Ruleta Europea — Modo Avanzado =====\n");

        int jugadores = pedirJugadores();
        Map<String, Integer> saldo = new HashMap<>();

        // Todos empiezan con 100€
        for (int i = 1; i <= jugadores; i++) {
            saldo.put("Jugador " + i, 100);
        }

        boolean continuar = true;

        while (continuar && !todosArruinados(saldo)) {

            System.out.println("\n===== NUEVA RONDA =====");
            mostrarSaldos(saldo);

            Map<String, Integer> apuestasNumero = new HashMap<>();
            Map<String, Integer> apuestasDinero = new HashMap<>();

            pedirApuestas(jugadores, saldo, apuestasNumero, apuestasDinero);

            int numeroGanador = girarRuleta();

            pagarGanadores(saldo, apuestasNumero, apuestasDinero, numeroGanador);

            continuar = preguntarContinuar();
        }

        System.out.println("\n===== FIN DEL JUEGO =====");
        mostrarSaldos(saldo);
        System.out.println("¡Gracias por jugar!");
    }

    // -----------------------------------------

    public static int pedirJugadores() {
        int jugadores;
        do {
            System.out.print("¿Cuántos jugadores van a participar? (1–5): ");
            jugadores = scanner.nextInt();
        } while (jugadores < 1 || jugadores > 5);
        return jugadores;
    }

    public static void pedirApuestas(int jugadores, Map<String, Integer> saldo,
                                     Map<String, Integer> apuestasNumero,
                                     Map<String, Integer> apuestasDinero) {

        for (int i = 1; i <= jugadores; i++) {
            String j = "Jugador " + i;

            if (saldo.get(j) <= 0) {
                System.out.println(j + " está sin dinero y no puede apostar.");
                continue;
            }

            int cantidad;
            do {
                System.out.print(j + ", tu saldo es " + saldo.get(j) + "€. ¿Cuánto deseas apostar?: ");
                cantidad = scanner.nextInt();
            } while (cantidad < 1 || cantidad > saldo.get(j));

            int numero;
            do {
                System.out.print(j + ", elige un número (0–36): ");
                numero = scanner.nextInt();
            } while (numero < 0 || numero > 36);

            apuestasDinero.put(j, cantidad);
            apuestasNumero.put(j, numero);

            // Se descuenta temporalmente (si pierde se pierde, si gana se suma después)
            saldo.put(j, saldo.get(j) - cantidad);
        }
    }

    public static int girarRuleta() {
        System.out.println("\nLa ruleta está girando...");
        try { Thread.sleep(1500); } catch (InterruptedException e) {}

        int numero = random.nextInt(37);
        String color = colores.get(numero);

        System.out.println("\n=== RESULTADO ===");
        System.out.println("Número: " + numero);
        System.out.println("Color : " + color + "\n");

        return numero;
    }

    public static void pagarGanadores(Map<String, Integer> saldo,
                                      Map<String, Integer> apuestasNumero,
                                      Map<String, Integer> apuestasDinero,
                                      int numeroGanador) {

        boolean hayGanador = false;

        for (String jugador : apuestasNumero.keySet()) {
            if (apuestasNumero.get(jugador) == numeroGanador) {
                int ganancia = apuestasDinero.get(jugador) * 35;
                saldo.put(jugador, saldo.get(jugador) + ganancia + apuestasDinero.get(jugador));

                System.out.println("🎉 " + jugador + " ACERTÓ y gana " + ganancia + "€ !");
                hayGanador = true;
            }
        }

        if (!hayGanador) {
            System.out.println("💰 Nadie acertó. La banca se queda todo.");
        }
    }

    public static boolean preguntarContinuar() {
        System.out.print("\n¿Deseas jugar otra ronda? (s/n): ");
        char c = scanner.next().toLowerCase().charAt(0);
        return c == 's';
    }

    public static void mostrarSaldos(Map<String, Integer> saldo) {
        System.out.println("\n--- Saldos actuales ---");
        for (String j : saldo.keySet()) {
            System.out.println(j + ": " + saldo.get(j) + "€");
        }
    }

    public static boolean todosArruinados(Map<String, Integer> saldo) {
        for (int dinero : saldo.values()) {
            if (dinero > 0) return false;
        }
        return true;
    }
}
