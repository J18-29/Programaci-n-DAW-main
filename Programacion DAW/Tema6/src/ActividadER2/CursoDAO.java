

import java.util.*;

public class CursoDAO {
     int id;
     String nombre;
     String descripcion;
     int duracion;
     double coste;

    private List<EdicionDAO> ediciones = new ArrayList<>();
    private Map<CursoDAO, Boolean> prerrequisitos = new HashMap<>();

    public CursoDAO(int id, String nombre, String descripcion, int duracion, double coste) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.coste = coste;
    }

    public void agregarEdicion(EdicionDAO e) {
        ediciones.add(e);
    }

    public void agregarPrerrequisito(CursoDAO curso, boolean obligatorio) {
        prerrequisitos.put(curso, obligatorio);
    }

    public String getNombre() {
        return nombre;
    }

    public List<EdicionDAO> getEdiciones() {
        return ediciones;
    }

    @Override
    public String toString() {
        return "Curso: " + nombre;
    }
}
