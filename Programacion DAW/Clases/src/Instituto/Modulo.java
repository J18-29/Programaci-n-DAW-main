package Instituto;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
    private int codigo;
    private String nombre;
    private Profesor profesor;      // Un profesor imparte este módulo
    private List<Alumno> alumnos = new ArrayList<>();  // Muchos alumnos cursan este módulo

    public Modulo() {}

    public Modulo(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;

        // Mostrar en consola cuando se asigna un profesor
        System.out.println("El módulo " + nombre + " ahora es impartido por " + profesor.getNombre());
    }

    // Añadir alumno al módulo
    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);

        // Informar por consola
        System.out.println(alumno.getNombre() + " se ha matriculado en el módulo: " + nombre);
    }

    @Override
    public String toString() {
        return "Modulo [codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}
