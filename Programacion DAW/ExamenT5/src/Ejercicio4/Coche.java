package Ejercicio4;

public class Coche extends Vehiculo {
    public Coche(String matricula) {
        super(matricula);
    }

    @Override
    public void entrar() {
        System.out.println("El coche ha entrado al parking.");
    }

    @Override
    public void salir() {
        System.out.println("El coche ha salido del parking.");
    }

    //Calcular tarifa en base a horas estacionadas
    public double calcularTarifa(int horasEstacionadas) {
        double tarifaPorHora = 2.0; 
        return horasEstacionadas * tarifaPorHora;
    }
    
}
