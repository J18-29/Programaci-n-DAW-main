

import java.util.Scanner;

public class Continuación7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos los números al usuario
        System.out.print("Ingresa el primer número: ");
        int a = sc.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int b = sc.nextInt();

        // Nos aseguramos de que sean valores positivos
        a = Math.abs(a);
        b = Math.abs(b);

        // Algoritmo para calcular el MCD
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }

        // Mostramos el resultado
        System.out.println("El MCD es: " + a);

        sc.close();
    }
}
