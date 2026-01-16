package Herencia;

public class Gato extends Mamifero {
    private String pedigrí;

    public Gato(String nombre, String tipoAlimentacion, int edad, int gestacion, String pedigrí) {
        super(nombre, tipoAlimentacion, edad, gestacion);
        this.pedigrí = pedigrí;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\n--- Gato ---");
        super.mostrarInfo();
        System.out.println("Pedigrí: " + pedigrí);
    }
}

