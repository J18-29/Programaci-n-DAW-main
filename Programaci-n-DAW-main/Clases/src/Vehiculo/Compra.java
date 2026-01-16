package Vehiculo;

public class Compra {
     int id;
     String fecha;
     Cliente cliente;
     Vendedor vendedor;
     CocheNuevo coche;

    public Compra(int id, String fecha, Cliente cliente, Vendedor vendedor, CocheNuevo coche) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.coche = coche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public CocheNuevo getCoche() {
        return coche;
    }

    public void setCoche(CocheNuevo coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Compra [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", vendedor=" + vendedor + ", coche="
                + coche + "]";
    }

   
}
