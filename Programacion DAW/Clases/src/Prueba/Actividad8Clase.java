package Prueba;

import lujo.Hotel;
import lujo.Reserva;
import lujo.Sucursal;
import lujo.Toma;
import lujo.Turista;
import lujo.Vuelo;

public class Actividad8Clase {
    public static void main(String[] args) {

        // ==== Crear turistas ====
        Turista t1 = new Turista(1, "Ana", "García", "C/ Mayor 12", "600123123");
        Turista t2 = new Turista(2, "Luis", "Pérez", "Av. Sol 45", "699998888");

        // ==== Crear hoteles ====
        Hotel h1 = new Hotel(1, "Hotel Central", "912334455", 80, "Madrid", "C/ Luna 21");
        Hotel h2 = new Hotel(2, "Hotel Playa", "933221100", 120, "Barcelona", "Paseo Marítimo 7");

        // ==== Crear sucursales ====
        Sucursal s1 = new Sucursal(10, "915556677", "C/ Alcalá 4", "Madrid", "Madrid");
        Sucursal s2 = new Sucursal(11, "933110220", "C/ Verdi 18", "Barcelona", "Cataluña");

        // ==== Crear vuelos ====
        Vuelo v1 = new Vuelo(100, "2025-07-12", "14:30", "China","Madrid", 180);

        Vuelo v2 = new Vuelo(101, "2025-08-03", "9:15", "Rusia","Barcelona", 120);

        // ==== Crear reservas (Hotel) ====
        Reserva r1 = new Reserva(t1, h1, s1, "2025-07-15", "2025-07-20", "Media pensión");
        Reserva r2 = new Reserva(t2, h2, s2, "2025-08-05", "2025-08-10", "Desayuno");

        // ==== Crear Toma (Vuelo) ====
        Toma toma1 = new Toma(t1, v1, s1);
        Toma toma2 = new Toma(t2, v2, s2);

        // ==== Mostrar información ====
        System.out.println("=== TURISTAS ===");
        System.out.println(t1);
        System.out.println(t2);

        System.out.println("\n=== HOTELES ===");
        System.out.println(h1);
        System.out.println(h2);

        System.out.println("\n=== SUCURSALES ===");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("\n=== VUELOS ===");
        System.out.println(v1);
        System.out.println(v2);

        System.out.println("\n=== RESERVAS DE HOTEL ===");
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("\n=== TOMA DE VUELOS ===");
        System.out.println(toma1);
        System.out.println(toma2);
    }
}

