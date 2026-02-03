public class AlumnoDAO {
     int id;
     String nif;
     String nombre;
     String apellido1;
     String apellido2;
     String grupo;

    public AlumnoDAO(int id, String nif, String nombre, String apellido1, String apellido2, String grupo) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }
}
