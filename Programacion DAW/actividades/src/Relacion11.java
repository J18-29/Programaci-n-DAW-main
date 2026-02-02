import java.util.Scanner;

public class Relacion11 {

    // Función suma
    public static double suma(double a, double b) {
        return a + b;
    }

    // Función resta
    public static double resta(double a, double b) {
        return a - b;
    }

    // Función multiplicación
    public static double multiplicacion(double a, double b) {
        return a * b;
    }

    // Función división
    public static double division(double a, double b) {
        if (b == 0) {
            System.out.println("Error: División entre cero.");
            return 0;
        }
        return a / b;
    }

    // Procedimiento que muestra el menú
    public static void mostrarMenu() {
        System.out.println("\n----- Calculadora -----");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Introduce el primer operando (-1 para salir): ");
                double op1 = sc.nextDouble();
                if (op1 == -1) break;

                System.out.print("Introduce el segundo operando (-1 para salir): ");
                double op2 = sc.nextDouble();
                if (op2 == -1) break;

                double resultado = 0;
                switch (opcion) {
                    case 1:
                        resultado = suma(op1, op2);
                        break;
                    case 2:
                        resultado = resta(op1, op2);
                        break;
                    case 3:
                        resultado = multiplicacion(op1, op2);
                        break;
                    case 4:
                        resultado = division(op1, op2);
                        break;
                }
                System.out.println("Resultado: " + resultado);
            } else if (opcion == 5) {
                System.out.println("Saliendo de la calculadora...");
            } else {
                System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
