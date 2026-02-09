

public class SeccionDAO2 {
    private String titulo;
    private int extension;

    public SeccionDAO2(String titulo, int extension) {
        this.titulo = titulo;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return titulo + " (" + extension + " páginas)";
    }
}
