public class Ejemplar {
    private String fecha;
    private int numPaginas;
     int numEjemplares;

    public Ejemplar(String fecha, int numPaginas, int numEjemplares) {
        this.fecha = fecha;
        this.numPaginas = numPaginas;
        this.numEjemplares = numEjemplares;
    }

    public String getInfo() {
        return "Ejemplar Fecha: " + fecha + " [" + numPaginas + " págs]";
    }
}