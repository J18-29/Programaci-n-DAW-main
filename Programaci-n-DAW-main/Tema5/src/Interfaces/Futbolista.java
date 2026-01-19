package Interfaces;


public class Futbolista extends SeleccionFutbol {

     int dorsal;
     String demarcacion;

    public Futbolista(int id, String nombre, String apellidos, int edad,int dorsal, String demarcacion) {
        super(id, nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " entrena como futbolista.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(nombre + " juega el partido.");
    }

    public void entrevista() {
        System.out.println(nombre + " da una entrevista.");
    }
}
