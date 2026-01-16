package Prueba;
import Instituto.*;
public class Actividad7Clase {
    public static void main(String[] args) {

        Profesor profesor1 = new Profesor("54891208C","Laura","C Rosal 12","619391240");
        Profesor profesor2 = new Profesor("54872813B","Morgado","C Veleta 23","291839183");

        Modulo modulo1= new Modulo(234,"Bases de Datos");
        Modulo modulo2= new Modulo(193,"Lenguaje de Marcas");

        Alumno alumno1= new Alumno("A01","12/02/2004","Luis","Galdo");
        Alumno alumno2= new Alumno("A02","21/05/2010","Betty","Perez");
        Alumno alumno3= new Alumno("A03","26/11/2007","Pedro","Bottycan");

        // Profesor imparte módulos
        profesor1.impartirModulo(modulo1);
        profesor2.impartirModulo(modulo2);

        // Alumnos cursan módulos
        alumno1.cursarModulo(modulo1);
        alumno2.cursarModulo(modulo2);
        alumno3.cursarModulo(modulo1);

        // Delegados
        profesor1.addDelegado(alumno1);  // Luis es delegado de Laura
        profesor2.addDelegado(alumno2);  // Betty es delegada de Morgado
    }
}
