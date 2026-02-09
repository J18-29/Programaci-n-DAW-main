

import java.util.*;

public class RevistaDAO2 {
     int numeroRegistro;
     String titulo;
     String tipo;
     String periodicidad;

    private List<SeccionDAO2> secciones = new ArrayList<>();
    private List<EjemplarDAO2> ejemplares = new ArrayList<>();
    private List<PeriodistaDAO2> periodistas = new ArrayList<>();

    public RevistaDAO2(int numeroRegistro, String titulo, String tipo, String periodicidad) {
        this.numeroRegistro = numeroRegistro;
        this.titulo = titulo;
        this.tipo = tipo;
        this.periodicidad = periodicidad;
    }

    public void agregarSeccion(SeccionDAO2 s) {
        secciones.add(s);
    }

    public void agregarEjemplar(EjemplarDAO2 e) {
        ejemplares.add(e);
    }

    public void agregarPeriodista(PeriodistaDAO2 p) {
        periodistas.add(p);
    }

    @Override
    public String toString() {
        return titulo;
    }
}

