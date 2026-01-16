package Instituto;

public class Delegado {
    Alumno alumno=null;

    public Delegado(){}

    public Delegado(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Delegado [alumno=" + alumno + "]";
    }
    
}
