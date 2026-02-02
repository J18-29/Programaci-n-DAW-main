package Clases.BlackJack;

import java.util.Scanner;

public class Partida {

    // Declaración de objetos principales del juego
    private Jugadores jugador;  
    private Crupier crupier;   
    private Baraja baraja;     

    // Contadores de victorias
    private int victoriasJugador = 0;
    private int victoriasCrupier = 0;

    // Método principal para iniciar la partida
    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        // Pedir al jugador su nombre y asignarle fondos iniciales
        System.out.print("Introduce tu nombre: ");
        jugador = new Jugadores(sc.nextLine());
        jugador.fondos = 100;  // Fondos iniciales del jugador

        // Crear el crupier
        crupier = new Crupier();

        // Mientras el jugador tenga dinero, se pueden seguir jugando partidas
        while (jugador.fondos > 0) {

            System.out.println("\n--- NUEVA PARTIDA ---");

            // Creamos y barajamos la baraja al inicio de cada partida
            baraja = new Baraja();
            baraja.barajar();

            // Limpiamos las manos del jugador y del crupier al inicio de cada partida
            jugador.limpiarMano();
            crupier.limpiarMano();

            // Pedimos al jugador cuánto desea apostar
            System.out.println("Tienes " + jugador.fondos + "€. ¿Cuánto deseas apostar?");
            int apuesta = sc.nextInt();

            // Validamos que la apuesta sea correcta (no negativa ni superior a los fondos)
            while (apuesta > jugador.fondos || apuesta <= 0) {
                System.out.println("Apuesta no válida. Intenta de nuevo:");
                apuesta = sc.nextInt();
            }

            // Repartimos cartas iniciales: dos al jugador y una al crupier
            jugador.addCarta(baraja.repartirCarta());
            jugador.addCarta(baraja.repartirCarta());
            crupier.addCarta(baraja.repartirCarta());

            // Turno del jugador
            turnoJugador(sc);

            // Si el jugador se pasa de 21, pierde automáticamente
            if (jugador.calcularPuntos() > 21) {
                System.out.println("Te pasaste. Pierdes la apuesta.");
                jugador.fondos -= apuesta;
                victoriasCrupier++;
                continue; 
            }

            // Turno del crupier
            turnoCrupier();

            // Determinar quién gana y ajustar fondos y contadores
            determinarGanador(apuesta);
        }

        // Mensaje final cuando el jugador se queda sin dinero
        System.out.println("\n Te has quedado sin dinero. Fin del juego.");
        System.out.println("Victorias jugador: " + victoriasJugador);
        System.out.println("Victorias crupier: " + victoriasCrupier);
    }

    // Método para manejar el turno del jugador
    private void turnoJugador(Scanner sc) {
        String opcion;
        do {
            // Mostramos la mano actual del jugador
            jugador.mostrarMano();
            System.out.print("¿Quieres otra carta? (s/n): ");
            opcion = sc.next();

            // Si el jugador pide otra carta, se reparte
            if (opcion.equalsIgnoreCase("s")) {
                jugador.addCarta(baraja.repartirCarta());
            }

        // El jugador puede seguir pidiendo cartas mientras quiera y no se pase de 21
        } while (opcion.equalsIgnoreCase("s") && jugador.calcularPuntos() < 21);
    }

    // Método para manejar el turno del crupier
    private void turnoCrupier() {
        System.out.println("\nTurno del crupier:");
        crupier.mostrarMano();

        // El crupier toma cartas mientras tenga menos de 17 puntos
        while (crupier.calcularPuntos() < 17) {
            System.out.println("El crupier toma una carta...");
            crupier.addCarta(baraja.repartirCarta());
            crupier.mostrarMano();
        }
    }

    // Método para determinar quién gana la partida
    private void determinarGanador(int apuesta) {
        int totalJugador = jugador.calcularPuntos();
        int totalCrupier = crupier.calcularPuntos();

        System.out.println("\nRESULTADOS:");
        jugador.mostrarMano();
        crupier.mostrarMano();

        // Si el crupier se pasa o el jugador tiene más puntos, gana el jugador
        if (totalCrupier > 21 || totalJugador > totalCrupier) {
            System.out.println("¡Has ganado! +" + apuesta + "€");
            jugador.fondos += apuesta;
            victoriasJugador++;
        } 
        // Si el jugador tiene menos puntos que el crupier, pierde
        else if (totalJugador < totalCrupier) {
            System.out.println("Has perdido. -" + apuesta + "€");
            jugador.fondos -= apuesta;
            victoriasCrupier++;
        } 
        // Si tienen el mismo puntaje, hay empate
        else {
            System.out.println("Empate. Recuperas tu apuesta.");
        }
    }
}


