

public class Vehiculo {
    private String matricula;
    private static int plazasOcupadas = 0;
    private static int plazasTotales = 50;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public void entrar() {
        System.out.println("El vehículo con matrícula " + matricula + " ha entrado al parking.");
        plazasOcupadas++;
    }

    public void salir() {
        System.out.println("El vehículo con matrícula " + matricula + " ha salido del parking.");
        plazasOcupadas--;
    }

    public static int getPlazasLibres() {
        return plazasTotales - plazasOcupadas;
    }

    
} 
    

