

import java.util.Scanner;
public class Relacion4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduce la nota del primer control: ");
        double nota1 = entrada.nextDouble();  // Acepta entero o decimal

        System.out.print("Introduce la nota del segundo control: ");
        double nota2 = entrada.nextDouble();  // Acepta entero o decimal

        double media = (nota1 + nota2) / 2;

        int notaFinal;

        if (media >= 5) {
            notaFinal = (int) Math.round(media);
            System.out.println("Tu nota media es: " + notaFinal);
        } else {
            System.out.print("¿Cuál ha sido el resultado de la recuperación? (apto/no apto): ");
            String recuperacion = entrada.next();

            if (recuperacion.equalsIgnoreCase("apto")) {
                notaFinal = 5;
            } else {
                notaFinal = (int) Math.round(media);
            }

            System.out.println("Tu nota final es: " + notaFinal);
        }

        entrada.close();
    }
}

