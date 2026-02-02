
import java.util.Scanner;

public class Relacion3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Pedimos el día y el mes al usuario
        System.out.print("Introduce el día de nacimiento: ");
        int dia = entrada.nextInt();

        System.out.print("Introduce el mes de nacimiento : ");
        int mes = entrada.nextInt();

        String signo = "";

        // Validamos primero que el mes esté entre 1 y 12
        if (mes < 1 || mes > 12) {
            System.out.println("Mes no válido.");
        }
        // Validamos que el día esté en un rango posible según el mes
        else if (dia < 1 || dia > 31 || (mes == 2 && dia > 29) ||
                 ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)) {
            System.out.println("Día no válido para el mes indicado.");
        }
        // Si todo está bien, determinamos el signo
        else {
            if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
                signo = "ACUARIO";
            } else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) {
                signo = "PISCIS";
            } else if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
                signo = "ARIES";
            } else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
                signo = "TAURO";
            } else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
                signo = "GÉMINIS";
            } else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
                signo = "CÁNCER";
            } else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
                signo = "LEO";
            } else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
                signo = "VIRGO";
            } else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
                signo = "LIBRA";
            } else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
                signo = "ESCORPIO";
            } else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
                signo = "SAGITARIO";
            } else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
                signo = "CAPRICORNIO";
            }

            // Mostramos el signo si se ha asignado
            System.out.println("Tu signo del zodiaco es: " + signo);
        }

        entrada.close();
    }
}



