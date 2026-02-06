

import java.util.*;

public class RevistaDAO {
     int numeroRegistro;
     String titulo;
     String tipo;
     String periodicidad;

    private List<SeccionDAO> secciones = new ArrayList<>();
    private List<EjemplarDAO> ejemplares = new ArrayList<>();
    private List<PeriodistaDAO> periodistas = new ArrayList<>();

    public RevistaDAO(int numeroRegistro, String titulo, String tipo, String periodicidad) {
        this.numeroRegistro = numeroRegistro;
        this.titulo = titulo;
        this.tipo = tipo;
        this.periodicidad = periodicidad;
    }

    public void agregarSeccion(SeccionDAO s) {
        secciones.add(s);
    }

    public void agregarEjemplar(EjemplarDAO e) {
        ejemplares.add(e);
    }

    public void agregarPeriodista(PeriodistaDAO p) {
        periodistas.add(p);
    }

    @Override
    public String toString() {
        return titulo;
    }
}

