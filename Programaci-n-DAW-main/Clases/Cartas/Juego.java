package Clases.Cartas;

import java.util.Scanner;

public class Juego {
    private Mazo mazo;
    private Jugador jugador;
    private int rondas;

    public Juego(Jugador jugador) {
        this.mazo = new Mazo();
        this.jugador = jugador;
        this.rondas = 0;
    }

    public void iniciar() {
        mazo.barajar();
        Scanner sc = new Scanner(System.in);

        Carta actual = mazo.sacarCarta();
        System.out.println("Primera carta: " + actual);

        while (!mazo.estaVacio()) {
            System.out.print("¿La siguiente carta será mayor o menor? (m/l) o salir(s): ");
            String opcion = sc.nextLine();

            if (opcion.equalsIgnoreCase("s")) break;

            Carta siguiente = mazo.sacarCarta();
            System.out.println("La siguiente carta es: " + siguiente);

            if ( (opcion.equals("m") && siguiente.getValor() > actual.getValor()) ||
                 (opcion.equals("l") && siguiente.getValor() < actual.getValor()) ) {

                jugador.sumarPunto();
                System.out.println("¡Acertaste!");
            } else {
                jugador.restarPunto();
                System.out.println("Fallaste...");
            }

            rondas++;
            actual = siguiente;
            System.out.println("Puntos actuales: " + jugador.getPuntuacion());
        }

        System.out.println("Juego terminado.");
        System.out.println("Rondas jugadas: " + rondas);
        System.out.println("Puntuación final: " + jugador.getPuntuacion());
    }
}
