package Clases.Cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        String[] palos = {"Oro", "Copa", "Espada", "Basto"};

        for (String palo : palos) {
            for (int valor = 1; valor <= 12; valor++) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (!cartas.isEmpty())
            return cartas.remove(0);
        return null;
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}
