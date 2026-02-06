import java.util.*;

public class AutorDAO {
    int id;
    String nombre;
    String apellido1;
    String apellido2;
    String url;
    String telefono;
    String direccion;

    private List<LibroDAO> libros = new ArrayList<>(); // cambiar tipo a LibroDAO

    public AutorDAO(int id, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    // Acepta cualquier tipo de LibroDAO
    public void escribirLibro(LibroDAO libro) {
        if (libro != null) {
            libros.add(libro);
        }
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1;
    }
}

