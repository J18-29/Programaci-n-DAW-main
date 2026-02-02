package Instituto;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    // Atributos
    private String dni, nombre, direccion, telefono;
    private Modulo modulo;
    private List<Modulo> modulosImpartidos = new ArrayList<>();
    private List<Alumno> delegados = new ArrayList<>();

    // Constructores
    public Profesor() {}

    public Profesor(String dni, String nombre, String direccion, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public void setModulo(Modulo modulo) { this.modulo = modulo; }
    public Modulo getModulo() { return modulo; }

    // MÉTODO: El profesor imparte un módulo
    public void impartirModulo(Modulo m) {
        modulosImpartidos.add(m);
        m.setProfesor(this); // Relación bidireccional

        // Mostrar en consola
        System.out.println(nombre + " ahora imparte el módulo: " + m.getNombre());
    }

    // MÉTODO: Añadir un delegado
    public void addDelegado(Alumno alumno) {
        delegados.add(alumno);
        alumno.setProfesorDelegado(this);

        // Mostrar en consola
        System.out.println(alumno.getNombre() + " es delegado de " + nombre);
    }

    @Override
    public String toString() {
        return "Profesor [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
    }
}
