package Animales.Vertebrados;

public class Ave extends Vertebrado {

    public Ave(String nombre) {
        super(nombre);
    }

    @Override
    public void describir() {
        System.out.println(nombre + " es un ave.");
    }
    
}
