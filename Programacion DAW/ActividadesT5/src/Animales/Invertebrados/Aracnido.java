package Animales.Invertebrados;

public class Aracnido extends Invertebrado {

    public Aracnido(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un arácnido.");
    }
    
}
