

import java.util.*;

public class SucursalDAO2 {
     int codigo;
     String direccion;
     String ciudad;
     String provincia;
     String telefono;

    private List<RevistaDAO2> revistas = new ArrayList<>();
    private List<EmpleadoDAO2> empleados = new ArrayList<>();

    public SucursalDAO2(int codigo, String direccion, String ciudad, String provincia, String telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    public void publicarRevista(RevistaDAO2 r) {
        revistas.add(r);
    }

    public void agregarEmpleado(EmpleadoDAO2 e) {
        empleados.add(e);
    }

    @Override
    public String toString() {
        return "Sucursal " + codigo + " (" + ciudad + ")";
    }

    

    
}
