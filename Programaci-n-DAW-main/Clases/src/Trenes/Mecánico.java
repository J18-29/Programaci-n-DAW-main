package Trenes;

public class Mecánico {
    public enum Especialidad { 
        FRENOS, HIDRAULICA, ELECTRICIDAD, MOTOR 
    }

    String nombre;
    String dni;
    String telefono;
    Especialidad especialidad;

    public Mecánico(String nombre, String dni, String telefono, Especialidad especialidad) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mecánico [nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", especialidad="
                + especialidad + "]";
    }

    
}
