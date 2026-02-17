package Modelo;



import java.util.Date;

public class Realiza {

    private int idAlumno;
    private int idPractica;
    private Date fecha;
    private double nota;

    public Realiza(int idAlumno, int idPractica, Date fecha, double nota) {
        this.idAlumno = idAlumno;
        this.idPractica = idPractica;
        this.fecha = fecha;
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
}
