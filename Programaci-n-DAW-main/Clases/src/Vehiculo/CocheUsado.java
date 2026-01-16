package Vehiculo;

public class CocheUsado {
     String matricula;
     String nombre;
     double precioTasacion;

    public CocheUsado(String matricula, String nombre, double precioTasacion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.precioTasacion = precioTasacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioTasacion() {
        return precioTasacion;
    }

    public void setPrecioTasacion(double precioTasacion) {
        this.precioTasacion = precioTasacion;
    }

    @Override
    public String toString() {
        return "CocheUsado [matricula=" + matricula + ", nombre=" + nombre + ", precioTasacion=" + precioTasacion + "]";
    }

   
}
