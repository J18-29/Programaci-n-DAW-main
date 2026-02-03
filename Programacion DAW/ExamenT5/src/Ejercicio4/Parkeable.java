
public class Parkeable extends Vehiculo {

    public Parkeable(String matricula) {
        super(matricula);
    }
    @Override
    public void entrar() {
        System.out.println("El parkeable ha entrado al parking.");
    }
    @Override
    public void salir() {
        System.out.println("El parkeable ha salido del parking.");
    }
     
    public double calcularTarifa(int horasEstacionadas) {
        double tarifaPorHora = 1.5; 
        return horasEstacionadas * tarifaPorHora;
    }
 
}