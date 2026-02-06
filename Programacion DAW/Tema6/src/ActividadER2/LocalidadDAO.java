

public class LocalidadDAO {
     int id;
     String nombre;
     ProvinciaDAO provincia;

    public LocalidadDAO(int id, String nombre, ProvinciaDAO provincia) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return nombre + " (" + provincia + ")";
    }
}

