import java.util.Scanner;

public class Decimal {
    // Método recursivo para convertir decimal a binario
    public static String pasarBinario(int n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else {
            return pasarBinario(n / 2) + (n % 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Introduce un número entero positivo: ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                System.out.println("Por favor, introduce solo números positivos.");
            } else {
                String binario = pasarBinario(numero);
                System.out.println("El número " + numero + " en binario es: " + binario);
            }

            System.out.print("¿Deseas convertir otro número? (s/n): ");
            opcion = scanner.next();
        } while (opcion.equalsIgnoreCase("s"));

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}


