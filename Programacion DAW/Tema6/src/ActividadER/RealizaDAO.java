import java.time.LocalDate;

public class RealizaDAO {
     AlumnoDAO alumno;
     PracticaDAO practica;
     LocalDate fecha;
     double nota;

    public RealizaDAO(AlumnoDAO alumno, PracticaDAO practica, LocalDate fecha, double nota) {
        this.alumno = alumno;
        this.practica = practica;
        this.fecha = fecha;
        this.nota = nota;
    }

    public void mostrar() {
        System.out.println(alumno.getNombreCompleto() +
                " realizó la práctica " + practica.getTitulo() +
                " con nota " + nota);
    }
}
