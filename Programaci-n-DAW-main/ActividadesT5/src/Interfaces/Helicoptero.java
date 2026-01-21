package Interfaces;

public class Helicoptero extends Vehiculo implements Volador {

    public Helicoptero(String marca) {
        super(marca);
    }

    @Override
    public void arrancar() {
        System.out.println(marca + " helicóptero está arrancando hélices");
    }

    @Override
    public void volar() {
        System.out.println(marca + " helicóptero está volando");
    }
}
