package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Taller {

    private String nombre;
    private String direccion;
    private Propietario propietario;
    private List<Cliente> clientes;

    public Taller(String nombre, String direccion, Propietario propietario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.propietario = propietario;
        this.clientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void removeCliente(Cliente c) {
        clientes.remove(c);
    }
}
