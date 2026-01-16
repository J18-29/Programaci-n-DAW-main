
public class Persona {
    // Atributos
    private String nombre;
    private String dni;
    private String fechaNacimiento;
    private String direccion;
    private String genero;
    private String estadoCivil;

    // Constructor
    public Persona(String nombre, String dni, String fechaNacimiento, String direccion, String genero, String estadoCivil) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
    }

    // Métodos getter y setter
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    // Método para mostrar información
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Dirección: " + direccion);
        System.out.println("Género: " + genero);
        System.out.println("Estado Civil: " + estadoCivil);
    }
}
