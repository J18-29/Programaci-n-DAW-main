



import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class CestaDAO {

    private int id;
    private LocalDate fechaCompra;
    private ClienteDAO cliente;
    private Map<LibroConcretoDAO, Integer> libros;

    public CestaDAO(int id, LocalDate fechaCompra, ClienteDAO cliente) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.libros = new HashMap<>();

        if (cliente != null) {
            cliente.agregarCesta(this);
        }
    }


    public void agregarLibro(LibroConcretoDAO libro, int cantidad) {
        if (libro == null || cantidad <= 0) {
            throw new IllegalArgumentException("Libro o cantidad inválidos");
        }
        libros.put(libro, cantidad);
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public ClienteDAO getCliente() {
        return cliente;
    }

    public Map<LibroConcretoDAO, Integer> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        return "Cesta " + id + " de " + cliente;
    }
}
