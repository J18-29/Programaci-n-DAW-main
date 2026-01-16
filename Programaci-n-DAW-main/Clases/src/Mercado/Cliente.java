package Mercado;

public class Cliente {

     int codigo;
     String nombre;
     String ciudad;
     int dni;
     String fechaNac;

     Tarjeta tarjeta; // relación 1:1

    public Cliente(int codigo, String nombre, String ciudad, int dni, String fechaNac) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.dni = dni;
        this.fechaNac = fechaNac;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", dni=" + dni
                + ", fechaNac=" + fechaNac + ", tarjeta=" + tarjeta + "]";
    }
  
    
}
