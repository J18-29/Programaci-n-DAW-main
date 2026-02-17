package src.Modelo;

public class Asignatura {
    private int codigo;
    private String nombre;
    private int numero_horas;
    private Profesor profesor;

    public Asignatura(int codigo, String nombre, int numero_horas, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numero_horas = numero_horas;
        this.profesor = profesor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_horas() {
        return numero_horas;
    }

    public void setNumero_horas(int numero_horas) {
        this.numero_horas = numero_horas;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

  
}