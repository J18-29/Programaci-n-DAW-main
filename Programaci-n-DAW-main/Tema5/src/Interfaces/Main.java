package Interfaces;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Lista de Movible
        List<Movible> movibles = new ArrayList<>();
        movibles.add(new Coche());
        movibles.add(new Barco());
        movibles.add(new Avion());

        System.out.println("=== MOVIMIENTO ===");
        for (Movible m : movibles) {
            m.mover();
        }

        // Lista de Sonoro
        List<Sonoro> sonoros = new ArrayList<>();
        sonoros.add(new Coche());
        sonoros.add(new Barco());
        sonoros.add(new Avion());

        System.out.println("\n=== SONIDO ===");
        for (Sonoro s : sonoros) {
            s.emitirSonido();
        }
    }
}
