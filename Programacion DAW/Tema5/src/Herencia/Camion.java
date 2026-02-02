package Herencia;
public class Camion extends Vehiculo {

    public Camion(String matricula) {
        super(matricula);
    }

    @Override
    public int velocidadMaxima() {
        return 120;
    }
}
