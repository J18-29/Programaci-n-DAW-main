package Trenes;

public class Vagón {
     int numero;
     double cargaMaxima;
     double cargaActual;
     String tipoMercancia;

    public Vagón(int numero, double cargaMaxima, double cargaActual, String tipoMercancia) {
        this.numero = numero;
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(double cargaActual) {
        this.cargaActual = cargaActual;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    @Override
    public String toString() {
        return "Vagón [numero=" + numero + ", cargaMaxima=" + cargaMaxima + ", cargaActual=" + cargaActual
                + ", tipoMercancia=" + tipoMercancia + "]";
    }

    
}

