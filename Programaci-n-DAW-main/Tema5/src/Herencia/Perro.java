package Herencia;

public class Perro extends Mamifero {
    private String raza;

    public Perro(String nombre, String tipoAlimentacion, int edad, int gestacion, String raza) {
        super(nombre, tipoAlimentacion, edad, gestacion);
        this.raza = raza;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\n--- Perro ---");
        super.mostrarInfo();
        System.out.println("Raza: " + raza);
    }
}
