package Instituto;

public class Curso {
    Alumno alumno=null;
    Modulo modulo=null;

    public Curso(){}

    public Curso(Alumno alumno, Modulo modulo) {
        this.alumno = alumno;
        this.modulo = modulo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        if(alumno!=null && modulo!=null)
        return "Curso [alumno=" + alumno + ", modulo=" + modulo + "]";
        else return "No hay ningun dato";
    }
    
}
