package Interfaces;

public abstract class SeleccionFutbol implements IntegranteSeleccionFutbol {

    protected int id;
    protected String nombre;
    protected String apellidos;
    protected int edad;

    public SeleccionFutbol(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    // Métodos comunes
    @Override
    public void concentrarse() {
        System.out.println(nombre + " se concentra.");
    }

    @Override
    public void viajar() {
        System.out.println(nombre + " viaja con la selección.");
    }

   
}

