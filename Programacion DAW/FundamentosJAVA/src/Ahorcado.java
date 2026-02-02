
    import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array con posibles palabras
        String[] palabras = {"programacion", "java", "ahorcado", "computadora", "teclado"};

        // Seleccionamos una palabra al azar
        String palabraSecreta = palabras[(int)(Math.random() * palabras.length)];

        // Creamos un array de caracteres para mostrar los *
        char[] palabraOculta = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '*';
        }

        int fallos = 0;
        boolean acertado = false;

        System.out.println(" Bienvenido al juego del Ahorcado ");
        System.out.println("Tienes 7 oportunidades para adivinar la palabra.\n");

        // Bucle principal del juego
        while (fallos < 7 && !acertado) {
            System.out.println("Palabra: " + String.valueOf(palabraOculta));
            System.out.print("Introduce una letra: ");
            String intento = sc.nextLine().toLowerCase();

            // Comprobamos que el usuario solo introduzca una letra
            if (intento.length() != 1) {
                System.out.println("Por favor, introduce solo una letra.");
                continue;
            }

            char letra = intento.charAt(0);
            boolean letraAcertada = false;

            // Recorremos la palabra para ver si la letra está
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraOculta[i] = letra;
                    letraAcertada = true;
                }
            }

            if (letraAcertada) {
                System.out.println("¡Bien hecho! La letra está en la palabra.");
            } else {
                fallos++;
                System.out.println("Letra incorrecta. Te quedan " + (7 - fallos) + " intentos.");
            }

            // Convertimos a String para comprobar si ya se adivinó la palabra
            if (String.valueOf(palabraOculta).equals(palabraSecreta)) {
                acertado = true;
            }
        }

        // Resultado final
        if (acertado) {
            System.out.println("\n ¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\n Has perdido. La palabra era: " + palabraSecreta);
        }

        sc.close();
    }
}


