public class AsignaturaDAO {
     int codigo;
     String nombre;
     int numeroHoras;
     Profesor2DAO profesor;

    public AsignaturaDAO(int codigo, String nombre, int numeroHoras, Profesor2DAO profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroHoras = numeroHoras;
        this.profesor = profesor;
    }

    

    public String getNombre() {
        return nombre;
    }

    public Profesor2DAO getProfesor() {
        return profesor;
    }
}

