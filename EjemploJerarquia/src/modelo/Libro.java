package src.Modelo;

public class Libro {
    private int id;
    private String isbn;
    private String titulo;
    private int anyo; 
    private String descripcion;

    // Constructor vacío
    public Libro() {}

    // Constructor con todos los campos
    public Libro(int id, String isbn, String titulo, int anyo, String descripcion) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anyo = anyo;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
