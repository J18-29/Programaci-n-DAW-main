public abstract class Vehiculo implements Parkeable {
    private String matricula;
    private static int plazasOcupadas = 0;
    private static int plazasTotales = 50;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void entrar() {
        if (plazasOcupadas < plazasTotales) {
            plazasOcupadas++;
            System.out.println("Vehículo con matrícula " + matricula + " ha entrado. Plazas ocupadas: " + plazasOcupadas);
        } else {
            System.out.println("No hay plazas disponibles para el vehículo con matrícula " + matricula);
        }
    }
    @Override
    public void salir() {
        if (plazasOcupadas > 0) {
            plazasOcupadas--;
            System.out.println("Vehículo con matrícula " + matricula + " ha salido. Plazas ocupadas: " + plazasOcupadas);
        } else {
            System.out.println("No hay vehículos para salir.");
        }
    }
    
} 
    

