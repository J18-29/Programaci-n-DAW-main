

import java.util.*;

public class ClienteDAO {
    
     int id;
     String nombre;
     String apellido1;
     String apellido2;
     String direccion;
     String email;
     String telefono;

     LocalidadDAO localidad;
    private List<CestaDAO> cestas = new ArrayList<>();

    public ClienteDAO(int id, String nombre, String apellido1, String apellido2,String direccion, String email, String telefono, LocalidadDAO localidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    public void agregarCesta(CestaDAO c) {
        cestas.add(c);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1;
    }
}
