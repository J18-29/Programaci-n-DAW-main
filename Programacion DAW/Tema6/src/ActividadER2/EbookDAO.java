public class EbookDAO extends LibroConcretoDAO {
    double tamanoMB;

    public EbookDAO(int id, String titulo, String isbn, int anio, double tamanoMB, double precio) {
        super(id, titulo, isbn, anio, precio); 
        this.tamanoMB = tamanoMB;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tamaño: " + tamanoMB + "MB";
    }
}

