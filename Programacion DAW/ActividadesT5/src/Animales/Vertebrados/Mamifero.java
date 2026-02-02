package Animales.Vertebrados;


public class Mamifero extends Vertebrado {

    public Mamifero(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un mamífero.");
    }
}
