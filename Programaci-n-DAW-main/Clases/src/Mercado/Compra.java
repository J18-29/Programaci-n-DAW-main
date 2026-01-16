package Mercado;

public class Compra {

     Cliente cliente;
     Sucursal1 sucursal;
     double descuento;

    public Compra(Cliente cliente, Sucursal1 sucursal, double descuento) {
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sucursal1 getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal1 sucursal) {
        this.sucursal = sucursal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Compra [cliente=" + cliente + ", sucursal=" + sucursal + ", descuento=" + descuento + "]";
    }
   
    
}

