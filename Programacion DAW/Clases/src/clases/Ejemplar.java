package Clases;
import java.util.ArrayList;

public class Ejemplar {
    private String fecha;
    private int numeroPaginas;
    private int numeroEjemplares;

    private ArrayList<Seccion> secciones = new ArrayList<>();

    public Ejemplar(String fecha, int numeroPaginas, int numeroEjemplares) {
        this.fecha = fecha;
        this.numeroPaginas = numeroPaginas;
        this.numeroEjemplares = numeroEjemplares;
    }

    // Getters & Setters
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }

    public int getNumeroEjemplares() { return numeroEjemplares; }
    public void setNumeroEjemplares(int numeroEjemplares) { this.numeroEjemplares = numeroEjemplares; }

    public void addSeccion(Seccion s) { if (!secciones.contains(s)) secciones.add(s); }
    public ArrayList<Seccion> getSecciones() { return secciones; }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "fecha='" + fecha + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", numeroEjemplares=" + numeroEjemplares +
                '}';
    }
}
