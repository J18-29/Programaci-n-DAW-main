

public class ProvinciaDAO {
    int id;
    String nombre;

    public ProvinciaDAO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

