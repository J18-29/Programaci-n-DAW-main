import java.time.LocalDate;

public class Alumno2DAO {
     int numeroMatricula;
     String nombre;
     String apellido1;
     String apellido2;
     LocalDate fechaNacimiento;
     String telefono;

    public Alumno2DAO(int numeroMatricula, String nombre, String apellido1,String apellido2, LocalDate fechaNacimiento, String telefono) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }
}
