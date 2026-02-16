package src.Modelo;



import java.sql.Date;

public class Papel extends Libro{
    private Date fecha_impresion;
    private String lugar_impresion;
    private double precio;
    public Papel(int id, String isbn, Date anyo_publicacion, String titulo, String descripcion,int tipo, Date fecha_impresion,
            String lugar_impresion, double precio) {
        super(id, isbn, anyo_publicacion, titulo, descripcion,tipo);
        this.fecha_impresion = fecha_impresion;
        this.lugar_impresion = lugar_impresion;
        this.precio = precio;
    }
    public Date getFecha_impresion() {
        return fecha_impresion;
    }
    public void setFecha_impresion(Date fecha_impresion) {
        this.fecha_impresion = fecha_impresion;
    }
    public String getLugar_impresion() {
        return lugar_impresion;
    }
    public void setLugar_impresion(String lugar_impresion) {
        this.lugar_impresion = lugar_impresion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}