package Herencia;

import java.util.ArrayList;
import java.util.Random;

public class Duelos {
    public static void main(String[] args) {

        ArrayList<Personaje> equipoA = new ArrayList<>();
        ArrayList<Personaje> equipoB = new ArrayList<>();
        Random random = new Random();

        // Crear equipos
        equipoA.add(new Guerrero("Guerrero A"));
        equipoA.add(new Arquero("Arquero A"));
        equipoA.add(new Mago("Mago A"));

        equipoB.add(new Guerrero("Guerrero B"));
        equipoB.add(new Arquero("Arquero B"));
        equipoB.add(new Mago("Mago B"));

        System.out.println("🔥 COMIENZA LA BATALLA 🔥\n");

        while (!equipoA.isEmpty() && !equipoB.isEmpty()) {

            Personaje atacanteA = equipoA.get(random.nextInt(equipoA.size()));
            Personaje defensorB = equipoB.get(random.nextInt(equipoB.size()));

            int dañoA = atacanteA.atacar();
            defensorB.recibirDaño(dañoA);

            System.out.println(atacanteA.getNombre() +
                    " ataca a " + defensorB.getNombre() +
                    " causando " + dañoA + " de daño");

            if (!defensorB.estaVivo()) {
                System.out.println(defensorB.getNombre() + " ha muerto ❌");
                equipoB.remove(defensorB);
            }

            if (equipoB.isEmpty()) break;

            // Turno del equipo B
            Personaje atacanteB = equipoB.get(random.nextInt(equipoB.size()));
            Personaje defensorA = equipoA.get(random.nextInt(equipoA.size()));

            int dañoB = atacanteB.atacar();
            defensorA.recibirDaño(dañoB);

            System.out.println(atacanteB.getNombre() +
                    " ataca a " + defensorA.getNombre() +
                    " causando " + dañoB + " de daño");

            if (!defensorA.estaVivo()) {
                System.out.println(defensorA.getNombre() + " ha muerto ❌");
                equipoA.remove(defensorA);
            }

            System.out.println("-----------------------------");
        }

        if (equipoA.isEmpty()) {
            System.out.println("\n🏆 ¡Gana el Equipo B!");
        } else {
            System.out.println("\n🏆 ¡Gana el Equipo A!");
        }
    }
}
