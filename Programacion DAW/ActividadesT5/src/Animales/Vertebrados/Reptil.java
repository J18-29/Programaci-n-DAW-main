package Animales.Vertebrados;

public class Reptil extends Vertebrado {

    public Reptil(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un reptil.");
    }
    
}
