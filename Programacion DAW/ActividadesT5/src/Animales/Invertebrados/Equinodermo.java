package Animales.Invertebrados;

public class Equinodermo extends Invertebrado {

    public Equinodermo(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un equinodermo.");
    }
    
}
