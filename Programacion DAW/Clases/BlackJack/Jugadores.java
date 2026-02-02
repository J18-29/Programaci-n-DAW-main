package Clases.BlackJack;

import java.util.ArrayList;

public class Jugadores {

    // Atributos del jugador
    protected String nombre;              
    protected ArrayList<Cartas> mano = new ArrayList<>(); 
    protected int fondos;                 

    // Constructor: recibe el nombre del jugador
    public Jugadores(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar una carta a la mano del jugador
    public void addCarta(Cartas c) {
        mano.add(c);
    }

    // Método para limpiar la mano (al inicio de cada partida)
    public void limpiarMano() {
        mano.clear();
    }

    // Método que calcula los puntos totales de la mano según reglas de Blackjack
    public int calcularPuntos() {
        int total = 0;   // Suma de puntos de las cartas
        int ases = 0;    // Contador de ases para ajustar su valor si es necesario

        // Sumar valores de las cartas y contar ases
        for (Cartas c : mano) {
            total += c.getValorJuego();
            if (c.getValor().equals("A")) ases++;
        }

        // Ajustar valor de los ases de 11 a 1 si el total supera 21
        while (total > 21 && ases > 0) {
            total -= 10; // Cambiar un As de 11 a 1
            ases--;
        }

        return total;
    }

    // Método para mostrar la mano del jugador y su total de puntos
    public void mostrarMano() {
        System.out.println(nombre + " tiene:");
        for (Cartas c : mano) {
            System.out.println(" - " + c); // Muestra cada carta usando el método toString() de Cartas
        }
        System.out.println("Total: " + calcularPuntos());
    }
}
