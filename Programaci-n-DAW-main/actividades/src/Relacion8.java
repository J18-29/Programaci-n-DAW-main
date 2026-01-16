import java.util.Scanner;

public class Relacion8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de términos a mostrar: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("El número debe ser mayor que 0.");
        } else {
            System.out.println("Los primeros " + n + " términos de la serie de Fibonacci son:");
            
            long a = 0; // primer término
            long b = 1; // segundo término

            for (int i = 1; i <= n; i++) {
                System.out.print(a + " ");
                long siguiente = a + b; // calcular siguiente término
                a = b;
                b = siguiente;
            }
        }

        sc.close();
    }
}
