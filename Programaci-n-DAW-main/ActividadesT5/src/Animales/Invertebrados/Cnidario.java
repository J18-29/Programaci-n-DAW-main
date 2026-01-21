package Animales.Invertebrados;

public class Cnidario extends Invertebrado {

    public Cnidario(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un cnidario.");
    }
    
}
