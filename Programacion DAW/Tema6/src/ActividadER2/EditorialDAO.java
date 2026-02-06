

public class EditorialDAO {
     int id;
     String nombre;
     String direccion;
     String telefono;
     String url;

    public EditorialDAO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

