
import java.time.LocalDateTime;

public class Funciones {

    public static void main(String[] args) {
        // Fecha y hora actual
        LocalDateTime hoy = LocalDateTime.now();
        System.out.println("Hoy es: " + hoy.getDayOfWeek()); // nombre del día
        System.out.println("El día es: " + hoy.getDayOfMonth());
        System.out.println("El mes es: " + hoy.getMonth()); // nombre del mes
        System.out.println("El año es: " + hoy.getYear());
        System.out.println("Hora: " + hoy.getHour() + " Minutos: " + hoy.getMinute());

        System.out.println("\n--- Math ---");
        System.out.println("2^8 = " + Math.pow(2, 8));

        System.out.println("\n--- Números aleatorios ---");
        int min = 1;
        int max = 15;
        int aleatorio = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Número aleatorio entre " + min + " y " + max + ": " + aleatorio);

        System.out.println("\n--- Operadores ++ y -- ---");
        int valor = 1;

        System.out.println("Valor inicial: " + valor);

        // Postdecremento
        System.out.println("valor-- = " + (valor--)); // Usa el valor y luego lo decrementa
        System.out.println("Después de valor--, valor = " + valor);

        // Predecremento
        System.out.println("--valor = " + (--valor)); // Decrementa y luego usa el valor
        System.out.println("Después de --valor, valor = " + valor);

        // También mostramos incremento para comparar
        System.out.println("valor++ = " + (valor++)); // Usa el valor y luego lo incrementa
        System.out.println("Después de valor++, valor = " + valor);

        System.out.println("++valor = " + (++valor)); // Incrementa y luego usa el valor
        System.out.println("Después de ++valor, valor = " + valor);

        System.out.println("\n--- Operadores lógicos ---");
        System.out.println("(5 > 3) && (5 > 6): " + ((5 > 3) && (5 > 6)));

        System.out.println("\n--- Operador opera-asigna ---");
        int numero11 = 3;
        int numero12 = 4;
        numero11 += numero12; // equivale a numero11 = numero11 + numero12;
        System.out.println("Resultado de numero11 += numero12: " + numero11);

        System.out.println("\n--- Operador ternario ---");
        int a = 10, b = 5;
        int x = (a == 10) ? b * 2 : a;
        System.out.println("Resultado del operador ternario: " + x);

        System.out.println("\n--- Divisibilidad ---");
        int numero = 12; // Cambia este valor para probar otros
        if (numero % 2 == 0 && numero % 3 == 0) {
            System.out.println(numero + " es divisible por 2 y 3");
        } else {
            System.out.println(numero + " no es divisible por 2 y 3");
        }
    }
}

