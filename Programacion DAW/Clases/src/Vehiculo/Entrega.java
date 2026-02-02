package Vehiculo;

public class Entrega {
     CocheUsado cocheUsado;
     Cliente cliente;
     String fecha;

    public Entrega(CocheUsado cocheUsado, Cliente cliente, String fecha) {
        this.cocheUsado = cocheUsado;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public CocheUsado getCocheUsado() {
        return cocheUsado;
    }

    public void setCocheUsado(CocheUsado cocheUsado) {
        this.cocheUsado = cocheUsado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Entrega [cocheUsado=" + cocheUsado + ", cliente=" + cliente + ", fecha=" + fecha + "]";
    }

    
}

