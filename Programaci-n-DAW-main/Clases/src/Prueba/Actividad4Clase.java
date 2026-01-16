package Prueba;

import Clases.Ciudad;
import Clases.Fecha;
import Clases.Persona2;

public class Actividad4Clase {
    public static void main(String[] args) {
        //Crear una fecha
        Fecha fecha = new Fecha(12, 5, 1995);
        Ciudad ciudadNac = new Ciudad(233, "Bogotá", 601);
        Ciudad ciudadRes = new Ciudad(456, "Medellín", 604);

        Persona2 persona = new Persona2("12345678", "Juan", "Pérez", 'M', fecha, ciudadNac, ciudadRes);
        persona.mostrarInformacion();
    }
}
