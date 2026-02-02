import java.util.Scanner;
import java.util.Random;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1; // Número entre 1 y 100
        int intentos = 0;
        int adivinanza = 0;

        System.out.println("¡Bienvenido al juego de Adivina el Número!");
        System.out.println("Estoy pensando en un número entre 1 y 100.");
        
        while (adivinanza != numeroSecreto) {
            System.out.print("Ingresa tu intento: ");
            
            // Validar que el usuario ingrese un número
            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar la entrada inválida
                continue;
            }

            adivinanza = scanner.nextInt();
            intentos++;

            if (adivinanza < numeroSecreto) {
                System.out.println("Demasiado bajo. ¡Intenta otra vez!");
            } else if (adivinanza > numeroSecreto) {
                System.out.println("Demasiado alto. ¡Intenta otra vez!");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
            }
        }

        scanner.close();
    }
}

