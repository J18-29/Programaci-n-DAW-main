import java.util.ArrayList;
import java.util.List;

public class Sucursal {
     int codigo;
     String direccion, ciudad, provincia, telefono;
    
    
    public List<Empleado> listaEmpleados = new ArrayList<>();
    public List<Revista> revistasPublicadas = new ArrayList<>();

    public Sucursal(int codigo, String ciudad, String direccion) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public int getCodigo() { return codigo; }
}