package Modelo;

public class Persona implements Identificacion {

    private String DNI;
    private String nombre;
    private String pape;

    public Persona(String DNI, String nombre, String pape) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pape = pape;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPape() {
        return pape;
    }

    public void setPape(String pape) {
        this.pape = pape;
    }

    @Override
    public String identificar() {
        return "Persona con DNI: " + DNI;
    }
}
