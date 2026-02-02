package Abstractas;

import java.util.Random;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 80);
    }

    @Override
    public int atacar() {
        Random rand = new Random();
        int daño = rand.nextInt(20) + 5; // 5–24
        System.out.println(nombre + " lanza un hechizo y hace " + daño + " de daño");
        return daño;
    }
}
