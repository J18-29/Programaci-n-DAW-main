package Herencia;

public abstract class Vehiculo {
    protected String matricula;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    // Método abstracto
    public abstract int velocidadMaxima();

    // Método concreto
    public void mostrarInfo() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Velocidad máxima: " + velocidadMaxima() + " km/h");
    }
}
