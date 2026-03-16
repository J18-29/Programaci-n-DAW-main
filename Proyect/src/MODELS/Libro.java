package MODELS;

public class Libro {
    private int id;
    private String titulo;
    private String isbn;
    private int anio;
    private String descripcion;
    private String url;
    private int idAutor;

    // Constructor completo
    public Libro(int id, String titulo, String isbn, int anio, String descripcion, String url, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio = anio;
        this.descripcion = descripcion;
        this.url = url;
        this.idAutor = idAutor;

    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_Autor() {
        return idAutor;
    }
}