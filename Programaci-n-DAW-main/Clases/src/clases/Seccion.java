package Clases;
public class Seccion {
    private String titulo;
    private int extension;

    public Seccion(String titulo, int extension) {
        this.titulo = titulo;
        this.extension = extension;
    }

    // Getters & Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getExtension() { return extension; }
    public void setExtension(int extension) { this.extension = extension; }

    @Override
    public String toString() {
        return "Seccion{" +
                "titulo='" + titulo + '\'' +
                ", extension=" + extension +
                '}';
    }
}
