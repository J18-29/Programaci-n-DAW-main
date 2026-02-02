package Abstracta;

public class Moto extends Vehiculo {

    public Moto(String marca) {
        super(marca);
    }

    @Override
    public void arrancar() {
        System.out.println(marca + " moto está arrancando");
    }
}
