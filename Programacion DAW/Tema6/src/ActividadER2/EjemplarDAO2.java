

import java.util.Date;

public class EjemplarDAO2 {
    Date fecha;
    int numeroPaginas;
    int numeroEjemplares;

    public EjemplarDAO2(Date fecha, int numeroPaginas, int numeroEjemplares) {
        this.fecha = fecha;
        this.numeroPaginas = numeroPaginas;
        this.numeroEjemplares = numeroEjemplares;
    }

    @Override
    public String toString() {
        return "Ejemplar del " + fecha;
    }
}
