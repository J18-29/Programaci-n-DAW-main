package Herencia;

import java.util.Random;

public class Arquero extends Personaje {

    public Arquero(String nombre) {
        super(nombre, 80);
    }

    @Override
    public int atacar() {
        return new Random().nextInt(8) + 8; // 8 a 15
    }
}
