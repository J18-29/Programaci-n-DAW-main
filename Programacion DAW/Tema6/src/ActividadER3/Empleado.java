public class Empleado {
     String id; // Clave Primaria
     String nif, nombre, apellido1, apellido2, telefono;
    
    public Empleado(String id, String nombre, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
    }
}