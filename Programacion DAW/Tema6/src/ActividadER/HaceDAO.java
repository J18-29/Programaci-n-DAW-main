
public class HaceDAO {
    private AlumnoDAO alumno;
    private ExamenTeoricoDAO examen;
    private double nota;

    public HaceDAO(AlumnoDAO alumno, ExamenTeoricoDAO examen, double nota) {
        this.alumno = alumno;
        this.examen = examen;
        this.nota = nota;
    }

    public void mostrar() {
        System.out.println(alumno.getNombreCompleto() +
                " hizo el examen " + examen.getTitulo() +
                " con nota " + nota);
    }
}
