package Interfaces;

import java.util.ArrayList;

public class AccionVehiculos {

    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Coche("Toyota"));
        vehiculos.add(new Avion("Boeing"));
        vehiculos.add(new Helicoptero("Apache"));
        vehiculos.add(new Coche("Seat"));
        vehiculos.add(new Avion("Airbus"));

        for (Vehiculo v : vehiculos) {
            v.arrancar();

            if (v instanceof Volador) {
                ((Volador) v).volar();
            }

            v.frenar();
            System.out.println();
        }
    }
}
