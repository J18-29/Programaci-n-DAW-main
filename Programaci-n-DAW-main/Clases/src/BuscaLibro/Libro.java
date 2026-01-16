package BuscaLibro;

public class Libro {
    private String nombre;
    private Autor autor;
    private String categoria;
    private int total; // Ejemplares disponibles

    public Libro(String nombre, Autor autor, String categoria, int total) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTotal() {
        return total;
    }

    public boolean prestar() {
        if (total > 0) {
            total--;
            return true;
        }
        return false; // no hay ejemplares
    }

    public void devolver() {
        total++;
    }

    @Override
    public String toString() {
        return "\"" + nombre + "\" de " + autor.getNombre() +
               " - Categoría: " + categoria +
               " - Disponibles: " + total;
    }
}
