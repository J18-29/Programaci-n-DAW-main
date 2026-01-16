package Examen;

public class Examen5 {
    

    // Función para comprobar si un número es primo
    public static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Pedimos los números al usuario
        System.out.print("Introduce un número mayor que 50: ");
        int numero1 = sc.nextInt();
        System.out.print("Introduce otro número mayor que 50 y mayor que el primero: ");
        int numero2 = sc.nextInt();

        // Validamos que se cumplan las condiciones
        if (numero1 <= 50 || numero2 <= 50 || numero1 >= numero2) {
            System.out.println("Los números no cumplen las condiciones.");
        } else {
            System.out.println("Números primos entre " + numero1 + " y " + numero2 + ":");
            for (int n = numero1; n <= numero2; n++) {
                if (esPrimo(n)) {
                    System.out.print(n + " ");
                }
            }
        }

        sc.close();
    }
}


