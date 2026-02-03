public class SeMatriculaDAO {
    private Alumno2DAO alumno;
    private AsignaturaDAO asignatura;
    private CursoEscolarDAO curso;

    public SeMatriculaDAO(Alumno2DAO alumno, AsignaturaDAO asignatura, CursoEscolarDAO curso) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.curso = curso;
    }

    public void mostrar() {
        System.out.println(
            alumno.getNombreCompleto() +
            " está matriculado en " +
            asignatura.getNombre() +
            " en el curso " +
            curso.getDescripcion()
        );
    }
}
