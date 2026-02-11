package src.Vista;

import src.Modelo.Profesor;

public class AsignaturaView {
    private int codigo;
    private String nombre;
    private int numeroHoras;
    private String nombreProfesor;

    public AsignaturaView(int codigo, String nombre, int numeroHoras, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroHoras = numeroHoras;
        this.nombreProfesor = profesor.getNombre() + " " + profesor.getApellido1() + " " + profesor.getApellido2();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }
}
