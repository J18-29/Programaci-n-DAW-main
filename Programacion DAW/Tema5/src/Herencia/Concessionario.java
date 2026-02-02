package Herencia;

import java.util.ArrayList;

public class Concessionario {
    public static void main(String[] args) {

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Coche("ABC-123"));
        listaVehiculos.add(new Moto("XYZ-789"));
        listaVehiculos.add(new Camion("TRK-456"));

        for (Vehiculo v : listaVehiculos) {
            v.mostrarInfo();
            System.out.println("----------------------");
        }
    }
}
