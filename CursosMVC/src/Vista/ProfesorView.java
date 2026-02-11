package src.Vista;



import src.Modelo.Profesor;

public class ProfesorView {
    private String nombreCompleto;
    private String especialidad;
    private String telefono;

    public ProfesorView(Profesor profesor) {
        this.nombreCompleto = profesor.getNombre() + " " + profesor.getApellido1() + " " + profesor.getApellido2();
        this.especialidad = profesor.getEspecialidad();
        this.telefono = profesor.getTelefono();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTelefono() {
        return telefono;
    }
}
