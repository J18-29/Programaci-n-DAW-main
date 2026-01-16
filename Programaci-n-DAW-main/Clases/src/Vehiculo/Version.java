package Vehiculo;

public class Version {
     int id;
     String nombre;
     int potencia;
     double precioBase;
     String tipoCombustible;
     Modelo modelo;

    public Version(int id, String nombre, int potencia, double precioBase, String tipoCombustible, Modelo modelo) {
        this.id = id;
        this.nombre = nombre;
        this.potencia = potencia;
        this.precioBase = precioBase;
        this.tipoCombustible = tipoCombustible;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
public String toString() {
    return nombre + " - " + potencia + " CV - " + precioBase + "€ (" + modelo + ")";
}


    
}

