package Clases;

import java.time.LocalDateTime;

public class ProveedorSuministraPieza {
    private Proveedor proveedor;
    private Pieza pieza;
    private LocalDateTime fechaHora;
    private int cantidad;

    //Constructores
    public ProveedorSuministraPieza(Proveedor proveedor, Pieza pieza,LocalDateTime fechaHora, int cantidad) {
        this.proveedor = proveedor;
        this.pieza = pieza;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
    }

    //Get y Set
    public Proveedor getProveedor() { 
        return proveedor;
     }
    public void setProveedor(Proveedor proveedor) { 
        this.proveedor = proveedor;
     }

    public Pieza getPieza() { 
        return pieza; 
    }
    public void setPieza(Pieza pieza) { 
        this.pieza = pieza; 
    }

    public LocalDateTime getFechaHora() { 
        return fechaHora; 
    }
    public void setFechaHora(LocalDateTime fechaHora) { 
        this.fechaHora = fechaHora;
     }

    public int getCantidad() { 
        return cantidad;
     }
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad;
     }

     //Imprimir resultado
    @Override
    public String toString() {
        return "ProveedorSuministraPieza [proveedor=" + proveedor.getCodigo() +
               ", pieza=" + pieza.getCodigo() + ", fechaHora=" + fechaHora +
               ", cantidad=" + cantidad + "]";
    }
}

