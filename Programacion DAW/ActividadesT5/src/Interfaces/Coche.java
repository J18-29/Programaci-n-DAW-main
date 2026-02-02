package Interfaces;

public class Coche extends Vehiculo {

    public Coche(String marca) {
        super(marca);
    }

    @Override
    public void arrancar() {
        System.out.println(marca + " coche está arrancando");
    }
}

