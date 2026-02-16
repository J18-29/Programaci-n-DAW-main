package src.Controlador;

import java.sql.Connection;
import src.Vista.CursoView;
import src.Modelo.*;

public class CursoController {

    private CursoView view;
    private AlumnoDAO alumnoDAO;
    private ProfesorDAO profesorDAO;
    private AsignaturaDAO asignaturaDAO;
    private CursoEscolarDAO cursoDAO;
    private MatriculaDAO matriculaDAO;

    public CursoController(Connection conexion) {
        // Importante: La vista debe ser la que tiene el sc.nextLine() corregido
        this.view = new CursoView();
        this.alumnoDAO = new AlumnoDAO(conexion);
        this.profesorDAO = new ProfesorDAO(conexion);
        this.asignaturaDAO = new AsignaturaDAO(conexion);
        this.cursoDAO = new CursoEscolarDAO(conexion);
        this.matriculaDAO = new MatriculaDAO(conexion);
    }

    public void iniciar() {
        int opcion = 0;
        do {
            try {
                opcion = view.mostrarMenu();

                switch (opcion) {
                    case 1: crearAlumno(); break;
                    case 2: crearProfesor(); break;
                    case 3: crearAsignatura(); break;
                    case 4: crearCurso(); break;
                    case 5: realizarMatrícula(); break;
                    case 6: view.mostrarMensaje("Saliendo del sistema..."); break;
                    default: view.mostrarMensaje("Opción no válida."); break;
                }
            } catch (Exception e) {
                // Esto atrapa el error "Unknown column 'nif'" y lo muestra sin cerrar el programa
                view.mostrarMensaje("ERROR: " + e.getMessage());
            }
        } while (opcion != 6);
    }

    private void crearAlumno() throws Exception {
        
        int numeroMatricula = view.pedirEntero("Número de matrícula");
        String nombre = view.pedirTexto("Nombre");
        String apellido1 = view.pedirTexto("Apellido1");
        String apellido2 = view.pedirTexto("Apellido2");
        String telefono = view.pedirTexto("Teléfono");
        String fecha_nacimiento = view.pedirTexto("Fecha de nacimiento (YYYY-MM-DD)");

        Alumno alumno = new Alumno(numeroMatricula, nombre, apellido1, apellido2, telefono, fecha_nacimiento);
        
       
        alumnoDAO.insertar(alumno);
        view.mostrarMensaje("Alumno creado correctamente.");
    }

    private void crearProfesor() throws Exception {
        String nombre = view.pedirTexto("Nombre");
        String apellido1 = view.pedirTexto("Apellido1");
        String apellido2 = view.pedirTexto("Apellido2");
        String especialidad = view.pedirTexto("Especialidad");
        String telefono = view.pedirTexto("Teléfono");

        Profesor profesor = new Profesor(0, nombre, apellido1, apellido2, especialidad, telefono);
        profesorDAO.insertar(profesor);
        view.mostrarMensaje("Profesor creado correctamente.");
    }

    private void crearAsignatura() throws Exception {
        String nombre = view.pedirTexto("Nombre asignatura");
        int horas = view.pedirEntero("Número de horas");
        int profesorId = view.pedirEntero("ID del profesor");

        Profesor profesor = profesorDAO.buscarPorId(profesorId);
        if (profesor != null) {
            Asignatura asignatura = new Asignatura(0, nombre, horas, profesor);
            asignaturaDAO.insertar(asignatura);
            view.mostrarMensaje("Asignatura creada correctamente.");
        } else {
            view.mostrarMensaje("Error: El profesor con ID " + profesorId + " no existe.");
        }
    }

    private void crearCurso() throws Exception {
        int inicio = view.pedirEntero("Año inicio");
        int fin = view.pedirEntero("Año fin");

        CursoEscolar curso = new CursoEscolar(0, inicio, fin);
        cursoDAO.insertar(curso);
        view.mostrarMensaje("Curso creado correctamente.");
    }

    private void realizarMatrícula() throws Exception {
        int alumnoId = view.pedirEntero("ID Alumno");
        int asignaturaId = view.pedirEntero("Código Asignatura");
        int cursoId = view.pedirEntero("ID Curso Escolar");

        Alumno alumno = alumnoDAO.buscarPorId(alumnoId);
        Asignatura asignatura = asignaturaDAO.buscarPorCodigo(asignaturaId);
        CursoEscolar curso = cursoDAO.buscarPorId(cursoId);

        if (alumno != null && asignatura != null && curso != null) {
            Matricula matricula = new Matricula(alumno, asignatura, curso);
            matriculaDAO.insertar(matricula);
            view.mostrarMensaje("Matrícula realizada correctamente.");
        } else {
            view.mostrarMensaje("Error: Uno de los IDs proporcionados no existe.");
        }
    }
}