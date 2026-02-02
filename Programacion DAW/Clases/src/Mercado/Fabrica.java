package Mercado;

public class Fabrica {

    String cuit;
    String nombre;
    String pais;
    int cantEmp;
    String gerente;

    public Fabrica(String cuit, String nombre, String pais, int cantEmp, String gerente) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.pais = pais;
        this.cantEmp = cantEmp;
        this.gerente = gerente;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantEmp() {
        return cantEmp;
    }

    public void setCantEmp(int cantEmp) {
        this.cantEmp = cantEmp;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Fabrica [cuit=" + cuit + ", nombre=" + nombre + ", pais=" + pais + ", cantEmp=" + cantEmp + ", gerente="
                + gerente + "]";
    }
    
    
}
