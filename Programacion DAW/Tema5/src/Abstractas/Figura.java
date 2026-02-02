package Abstractas;

public abstract class Figura {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    @Override
    public String toString() {
        return "Figura: " + nombre +
               " | Área: " + calcularArea() +
               " | Perímetro: " + calcularPerimetro();
    }
}
