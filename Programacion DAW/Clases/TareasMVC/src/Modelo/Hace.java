package Modelo;



public class Hace {

    private int idAlumno;
    private int idExamen;
    private double nota;

    public Hace(int idAlumno, int idExamen, double nota) {
        this.idAlumno = idAlumno;
        this.idExamen = idExamen;
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
}
