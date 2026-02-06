

import java.util.*;

public class SucursalDAO {
     int codigo;
     String direccion;
     String ciudad;
     String provincia;
     String telefono;

    private List<RevistaDAO> revistas = new ArrayList<>();
    private List<EmpleadoDAO> empleados = new ArrayList<>();

    public SucursalDAO(int codigo, String direccion, String ciudad, String provincia, String telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    public void publicarRevista(RevistaDAO r) {
        revistas.add(r);
    }

    public void agregarEmpleado(EmpleadoDAO e) {
        empleados.add(e);
    }

    @Override
    public String toString() {
        return "Sucursal " + codigo + " (" + ciudad + ")";
    }

    

    
}
