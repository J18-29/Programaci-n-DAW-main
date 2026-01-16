package Herencia;

import java.util.Random;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 70);
    }

    @Override
    public int atacar() {
        return new Random().nextInt(14) + 12; // 12 a 25
    }
}
