package Mercado;

public class Producto {

    int codigo;
    String descripcion;
    String color;
    double costo;

     Fabrica fabrica; // 1:1

    public Producto(int codigo, String descripcion, String color, double costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.color = color;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", color=" + color + ", costo=" + costo
                + ", fabrica=" + fabrica + "]";
    }

    

   
}
