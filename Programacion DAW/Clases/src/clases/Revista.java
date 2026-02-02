package Clases;
import java.util.ArrayList;

public class Revista {
    private int numeroRegistro;
    private String titulo;
    private String tipo;
    private String periodicidad;

    private ArrayList<Periodista> periodistas = new ArrayList<>();
    private ArrayList<Ejemplar> ejemplares = new ArrayList<>();

    public Revista(int numeroRegistro, String titulo, String tipo, String periodicidad) {
        this.numeroRegistro = numeroRegistro;
        this.titulo = titulo;
        this.tipo = tipo;
        this.periodicidad = periodicidad;
    }

    // Getters & Setters
    public int getNumeroRegistro() { return numeroRegistro; }
    public void setNumeroRegistro(int numeroRegistro) { this.numeroRegistro = numeroRegistro; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getPeriodicidad() { return periodicidad; }
    public void setPeriodicidad(String periodicidad) { this.periodicidad = periodicidad; }

    public void addPeriodista(Periodista p) { if (!periodistas.contains(p)) periodistas.add(p); }
    public ArrayList<Periodista> getPeriodistas() { return periodistas; }

    public void addEjemplar(Ejemplar e) { if (!ejemplares.contains(e)) ejemplares.add(e); }
    public ArrayList<Ejemplar> getEjemplares() { return ejemplares; }

    @Override
    public String toString() {
        return "Revista{" +
                "numeroRegistro=" + numeroRegistro +
                ", titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", periodicidad='" + periodicidad + '\'' +
                '}';
    }
}
