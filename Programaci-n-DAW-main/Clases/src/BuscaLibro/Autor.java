package BuscaLibro;
import java.util.ArrayList;

public class Autor {
    private String nombre;
    private ArrayList<String> premios;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.premios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPremio(String premio) {
        premios.add(premio);
    }

    @Override
    public String toString() {
        return nombre + " (Premios: " + premios + ")";
    }
}
