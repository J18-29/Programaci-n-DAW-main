package src.Modelo;


import java.sql.Date;

public class Ebook extends Libro {
    private double precio;
    private String tamanyo;
    public Ebook(int id, String isbn, Date anyo_publicacion, String titulo, String descripcion,int tipo,
        String tamanyo,double precio) {
        super(id, isbn, anyo_publicacion, titulo, descripcion,tipo);
        this.precio = precio;
        this.tamanyo = tamanyo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTamanyo() {
        return tamanyo;
    }
    public void setTamanyo(String tamanyo) {
        this.tamanyo = tamanyo;
    }

    

    
    
}