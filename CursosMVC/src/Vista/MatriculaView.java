package src.Vista;



import src.Modelo.Alumno;
import src.Modelo.Asignatura;
import src.Modelo.CursoEscolar;
import src.Modelo.Profesor;

public class MatriculaView {
    private String nombreAlumno;
    private String asignatura;
    private String profesor;
    private String curso;

    public MatriculaView(Alumno alumno, Asignatura asignatura, CursoEscolar curso) {
        this.nombreAlumno = alumno.getNombre() + " " + alumno.getApellido1() + " " + alumno.getApellido2();
        this.asignatura = asignatura.getNombre();
        Profesor prof = asignatura.getProfesor();
        this.profesor = prof.getNombre() + " " + prof.getApellido1() + " " + prof.getApellido2();
        this.curso = curso.getAnioInicio() + "-" + curso.getAnioFin();
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getCurso() {
        return curso;
    }
}
