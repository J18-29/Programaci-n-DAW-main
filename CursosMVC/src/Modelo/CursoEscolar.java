package src.Modelo;

public class CursoEscolar {
     int id;
     int anio_inicio;
     int anio_fin;

    public CursoEscolar(int id, int anio_inicio, int anio_fin) {
        this.id = id;
        this.anio_inicio = anio_inicio;
        this.anio_fin = anio_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnio_inicio() {
        return anio_inicio;
    }

    public void setAnio_inicio(int anio_inicio) {
        this.anio_inicio = anio_inicio;
    }

    public int getAnio_fin() {
        return anio_fin;
    }

    public void setAnio_fin(int anio_fin) {
        this.anio_fin = anio_fin;
    }

    
}
