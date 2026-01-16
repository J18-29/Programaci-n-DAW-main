package Prueba;

import Vehiculo.Cliente;
import Vehiculo.CocheNuevo;
import Vehiculo.CocheUsado;
import Vehiculo.Compra;
import Vehiculo.Entrega;
import Vehiculo.Extra;
import Vehiculo.Marca;
import Vehiculo.Modelo;
import Vehiculo.Vendedor;
import Vehiculo.Version;


public class MainVehiculo {
    public static void main(String[] args) {

        Marca toyota = new Marca(1, "Toyota");
        Modelo corolla = new Modelo(1, "Corolla", toyota);
        Version hybrid= new Version(1, "Hybrid", 122, 21000, "Híbrido", corolla);

        Extra gps = new Extra(1, "GPS", "Navegación completa", 500);
        Extra techoSolar = new Extra(2, "Techo solar", "Panorámico", 1200);

        CocheNuevo cocheNuevo = new CocheNuevo(1, "1234ABC", hybrid);
        cocheNuevo.addExtra(gps);
        cocheNuevo.addExtra(techoSolar);

        Cliente cliente = new Cliente(1, "Juan", "Pérez", "Gómez", "Calle Falsa 123", "600123456");
        Vendedor vendedor = new Vendedor(1, "Carlos", "López", "Martín", "Av. Centro 8", "611998877");

        Compra compra = new Compra(1, "2025-01-10", cliente, vendedor, cocheNuevo);

        CocheUsado cocheUsado = new CocheUsado("5555XYZ", "Ford Focus", 3500);
        Entrega entrega = new Entrega(cocheUsado, cliente, "2025-01-09");

        // Mostrar datos creados
        System.out.println("--- COMPRA ---");
        System.out.println(compra);

        System.out.println("\n--- ENTREGA DE USADO ---");
        System.out.println(entrega);

        System.out.println("\n--- COCHE NUEVO DETALLADO ---");
        System.out.println(cocheNuevo);
    }
}

