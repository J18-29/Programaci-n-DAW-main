package Abstracta;

public abstract class Vehiculo {

    protected String marca;

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    // Método abstracto
    public abstract void arrancar();

    // Método concreto
    public void frenar() {
        System.out.println(marca + " está frenando");
    }
}

