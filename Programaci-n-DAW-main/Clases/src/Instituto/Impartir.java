package Instituto;

public class Impartir {
    Profesor profesor=null;
    Modulo modulo=null;

    public Impartir(){}

    public Impartir(Profesor profesor, Modulo modulo) {
        this.profesor = profesor;
        this.modulo = modulo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
          if(profesor!=null && modulo!=null)
           return "Impartir [profesor=" + profesor + ", modulo=" + modulo + "]";
           else return "No hay datos de esto";
        }    
    
}
