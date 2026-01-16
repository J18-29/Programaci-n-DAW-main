package Trenes;

public class Locomotora {
     String matricula;
     double potencia;
     int anoFabricacion;
     Mecánico mecanico;

    public Locomotora(String matricula, double potencia, int anoFabricacion, Mecánico mecanico) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.anoFabricacion = anoFabricacion;
        this.mecanico = mecanico;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public Mecánico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecánico mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "Locomotora [matricula=" + matricula + ", potencia=" + potencia + ", anoFabricacion=" + anoFabricacion
                + ", mecanico=" + mecanico + "]";
    }

    
}
