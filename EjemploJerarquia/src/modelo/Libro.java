package src.Modelo;


import java.sql.Date;

public class Libro {
    protected int id;
    protected String isbn;
    protected Date anyo_publicacion;
    protected String titulo;
    protected String descripcion;
    protected int tipo;
    public Libro(int id, String isbn, Date anyo_publicacion, String titulo, String descripcion,int tipo) {
        this.id = id;
        this.isbn = isbn;
        this.anyo_publicacion = anyo_publicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo=tipo;
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
    public Date getAnyo_publicacion() {
        return anyo_publicacion;
    }
    public void setAnyo_publicacion(Date anyo_publicacion) {
        this.anyo_publicacion = anyo_publicacion;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setTipo(int tipo){
        this.tipo=tipo;
    }
    
    
}