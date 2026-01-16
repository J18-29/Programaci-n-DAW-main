package Mercado;

public class Empleado {

    int legajo;
    int dni;
    String nombre;
    String telefono;
    String domicilioCalle;
    int domicilioNumero;
    String ciudad;

    public Empleado(int legajo, int dni, String nombre, String telefono, 
                    String domicilioCalle, int domicilioNumero, String ciudad) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilioCalle = domicilioCalle;
        this.domicilioNumero = domicilioNumero;
        this.ciudad = ciudad;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilioCalle() {
        return domicilioCalle;
    }

    public void setDomicilioCalle(String domicilioCalle) {
        this.domicilioCalle = domicilioCalle;
    }

    public int getDomicilioNumero() {
        return domicilioNumero;
    }

    public void setDomicilioNumero(int domicilioNumero) {
        this.domicilioNumero = domicilioNumero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Empleado [legajo=" + legajo + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono
                + ", domicilioCalle=" + domicilioCalle + ", domicilioNumero=" + domicilioNumero + ", ciudad=" + ciudad
                + "]";
    }
   
   
}

