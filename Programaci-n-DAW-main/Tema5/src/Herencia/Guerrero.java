package Herencia;

import java.util.Random;

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre, 100);
    }

    @Override
    public int atacar() {
        return new Random().nextInt(11) + 10; // 10 a 20
    }
}
