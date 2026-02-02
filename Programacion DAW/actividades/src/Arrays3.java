import java.util.Arrays;

public class Arrays3 {
    public static void main(String[] args) {

        // Array de ejemplo con varios números
        int[] numeros = {4, 7, 2, 9, 1};

        // Llamamos al método maxMin para obtener máximo y mínimo del array
        int[] resultado = maxMin(numeros);

        // Mostramos el array original
        System.out.println("Array original: " + Arrays.toString(numeros));

        // Mostramos el máximo y el mínimo obtenidos
        System.out.println("Máximo: " + resultado[0] + ", Mínimo: " + resultado[1]);
    }

    // Método que devuelve un array con el máximo y el mínimo del array recibido
    public static int[] maxMin(int[] arr) {

        // Inicializamos max y min con el primer elemento del array
        int max = arr[0];
        int min = arr[0];

        // Recorremos el array con un bucle for-each
        for (int n : arr) {
            if (n > max) max = n; // Si el número actual es mayor que el máximo, lo actualizamos
            if (n < min) min = n; // Si es menor que el mínimo, lo actualizamos
        }

        // Devolvemos un nuevo array con [máximo, mínimo]
        return new int[]{max, min};
    }
}
