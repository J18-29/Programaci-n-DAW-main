package Vista;



import java.util.Date;
import java.util.Scanner;

import Modelo.Alumno;
import Modelo.Disena;
import Modelo.ExamenTeorico;
import Modelo.Hace;
import Modelo.Practica;
import Modelo.Profesor;
import Modelo.Realiza;

public class ClaseView {

    private Scanner sc = new Scanner(System.in);

    public int menu() {

        System.out.println("\n===== MENÚ =====");
        System.out.println("1. Insertar Alumno");
        System.out.println("2. Insertar Profesor");
        System.out.println("3. Insertar Práctica");
        System.out.println("4. Insertar Examen");
        System.out.println("5. Alumno realiza Práctica");
        System.out.println("6. Alumno hace Examen");
        System.out.println("7. Profesor diseña Práctica");
        System.out.println("0. Salir");
        System.out.print("Opción: ");

        return sc.nextInt();
    }

    // ---------- ENTIDADES ----------

    public Alumno pedirAlumno() {

        sc.nextLine();

        System.out.print("NIF: ");
        String nif = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido1: ");
        String ap1 = sc.nextLine();

        System.out.print("Apellido2: ");
        String ap2 = sc.nextLine();

        System.out.print("Grupo: ");
        String grupo = sc.nextLine();

        return new Alumno(0, nif, nombre, ap1, ap2, grupo);
    }

    public Profesor pedirProfesor() {

        sc.nextLine();

        System.out.print("NIF: ");
        String nif = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido1: ");
        String ap1 = sc.nextLine();

        System.out.print("Apellido2: ");
        String ap2 = sc.nextLine();

        return new Profesor(0, nif, nombre, ap1, ap2);
    }

    public Practica pedirPractica() {

        sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Dificultad: ");
        String dificultad = sc.nextLine();

        return new Practica(0, titulo, dificultad);
    }

    public ExamenTeorico pedirExamen() {

        sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Número de preguntas: ");
        int num = sc.nextInt();

        System.out.print("ID Profesor que lo diseña: ");
        int idProfesor = sc.nextInt();

        return new ExamenTeorico(0, titulo, num, new Date(), idProfesor);
    }

    // ---------- RELACIONES ----------

    public Realiza pedirRealiza() {

        System.out.print("ID Alumno: ");
        int idAlumno = sc.nextInt();

        System.out.print("ID Práctica: ");
        int idPractica = sc.nextInt();

        System.out.print("Nota: ");
        double nota = sc.nextDouble();

        return new Realiza(idAlumno, idPractica, new Date(), nota);
    }

    public Hace pedirHace() {

        System.out.print("ID Alumno: ");
        int idAlumno = sc.nextInt();

        System.out.print("ID Examen: ");
        int idExamen = sc.nextInt();

        System.out.print("Nota: ");
        double nota = sc.nextDouble();

        return new Hace(idAlumno, idExamen, nota);
    }

    public Disena pedirDisenaPractica() {

        System.out.print("ID Profesor: ");
        int idProfesor = sc.nextInt();

        System.out.print("ID Práctica: ");
        int idPractica = sc.nextInt();

        return new Disena(idProfesor, idPractica, new Date());
    }
}

