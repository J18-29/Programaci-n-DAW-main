package lujo;

public class Hotel {
    int id;
    String nombre;
    String telefono;
    int plazas;
    String ciudad;
    String direccion;

    public Hotel(){}

    public Hotel(int id, String nombre, String telefono, int plazas, String ciudad, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.plazas = plazas;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", plazas=" + plazas + ", ciudad="
                + ciudad + ", direccion=" + direccion + "]";
    }

    
    
}
