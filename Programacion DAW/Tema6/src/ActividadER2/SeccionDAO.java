

public class SeccionDAO {
    private String titulo;
    private int extension;

    public SeccionDAO(String titulo, int extension) {
        this.titulo = titulo;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return titulo + " (" + extension + " páginas)";
    }
}
