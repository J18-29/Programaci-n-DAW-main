import java.util.ArrayList;
import java.util.List;

public abstract class LibroDAO {
    protected int id;
    protected String titulo;
    protected String isbn;
    protected int anioPublicacion;
    protected String descripcion;

    protected List<AutorDAO> autores = new ArrayList<>();
    protected EditorialDAO editorial;

    public LibroDAO(int id, String titulo, String isbn, int anioPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    public void agregarAutor(AutorDAO autor) {
        autores.add(autor);
        autor.escribirLibro(this);
    }

    public void setEditorial(EditorialDAO editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
