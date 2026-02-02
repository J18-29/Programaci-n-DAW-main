import java.util.Scanner;

public class Relacion10 {

    // Función que devuelve el número de dígitos pares
    public static int contarPares(int numero) {
        int pares = 0;
        while (numero != 0) {
            int digito = numero % 10;
            if (digito % 2 == 0) {
                pares++;
            }
            numero /= 10;
        }
        return pares;
    }

    // Función que devuelve el número de dígitos impares
    public static int contarImpares(int numero) {
        int impares = 0;
        while (numero != 0) {
            int digito = numero % 10;
            if (digito % 2 != 0) {
                impares++;
            }
            numero /= 10;
        }
        return impares;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();

        int pares = contarPares(numero);
        int impares = contarImpares(numero);

        System.out.println("El " + numero + " contiene " + pares + " dígitos pares y " + impares + " dígitos impares.");

        sc.close();
    }
}
