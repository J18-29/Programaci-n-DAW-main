public class PracticaDAO {
     int id;
     String titulo;
     String dificultad;

    public PracticaDAO(int id, String titulo, String dificultad) {
        this.id = id;
        this.titulo = titulo;
        this.dificultad = dificultad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
