

public class EmpleadoDAO {
     int id;
     String nif;
     String nombre;
     String apellido1;
     String apellido2;
     String telefono;

     SucursalDAO sucursal;

    public EmpleadoDAO(int id, String nif, String nombre, String apellido1,String apellido2, String telefono, SucursalDAO sucursal) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.sucursal = sucursal;
        sucursal.agregarEmpleado(this);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1;
    }
}


