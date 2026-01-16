package Herencia;

public class Coche extends Vehiculo {

    public Coche(String matricula) {
        super(matricula);
    }

    @Override
    public int velocidadMaxima() {
        return 200;
    }
}
