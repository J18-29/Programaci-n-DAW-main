package src.Modelo;

import java.time.LocalDateTime;

public class Suministra {
    private int codigoProveedor;
    private int codigoPieza;
    private LocalDateTime fechaHora;
    private int cantidad;

    public Suministra(int codigoProveedor, int codigoPieza, LocalDateTime fechaHora, int cantidad) {
        this.codigoProveedor = codigoProveedor;
        this.codigoPieza = codigoPieza;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getCodigoProveedor() {
        return codigoProveedor;
    }
    
    public int getCodigoPieza() {
        return codigoPieza;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }
}

