package Animales.Invertebrados;

public class Molusco extends Invertebrado {

    public Molusco(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un molusco.");
    }
    
}
