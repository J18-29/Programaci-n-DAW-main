public class Periodista {
     String id;
    private String nombre;
    private String especialidad;

    public Periodista(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Esto evita que salga el error de "Periodista@c387f44"
    @Override
    public String toString() {
        return nombre + " (Especialidad: " + especialidad + ")";
    }
}