package src.Modelo;

public class Pieza {
    private int codigo;
    private String nombre;
    private String color;
    private double precio;
    private int codigoCategoria;

    public Pieza(int codigo, String nombre, String color, double precio, int codigoCategoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.codigoCategoria = codigoCategoria;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
}
