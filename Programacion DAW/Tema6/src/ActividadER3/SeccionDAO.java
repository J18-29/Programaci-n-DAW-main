
public class SeccionDAO {
     String titulo;
     String extension;

   
    public SeccionDAO(String titulo, String extension) {
        this.titulo = titulo;
        this.extension = extension;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getExtension() {
        return extension;
    }


    public void setExtension(String extension) {
        this.extension = extension;
    }

    
}
