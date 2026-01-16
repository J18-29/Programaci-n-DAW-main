
import java.util.Scanner;

public class Relacion6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables necesarias
        int cargo;
        int diasViaje;
        int estadoCivil;
        double sueldoBase = 0;
        double dietas;
        double sueldoBruto;
        double retencionIRPF;
        double sueldoNeto;
        double porcentajeIRPF;

        // Pedimos el cargo del empleado
        System.out.print("Introduzca el cargo del empleado (1 - Prog. junior, 2 - Prog. senior, 3 - Jefe de proyecto): ");
        cargo = sc.nextInt();

        // Asignamos sueldo base según el cargo
        if (cargo == 1) {
            sueldoBase = 950;
        } else if (cargo == 2) {
            sueldoBase = 1200;
        } else if (cargo == 3) {
            sueldoBase = 1600;
        } else {
            System.out.println("Cargo no válido.");
            return; // Salimos del programa si el cargo no es válido
        }

        // Pedimos los días de viaje
        System.out.print("¿Cuántos días ha estado de viaje visitando clientes? ");
        diasViaje = sc.nextInt();

        // Pedimos estado civil
        System.out.print("Introduzca su estado civil (1 - Soltero, 2 - Casado): ");
        estadoCivil = sc.nextInt();

        // Calculamos dietas
        dietas = diasViaje * 30;

        // Calculamos sueldo bruto
        sueldoBruto = sueldoBase + dietas;

        // Calculamos IRPF según estado civil
        if (estadoCivil == 1) {
            porcentajeIRPF = 0.25;
        } else if (estadoCivil == 2) {
            porcentajeIRPF = 0.20;
        } else {
            System.out.println("Estado civil no válido.");
            return;
        }

        // Calculamos retención y sueldo neto
        retencionIRPF = sueldoBruto * porcentajeIRPF;
        sueldoNeto = sueldoBruto - retencionIRPF;

        // Mostramos la nómina bien desglosada
        System.out.println("----------------------------------------------");
        System.out.printf("| Sueldo base              %8.2f € |\n", sueldoBase);
        System.out.printf("| Dietas (%2d viajes)       %8.2f € |\n", diasViaje, dietas);
        System.out.println("----------------------------------------------");
        System.out.printf("| Sueldo bruto             %8.2f € |\n", sueldoBruto);
        System.out.printf("| Retención IRPF (%2.0f%%)      %8.2f € |\n", porcentajeIRPF * 100, retencionIRPF);
        System.out.println("----------------------------------------------");
        System.out.printf("| Sueldo neto              %8.2f € |\n", sueldoNeto);
        System.out.println("----------------------------------------------");

        sc.close();
    }
}
