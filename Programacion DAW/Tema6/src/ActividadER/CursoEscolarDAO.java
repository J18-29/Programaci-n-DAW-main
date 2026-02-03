public class CursoEscolarDAO {
     int id;
     int anioInicio;
     int anioFin;

    public CursoEscolarDAO(int id, int anioInicio, int anioFin) {
        this.id = id;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }

    public String getDescripcion() {
        return anioInicio + "/" + anioFin;
    }
}
