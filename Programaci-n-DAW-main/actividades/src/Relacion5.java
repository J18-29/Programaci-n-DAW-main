
import java.util.Scanner;

public class Relacion5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arreglo con las materias de cada día de la semana (de lunes a viernes)
        String[] dias = {
            "Lunes: IPE,Sist.Informaticos,Bases de Datos,Programacion",
            "Martes: LMSGI,Sist.Informaticos,Programacion,Ent.Desarrollo",
            "Miércoles: Bases de Datos,Sist.Informaticos,Programacion",
            "Jueves: Programacion,Ent.Desarrollo,IPE,Bases de datos,Sostenibilidad",
            "Viernes: Bases de Datos,Digitalizacion,LMSGI,IPE,Programación"
        };

        while (true) {
            // Mostrar opciones al usuario
            System.out.println("Ingrese un número del 1 al 5 para ver las materias de ese día.");
            System.out.println("Ingrese 6 para ver todo el horario completo.");
            System.out.println("Ingrese 7 para salir del programa.");
            System.out.print("Número: ");
            
            int opcion = scanner.nextInt();  // Leer número ingresado

            if (opcion >= 1 && opcion <= 5) {
                // Mostrar materias del día seleccionado
                System.out.println(dias[opcion - 1]);
            } else if (opcion == 6) {
                // Mostrar todo el horario completo
                System.out.println("Horario completo:");
                for (String dia : dias) {
                    System.out.println(dia);
                }
            } else if (opcion == 7) {
                // Salir del programa
                System.out.println("Programa terminado.");
                break;  // Romper el ciclo para salir
            } else {
                // Opción inválida
                System.out.println("Opción inválida. Por favor intenta de nuevo.");
            }

            System.out.println();  // Línea en blanco para mejor lectura
        }

        scanner.close();  // Cerrar el scanner
    }
}


    
