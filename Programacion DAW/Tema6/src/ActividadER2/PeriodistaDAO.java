

public class PeriodistaDAO {
     int id;
     String nombre;
     String apellido1;
     String apellido2;
     String telefono;
     String especialidad;

    public PeriodistaDAO(int id, String nombre, String apellido1,
                      String apellido2, String telefono, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1 + " (" + especialidad + ")";
    }
}

