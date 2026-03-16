package MODELS;

public class Prestado {
    private int idLibro;
    private int codigoUsuario;
    public Prestado(int idLibro, int codigoUsuario) {
        this.idLibro = idLibro;
        this.codigoUsuario = codigoUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public int getCodigoUsuario() {
        return codigoUsuario;
    }
    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}
