package Mercado;

public class Sucursal1 {

     int numero;
     String domicilio;
     String ciudad;

    public Sucursal1(int numero, String domicilio, String ciudad) {
        this.numero = numero;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Sucursal [numero=" + numero + ", domicilio=" + domicilio + ", ciudad=" + ciudad + "]";
    }

    
}

