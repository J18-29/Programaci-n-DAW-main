import java.time.LocalDate;

public class ColegioAlumnos {
    public static void main(String[] args) {

        Profesor2DAO prof = new Profesor2DAO(1, "Laura", "García", "Ruiz","Informática", "600123456");

        AsignaturaDAO asig = new AsignaturaDAO(101, "Programación", 240, prof);

        Alumno2DAO alu = new Alumno2DAO(1001, "Carlos", "López", "Martín",LocalDate.of(2004, 5, 10), "699888777");

        CursoEscolarDAO curso = new CursoEscolarDAO(1, 2024, 2025);     
        
        SeMatriculaDAO matricula = new SeMatriculaDAO(alu, asig, curso);

        matricula.mostrar();

        System.out.println("Profesor de la asignatura: " +
         asig.getProfesor().getNombreCompleto());
    }
}
