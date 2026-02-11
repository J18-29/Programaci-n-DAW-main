package src.Modelo;

import java.time.LocalDate; 

public class Papel {
    private int id;
    private LocalDate fechaImpresion;
    private double precio;
    private String lugarImpresion;

    public Papel() {}

    public Papel(int id, LocalDate fechaImpresion, double precio, String lugarImpresion) {
        this.id = id;
        this.fechaImpresion = fechaImpresion;
        this.precio = precio;
        this.lugarImpresion = lugarImpresion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(LocalDate fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getLugarImpresion() {
        return lugarImpresion;
    }

    public void setLugarImpresion(String lugarImpresion) {
        this.lugarImpresion = lugarImpresion;
    }

   
}
