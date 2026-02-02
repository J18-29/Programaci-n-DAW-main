package Herencia;

public class Mamifero extends Animal {
    protected int gestacion;

    public Mamifero(String nombre, String tipoAlimentacion, int edad, int gestacion) {
        super(nombre, tipoAlimentacion, edad);
        this.gestacion = gestacion;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tiempo de gestación: " + gestacion + " días");
    }
}
