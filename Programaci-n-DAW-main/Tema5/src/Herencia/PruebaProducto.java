package Herencia;

public class PruebaProducto {
    public static void main(String[] args) {

        ProductoFisico productoFisico = new ProductoFisico(
                1, "Laptop", 1000, 3.5, 50
        );

        ProductoDigital productoDigital = new ProductoDigital(
                2, "Curso Java", 200,
                "https://descargas.com/java", 1500
        );

        productoFisico.mostrarInfo();
        productoDigital.mostrarInfo();
    }
}
