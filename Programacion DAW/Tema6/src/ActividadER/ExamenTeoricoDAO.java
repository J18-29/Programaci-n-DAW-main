import java.time.LocalDate;

public class ExamenTeoricoDAO {
     int id;
     String titulo;
     int numeroPreguntas;
     LocalDate fecha;
     ProfesorDAO profesor;

    public ExamenTeoricoDAO(int id, String titulo, int numeroPreguntas, LocalDate fecha, ProfesorDAO profesor) {
        this.id = id;
        this.titulo = titulo;
        this.numeroPreguntas = numeroPreguntas;
        this.fecha = fecha;
        this.profesor = profesor;
    }

    public String getTitulo() {
        return titulo;
    }

    public ProfesorDAO getProfesor() {
        return profesor;
    }
}
