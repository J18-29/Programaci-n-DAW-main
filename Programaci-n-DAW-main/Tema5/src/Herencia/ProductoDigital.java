package Herencia;

public class ProductoDigital extends Producto {
    private String urlDescarga;
    private double tamañoMB;

    public ProductoDigital(int id, String nombre, double precio,
                            String urlDescarga, double tamañoMB) {
        super(id, nombre, precio);
        this.urlDescarga = urlDescarga;
        this.tamañoMB = tamañoMB;
    }

    @Override
    public double precioFinal() {
        return precio; // No hay costes adicionales
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\n--- Producto Digital ---");
        super.mostrarInfo();
        System.out.println("URL de descarga: " + urlDescarga);
        System.out.println("Tamaño: " + tamañoMB + " MB");
        System.out.println("Precio final: $" + precioFinal());
    }
}
