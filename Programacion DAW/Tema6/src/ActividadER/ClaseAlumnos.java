import java.time.LocalDate;

public class ClaseAlumnos {
    public static void main(String[] args) {

        AlumnoDAO a1 = new AlumnoDAO(1, "12345678A", "Juan", "Pérez", "Gómez", "DAM1");
        ProfesorDAO p1 = new ProfesorDAO(1, "87654321B", "Ana", "López", "Martín");

        PracticaDAO pr1 = new PracticaDAO(1, "Práctica BD", "Media");
        ExamenTeoricoDAO ex1 = new ExamenTeoricoDAO(
                1, "Examen SQL", 20, LocalDate.now(), p1);

        RealizaDAO r1 = new RealizaDAO(a1, pr1, LocalDate.now(), 8.5);
        HaceDAO h1 = new HaceDAO(a1, ex1, 7.8);
        DisenaPracticaDAO d1 = new DisenaPracticaDAO(p1, pr1, LocalDate.now());

        r1.mostrar();
        h1.mostrar();
        d1.mostrar();

        System.out.println("El examen fue diseñado por: " +
                ex1.getProfesor().getNombreCompleto());
    }
}
