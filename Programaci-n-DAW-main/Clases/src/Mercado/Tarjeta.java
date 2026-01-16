package Mercado;

public class Tarjeta {

     int numero;
     String nombre;
     String codigo;
     String fechaVenc;

    public Tarjeta(int numero, String nombre, String codigo, String fechaVenc) {
        this.numero = numero;
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaVenc = fechaVenc;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(String fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    @Override
    public String toString() {
        return "Tarjeta [numero=" + numero + ", nombre=" + nombre + ", codigo=" + codigo + ", fechaVenc=" + fechaVenc
                + "]";
    }

    
}
