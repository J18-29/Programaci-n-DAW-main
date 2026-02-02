package lujo;

public class Sucursal {
    int id;
    String telefono;
    String direccion;
    String ciudad;
    String provincia;

    public Sucursal(){}

    public Sucursal(int id, String telefono, String direccion, String ciudad, String provincia) {
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Sucursal [id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + ", ciudad=" + ciudad
                + ", provincia=" + provincia + "]";
    }
    
}
