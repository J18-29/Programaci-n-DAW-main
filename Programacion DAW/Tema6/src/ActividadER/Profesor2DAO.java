public class Profesor2DAO {
     int id;
     String nombre;
     String apellido1;
     String apellido2;
     String especialidad;
     String telefono;

    public Profesor2DAO(int id, String nombre, String apellido1, String apellido2,String especialidad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }
}
