package Interfaces;

public class Entrenador extends SeleccionFutbol {

     int idFederacion;

    public Entrenador(int id, String nombre, String apellidos, int edad, int idFederacion) {
        super(id, nombre, apellidos, edad);
        this.idFederacion = idFederacion;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " dirige el entrenamiento.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(nombre + " dirige el partido desde el banquillo.");
    }

    public void planificarEntrenamiento() {
        System.out.println(nombre + " planifica el entrenamiento.");
    }
}
