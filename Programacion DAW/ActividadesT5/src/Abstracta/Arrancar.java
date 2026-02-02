package Abstracta;

public class Arrancar {

    public static void main(String[] args) {

        Vehiculo coche = new Coche("Toyota");
        Vehiculo moto = new Moto("Yamaha");

        coche.arrancar();
        coche.frenar();

        moto.arrancar();
        moto.frenar();
    }
}
