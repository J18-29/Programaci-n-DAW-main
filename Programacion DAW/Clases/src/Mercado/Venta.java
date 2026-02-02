package Mercado;

public class Venta {

    Sucursal1 sucursal;
    Producto producto;
    double precioVenta;

    public Venta(Sucursal1 sucursal, Producto producto, double precioVenta) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.precioVenta = precioVenta;
    }

    public Sucursal1 getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal1 sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Venta [sucursal=" + sucursal + ", producto=" + producto + ", precioVenta=" + precioVenta + "]";
    }

    
}

