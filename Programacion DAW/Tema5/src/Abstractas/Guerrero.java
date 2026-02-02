package Abstractas;

import java.util.Random;

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre, 120);
    }

    @Override
    public int atacar() {
        Random rand = new Random();
        int daño = rand.nextInt(15) + 10; // 10–24
        System.out.println(nombre + " ataca con espada y hace " + daño + " de daño");
        return daño;
    }
}
