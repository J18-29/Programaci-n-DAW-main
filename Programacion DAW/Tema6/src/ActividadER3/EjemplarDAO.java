public class EjemplarDAO {

     String fecha;
     int numeroPaginas;
     int numeroEjemplares;

   
    public EjemplarDAO(String fecha, int numeroPaginas, int numeroEjemplares) {
        this.fecha = fecha;
        this.numeroPaginas = numeroPaginas;
        this.numeroEjemplares = numeroEjemplares;
    }


    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public int getNumeroPaginas() {
        return numeroPaginas;
    }


    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }


    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }


    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    
}
