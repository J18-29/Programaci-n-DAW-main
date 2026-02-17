package Modelo;



import java.util.Date;

public class Disena {

    private int idProfesor;
    private int idPractica;
    private Date fecha;

    public Disena(int idProfesor, int idPractica, Date fecha) {
        this.idProfesor = idProfesor;
        this.idPractica = idPractica;
        this.fecha = fecha;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(int idPractica) {
        this.idPractica = idPractica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
