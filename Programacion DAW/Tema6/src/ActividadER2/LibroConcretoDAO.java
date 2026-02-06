public class LibroConcretoDAO extends LibroDAO {

    private double precio;

    public LibroConcretoDAO(int id, String titulo, String isbn, int anioPublicacion, double precio) {
        super(id, titulo, isbn, anioPublicacion);
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return super.toString() + " - Precio: " + precio;
    }
}

