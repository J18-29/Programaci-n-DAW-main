package Herencia;



public class Animal {
    protected String nombre;
    protected String tipoAlimentacion;
    protected int edad;

    public Animal(String nombre, String tipoAlimentacion, int edad) {
        this.nombre = nombre;
        this.tipoAlimentacion = tipoAlimentacion;
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo de alimentación: " + tipoAlimentacion);
        System.out.println("Edad: " + edad);
    }
}
