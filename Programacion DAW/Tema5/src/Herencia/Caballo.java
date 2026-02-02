package Herencia;

public class Caballo extends Mamifero {
    private String comida;
    private int ejercicio;

    public Caballo(String nombre, String tipoAlimentacion, int edad, int gestacion,
                   String comida, int ejercicio) {
        super(nombre, tipoAlimentacion, edad, gestacion);
        this.comida = comida;
        this.ejercicio = ejercicio;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\n--- Caballo ---");
        super.mostrarInfo();
        System.out.println("Comida: " + comida);
        System.out.println("Horas de ejercicio: " + ejercicio);
    }
}
