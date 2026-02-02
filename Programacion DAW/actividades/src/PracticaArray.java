import java.util.Arrays;

public class PracticaArray {

    // Función para copiar un array
    public static int[] copiarArray(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }

    // Función para borrar un valor del array
    public static int[] borrarValor(int[] array, int valorABorrar) {
        // Contar cuántas veces aparece el valor a borrar
        int contador = 0;
        for (int num : array) {
            if (num == valorABorrar) {
                contador++;
            }
        }

        // Crear nuevo array con tamaño ajustado
        int[] nuevoArray = new int[array.length - contador];
        int index = 0;

        for (int num : array) {
            if (num != valorABorrar) {
                nuevoArray[index] = num;
                index++;
            }
        }

        return nuevoArray;
    }

    // Función para insertar un valor en una posición específica
    public static int[] insertarValor(int[] array, int valor, int posicion) {
        int nuevoTamaño = Math.max(array.length + 1, posicion + 1);
        int[] nuevoArray = new int[nuevoTamaño];

        int j = 0; // índice para recorrer el array original

        for (int i = 0; i < nuevoTamaño; i++) {
            if (i == posicion) {
                nuevoArray[i] = valor; // Insertamos el nuevo valor
            } else {
                if (j < array.length) {
                    nuevoArray[i] = array[j]; // Copiamos los valores del array original
                    j++;
                } else {
                    nuevoArray[i] = 0; // Rellenar con ceros si es necesario
                }
            }
        }

        return nuevoArray;
    }

    // Método principal
    public static void main(String[] args) {
        // Array original
        int[] original = {2, 3, 5, 7, 8, 2};

        // Paso 1: Copiar el array
        int[] copia = copiarArray(original);
        System.out.println("Copia del array: " + Arrays.toString(copia));

        // Paso 2: Borrar todas las apariciones del número 2
        int[] sinDos = borrarValor(copia, 2);
        System.out.println("Array después de borrar el 2: " + Arrays.toString(sinDos));

        // Paso 3: Insertar el número 10 en la posición 2
        int[] conInsertado = insertarValor(sinDos, 10, 2);
        System.out.println("Array después de insertar 10 en la posición 2: " + Arrays.toString(conInsertado));

        // Paso extra: Insertar el número 99 en una posición mayor al tamaño (por ejemplo, 10)
        int[] conInsertadoLargo = insertarValor(sinDos, 34, 10);
        System.out.println("Array después de insertar 99 en la posición 10: " + Arrays.toString(conInsertadoLargo));
    }
}
