package País;

// Definición de la clase País
public class País {
    // Atributos
    private String nombre;
    private long poblacion;
    private double pib; // PIB en millones

    // Constructor con parámetros
    public País(String nombre, long poblacion, double pib) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pib = pib;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public double getPib() {
        return pib;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    public void setPib(double pib) {
        this.pib = pib;
    }

    // Método para calcular PIB per cápita
    public double calcularPibPerCapita() {
        if (poblacion == 0) {
            return 0; // Evitar división por cero
        }
        return (pib * 100000) / poblacion;
    }
}
