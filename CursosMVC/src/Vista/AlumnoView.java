package src.Vista;



import java.util.List;
import src.Modelo.Matricula;

public class AlumnoView {
    private int id;
    private String nif;
    private String nombreCompleto;
    private List<Matricula> matriculas;

    public AlumnoView(int id, String nif, String nombre, String apellido1, String apellido2, List<Matricula> matriculas) {
        this.id = id;
        this.nif = nif;
        this.nombreCompleto = nombre + " " + apellido1 + " " + apellido2;
        this.matriculas = matriculas;
    }

    public int getId() {
        return id;
    }

    public String getNif() {
        return nif;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
}

