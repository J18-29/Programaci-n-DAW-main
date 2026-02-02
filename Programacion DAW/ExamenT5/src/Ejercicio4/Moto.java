package Ejercicio4;

public class Moto extends Vehiculo {
    public Moto(String matricula) {
        super(matricula);
    }

    @Override
    public void entrar() {
        System.out.println("La moto ha entrado al parking.");
    }

    @Override
    public void salir() {
        System.out.println("La moto ha salido del parking.");
    }

    //Calcular tarifa en base a horas estacionadas
    public double calcularTarifa(int horasEstacionadas) {
        double tarifaPorHora = 1.0; 
        return horasEstacionadas * tarifaPorHora;
    }
    
}
