package Clases;
import java.util.ArrayList;

public class Surcursal {
    private int codigo;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String telefono;

    // Relaciones
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public Surcursal(int codigo, String direccion, String ciudad, String provincia, String telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    // Getters & Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public ArrayList<Empleado> getEmpleados() { return empleados; }

    public void addEmpleado(Empleado e) {
        if (!empleados.contains(e)) empleados.add(e);
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "codigo=" + codigo +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
