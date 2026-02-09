

import java.util.*;

public class EdicionDAO {
     int id;
     Date fechaInicio;
     Date fechaFin;
     String horario;
     String lugar;

    private CursoDAO curso;
    private List<EmpleadoDAO2> alumnos = new ArrayList<>();
     CapacitadoDAO instructor;

    public EdicionDAO(int id, Date inicio, Date fin, String horario, String lugar, CursoDAO curso) {
        this.id = id;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.horario = horario;
        this.lugar = lugar;
        this.curso = curso;
        curso.agregarEdicion(this);
    }

    public void agregarAlumno(EmpleadoDAO2 e) {
        alumnos.add(e);
    }

    public void asignarInstructor(CapacitadoDAO c) {
        this.instructor = c;
    }

    @Override
    public String toString() {
        return "Edición " + id + " del curso " + curso.getNombre();
    }
}
