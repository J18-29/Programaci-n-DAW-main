package src.Modelo;

public class Ebook {
    private int id;
    private String tamaño; 
    private double precio;

    public Ebook() {}

    public Ebook(int id, String tamaño, double precio) {
        this.id = id;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
}
