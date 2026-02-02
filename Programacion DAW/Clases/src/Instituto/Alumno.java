package Instituto;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    String expediente ,fecha_nac,nombre,apellido;
    Modulo modulo;
    List<Modulo> modulos = new ArrayList<>();
    Profesor profesorDelegado;  // el profesor del que es delegado
    public Alumno(){}

    public Alumno(String expediente, String fecha_nac, String nombre, String apellido) {
        this.expediente = expediente;
        this.fecha_nac = fecha_nac;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
     public Modulo getModulo() {
         return modulo;
     }
     public void setModulo(Modulo modulo) {
         this.modulo = modulo;
     }
       // Cursa un módulo
    public void cursarModulo(Modulo modulo) {
        modulos.add(modulo);
        modulo.addAlumno(this); // relación bidireccional
    }

    public void setProfesorDelegado(Profesor p) {
        this.profesorDelegado = p;
    }
    @Override
    public String toString() {
        return "Alumno [expediente=" + expediente + ", fecha_nac=" + fecha_nac + ", nombre=" + nombre + ", apellido="
                + apellido + "]";
    }
    
}
