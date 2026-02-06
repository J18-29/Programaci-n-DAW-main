

import java.util.Date;

public class EjemplarDAO {
    Date fecha;
    int numeroPaginas;
    int numeroEjemplares;

    public EjemplarDAO(Date fecha, int numeroPaginas, int numeroEjemplares) {
        this.fecha = fecha;
        this.numeroPaginas = numeroPaginas;
        this.numeroEjemplares = numeroEjemplares;
    }

    @Override
    public String toString() {
        return "Ejemplar del " + fecha;
    }
}
