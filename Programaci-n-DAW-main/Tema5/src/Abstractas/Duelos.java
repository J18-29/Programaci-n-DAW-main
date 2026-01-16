package Abstractas;

import java.util.ArrayList;
import java.util.Random;

public class Duelos {

    public static void main(String[] args) {

        ArrayList<Personaje> equipo1 = new ArrayList<>();
        ArrayList<Personaje> equipo2 = new ArrayList<>();

        equipo1.add(new Guerrero("Aragorn"));
        equipo1.add(new Mago("Gandalf"));

        equipo2.add(new Guerrero("Orco"));
        equipo2.add(new Mago("Chamán"));

        Random rand = new Random();

        while (!equipo1.isEmpty() && !equipo2.isEmpty()) {

            Personaje atacante = equipo1.get(rand.nextInt(equipo1.size()));
            Personaje defensor = equipo2.get(rand.nextInt(equipo2.size()));

            int daño = atacante.atacar();
            defensor.recibirDaño(daño);

            if (!defensor.estaVivo()) {
                System.out.println(defensor.getNombre() + " ha muerto ");
                equipo2.remove(defensor);
            }

            // Cambio de turno
            ArrayList<Personaje> temp = equipo1;
            equipo1 = equipo2;
            equipo2 = temp;

            System.out.println("----------------------");
        }

        if (equipo1.isEmpty()) {
            System.out.println(" Gana el equipo 2");
        } else {
            System.out.println(" Gana el equipo 1");
        }
    }
}
