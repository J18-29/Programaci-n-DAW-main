
import java.util.*;

public class AlmacenDAO {
     int id;
     String direccion;
     String telefono;

    private Map<LibroConcretoDAO, Integer> stock = new HashMap<>();

    public AlmacenDAO(int id, String direccion, String telefono) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void almacenarLibro(LibroConcretoDAO libro, int cantidad) {
        stock.put(libro, cantidad);
    }
}

