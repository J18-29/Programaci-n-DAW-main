public class RevistaDAO {

    private int numeroRegistro;
    private String titulo;

    
    public RevistaDAO(int numeroRegistro, String titulo) {
        this.numeroRegistro = numeroRegistro;
        this.titulo = titulo;
    }

    
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "RevistaDAO [numeroRegistro=" + numeroRegistro + ", titulo=" + titulo + "]";
    }


    
    
}

