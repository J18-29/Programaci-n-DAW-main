import java.util.ArrayList;
import java.util.List;

public class Revista {
     int numRegistro;
    private String titulo;
    
    public List<Seccion> secciones = new ArrayList<>();
    public List<Ejemplar> ejemplares = new ArrayList<>();
    public List<Periodista> periodistas = new ArrayList<>();

    public Revista(int numRegistro, String titulo) {
        this.numRegistro = numRegistro;
        this.titulo = titulo;
    }

    public String getTitulo() { return titulo; }
}