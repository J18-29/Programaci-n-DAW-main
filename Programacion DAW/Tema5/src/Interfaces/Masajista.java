package Interfaces;


public class Masajista extends SeleccionFutbol {

     String titulacion;
     int aniosExperiencia;

    public Masajista(int id, String nombre, String apellidos, int edad,String titulacion, int aniosExperiencia) {
        super(id, nombre, apellidos, edad);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " no entrena, apoya al equipo.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(nombre + " asiste a los jugadores durante el partido.");
    }

    public void darMasaje() {
        System.out.println(nombre + " da un masaje.");
    }
}
