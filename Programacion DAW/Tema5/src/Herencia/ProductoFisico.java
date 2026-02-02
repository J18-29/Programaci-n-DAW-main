package Herencia;

public class ProductoFisico extends Producto {
    private double peso; // en Kg
    private double costeEnvio;

    public ProductoFisico(int id, String nombre, double precio,
                           double peso, double costeEnvio) {
        super(id, nombre, precio);
        this.peso = peso;
        this.costeEnvio = costeEnvio;
    }

    @Override
    public double precioFinal() {
        double precioFinal = precio + costeEnvio;

        if (peso > 2) {
            precioFinal += precio * 0.10; // 10% adicional
        }

        return precioFinal;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\n--- Producto Físico ---");
        super.mostrarInfo();
        System.out.println("Peso: " + peso + " Kg");
        System.out.println("Coste de envío: $" + costeEnvio);
        System.out.println("Precio final: $" + precioFinal());
    }
}
