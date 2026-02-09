public class Seccion {
    private String titulo;
    private int extension;

    public Seccion(String titulo, int extension) {
        this.titulo = titulo;
        this.extension = extension;
    }

    public String getInfo() {
        return "Sección: " + titulo + " (Extensión: " + extension + " págs)";
    }
}