package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private String telefono;
    private List<Vehiculo> vehiculos;

    public Cliente(String DNI, String nombre, String pape, String telefono) {
        super(DNI, nombre, pape);
        this.telefono = telefono;
        this.vehiculos = new ArrayList<>();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void addVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    public void removeVehiculo(Vehiculo v) {
        vehiculos.remove(v);
    }
}
