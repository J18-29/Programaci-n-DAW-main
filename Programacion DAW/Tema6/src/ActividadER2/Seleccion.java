import java.util.Date;

public class Seleccion {
    public static void main(String[] args) {

        // Crear cursos
        CursoDAO java = new CursoDAO(1, "Java", "Programación en Java", 40, 300);
        CursoDAO poo = new CursoDAO(2, "POO", "Programación Orientada a Objetos", 20, 150);

        // Prerrequisito
        java.agregarPrerrequisito(poo, true);

        // Crear edición
        EdicionDAO ed1 = new EdicionDAO(101, new Date(),new Date(), "Lunes a Viernes","Aula 1",java );

        // Crear sucursal
        SucursalDAO sucursal = new SucursalDAO(1,"Calle Mayor 1","Madrid","Madrid","910000000");

        // Crear empleados
        CapacitadoDAO profesor = new CapacitadoDAO(1,"12345678A","Ana","García","López","600123123",sucursal);

        NoCapacitadoDAO alumno = new NoCapacitadoDAO(2, "87654321B","Luis","Martín", "Pérez","600456456",sucursal );

        // Asignar relaciones
        ed1.asignarInstructor(profesor);
        ed1.agregarAlumno(alumno);

        // Mostrar resultados
        System.out.println(java);
        System.out.println("Ediciones del curso:");
        for (EdicionDAO e : java.getEdiciones()) {
            System.out.println(" - " + e);
        }

        System.out.println("Instructor: " + profesor);
        System.out.println("Alumno inscrito: " + alumno);
    }
}
