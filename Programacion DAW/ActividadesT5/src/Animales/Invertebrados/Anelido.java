package Animales.Invertebrados;

public class Anelido extends Invertebrado {

    public Anelido(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un anélido.");
    }
    
}
