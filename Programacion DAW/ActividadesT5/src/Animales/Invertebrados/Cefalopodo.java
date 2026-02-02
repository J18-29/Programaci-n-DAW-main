package Animales.Invertebrados;

public class Cefalopodo extends Invertebrado {

    public Cefalopodo(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un cefalópodo.");
    }
    
}