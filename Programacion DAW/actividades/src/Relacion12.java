import java.util.Scanner;

public class Relacion12 {

    // Función que calcula el máximo común divisor usando el algoritmo de Euclides
    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    // Función que calcula el mínimo común múltiplo a partir del mcd
    public static int mcm(int a, int b) {
        return Math.abs(a * b) / mcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        int num2 = sc.nextInt();

        int resultado = mcm(num1, num2);

        System.out.println("El mínimo común múltiplo de " + num1 + " y " + num2 + " es: " + resultado);

        sc.close();
    }
}
