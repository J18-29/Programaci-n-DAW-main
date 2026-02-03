import java.time.LocalDate;

public class DisenaPracticaDAO {
     ProfesorDAO profesor;
     PracticaDAO practica;
     LocalDate fecha;

    public DisenaPracticaDAO(ProfesorDAO profesor, PracticaDAO practica, LocalDate fecha) {
        this.profesor = profesor;
        this.practica = practica;
        this.fecha = fecha;
    }

    public void mostrar() {
        System.out.println("El profesor " + profesor.getNombreCompleto() +
                " diseñó la práctica " + practica.getTitulo());
    }
}

