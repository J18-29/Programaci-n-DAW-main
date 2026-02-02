package Animales.Vertebrados;

public class Pez extends Vertebrado {

    public Pez(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un pez.");
    }
    
}
