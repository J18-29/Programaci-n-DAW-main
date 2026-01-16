package Agenda.src;

public class Persona {
    private String nombre;
    private String domicilio;
    private int telefono;

    // Constructor vacío
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(String nombre, String domicilio, int telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // Método para imprimir la información
    public void imprimePersona() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Teléfono: " + telefono);
    }

    // Método toString (opcional pero útil)
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}

