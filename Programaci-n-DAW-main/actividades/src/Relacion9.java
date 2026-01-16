import java.util.Scanner;

public class Relacion9 {

    // Función recursiva que devuelve el enésimo término de Fibonacci
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0; // primer término
        } else if (n == 1) {
            return 1; // segundo término
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // suma de los dos anteriores
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de términos a mostrar: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("El número debe ser mayor que 0.");
        } else {
            System.out.println("Los primeros " + n + " términos de la serie de Fibonacci son:");

            for (int i = 0; i < n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
        }

        sc.close();
    }
}
