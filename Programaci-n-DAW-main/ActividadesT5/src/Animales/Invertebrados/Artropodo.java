package Animales.Invertebrados;


public class Artropodo extends Invertebrado {

    public Artropodo(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un artrópodo.");
    }
}
