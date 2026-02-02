package Animales.Vertebrados;

public class Anfibio extends Vertebrado {

    public Anfibio(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un anfibio.");
    }
    
}
