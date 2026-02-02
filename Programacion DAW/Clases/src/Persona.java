
    public class Persona {
    // 1. Encapsulamiento: Atributos privados
    private String nombre;
    private String DNI;
    private String fechaNacimiento; // Mejor nombre para 'fecha'
    private String direccion;
    private Boolean genero;      // true = Masculino, false = Femenino (ejemplo de interpretación)
    private Boolean estadoCivil; // true = Casado, false = Soltero (ejemplo de interpretación)

    // Constructor por defecto
    public Persona() {
        // Inicialización por defecto, si es necesaria
    }

    // Constructor con parámetros
    public Persona(String nombre, String DNI, String fechaNacimiento, String direccion, Boolean genero, Boolean estadoCivil) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.genero = genero;
        // 3. ¡CORRECCIÓN APLICADA AQUÍ! Se usaba 'estado' en lugar de 'estadoCivil'
        this.estadoCivil = estadoCivil;
    }

    // 2. Getters
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public Boolean getGenero() {
        return genero;
    }

    public Boolean getEstadoCivil() {
        return estadoCivil;
    }

    // 2. Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    public void setEstadoCivil(Boolean estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    // 4. Implementación de mostrarInformacion()
    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "\nDNI: " + DNI +
               "\nFecha de Nacimiento: " + fechaNacimiento +
               "\nDirección: " + direccion +
               "\nGénero: " + (genero != null ? (genero ? "Masculino" : "Femenino") : "No especificado") +
               "\nEstado Civil: " + (estadoCivil != null ? (estadoCivil ? "Casado" : "Soltero") : "No especificado");
    }
    
    // Método solicitado para mostrar la información
    public void mostrarInformacion() {
        System.out.println("--- Información de la Persona ---");
        System.out.println(this.toString());
        System.out.println("---------------------------------");
    }
}

