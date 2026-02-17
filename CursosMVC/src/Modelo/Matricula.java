package src.Modelo;

public class Matricula {
    private Alumno alumno;
    private Asignatura asignatura;
    private CursoEscolar curso;

    public Matricula(Alumno alumno2, Asignatura asignatura, CursoEscolar curso) {
        this.alumno = alumno2;
        this.asignatura = asignatura;
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public CursoEscolar getCurso() {
        return curso;
    }

    public void setCurso(CursoEscolar curso) {
        this.curso = curso;
    }

    
    
}
