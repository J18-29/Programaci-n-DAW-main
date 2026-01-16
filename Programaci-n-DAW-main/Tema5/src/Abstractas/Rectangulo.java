package Abstractas;

public class Rectangulo extends Figura {
    private double ancho;
    private double alto;

    public Rectangulo(String nombre, double ancho, double alto) {
        super(nombre);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }
}
