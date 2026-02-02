package Interfaces;

public class Avion extends Vehiculo implements Volador {

    public Avion(String marca) {
        super(marca);
    }

    @Override
    public void arrancar() {
        System.out.println(marca + " avión está arrancando motores");
    }

    @Override
    public void volar() {
        System.out.println(marca + " avión está volando");
    }
}

