package Mercado;

public class Trabajo {

     Empleado empleado;
     Sucursal1 sucursal;
     String dia;
     String horario;

    public Trabajo(Empleado empleado, Sucursal1 sucursal, String dia, String horario) {
        this.empleado = empleado;
        this.sucursal = sucursal;
        this.dia = dia;
        this.horario = horario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Sucursal1 getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal1 sucursal) {
        this.sucursal = sucursal;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Trabajo [empleado=" + empleado + ", sucursal=" + sucursal + ", dia=" + dia + ", horario=" + horario
                + "]";
    }

   
}

