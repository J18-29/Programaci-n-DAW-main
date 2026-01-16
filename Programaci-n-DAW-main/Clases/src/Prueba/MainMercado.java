package Prueba;

import Mercado.Cliente;
import Mercado.Compra;
import Mercado.Empleado;
import Mercado.Fabrica;
import Mercado.Producto;
import Mercado.Sucursal1;
import Mercado.Tarjeta;
import Mercado.Trabajo;
import Mercado.Venta;


public class MainMercado {
    public static void main(String[] args) {

        // ----- Cliente y Tarjeta -----
        Tarjeta tarjeta1 = new Tarjeta(1234, "Visa Oro", "VISA", "12/28");
        Cliente cliente1 = new Cliente(1, "Juan Pérez", "Madrid", 44556677, "1990-05-10");
        cliente1.setTarjeta(tarjeta1);

        // ----- Sucursales -----
        Sucursal1 suc1 = new Sucursal1(10, "Av. Libertad 123", "Madrid");
        // ----- Empleado -----
        Empleado emp1 = new Empleado(100, 33445566, "Carla Gómez", "600112233",
                "Gran Vía", 22, "Madrid");

        // ----- Fábrica y Producto -----
        Fabrica fab = new Fabrica("30-55667788-9", "Fabricsa SA", "España", 80, "Roberto Díaz");
        Producto prod1 = new Producto(501, "Televisor", "Negro", 200);
        prod1.setFabrica(fab);

        // ----- Relaciones -----
        Compra compra1 = new Compra(cliente1, suc1, 15.0);
        Venta venta1 = new Venta(suc1, prod1, 350.0);
        Trabajo trabajo1 = new Trabajo(emp1, suc1, "Lunes", "09:00 a 17:00");

        // ----- Mostrar datos -----
        System.out.println("=== CLIENTE ===");
        System.out.println(cliente1);
        System.out.println("Tarjeta: " + cliente1.getTarjeta());

        System.out.println("\n=== COMPRA ===");
        System.out.println(compra1);

        System.out.println("\n=== PRODUCTO Y FABRICA ===");
        System.out.println(prod1);
        System.out.println("Fábrica: " + fab);

        System.out.println("\n=== VENTA ===");
        System.out.println(venta1);

        System.out.println("\n=== EMPLEADO Y TRABAJO ===");
        System.out.println(emp1);
        System.out.println(trabajo1);
    }
}

