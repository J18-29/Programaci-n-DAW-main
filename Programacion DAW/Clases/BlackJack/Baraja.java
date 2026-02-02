package Clases.BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    // Lista que contiene todas las cartas de la baraja
    private ArrayList<Cartas> cartas = new ArrayList<>();

    // Arreglos con los palos y valores de las cartas
    private String[] palos = {"Corazones", "Picas", "Treboles", "Diamantes"};
    private String[] valores = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    // Constructor de la baraja: genera todas las combinaciones de valor y palo
    public Baraja() {
        for (String palo : palos) {          // Recorre cada palo
            for (String valor : valores) {   // Recorre cada valor
                cartas.add(new Cartas(valor, palo)); // Crea la carta y la agrega a la baraja
            }
        }
    }

    // Método para barajar la baraja aleatoriamente
        public void barajar() {
        Collections.shuffle(cartas); // Usa Collections.shuffle para mezclar la lista
    }

    // Método para repartir una carta: devuelve la primera carta y la elimina de la baraja
    public Cartas repartirCarta() {
        return cartas.remove(0); // Quita la carta del índice 0 y la devuelve
    }
}

