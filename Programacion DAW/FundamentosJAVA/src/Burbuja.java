import java.util.ArrayList;
import java.util.Arrays;

public class Burbuja {
    public static void main(String[] args) {
        int vec[] = {6, 8, 3, 5, 4, 9, 0, 2, 1, 7};

        System.out.print("Vector sin ordenar: ");
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }

        // Ordenamiento burbuja
        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = 0; j < (vec.length - 1 - i); j++) {
                if (vec[j] > vec[j + 1]) {
                    int aux = vec[j];
                    vec[j] = vec[j + 1];
                    vec[j + 1] = aux;
                }
            }
        }

        System.out.print("\nVector ordenado (Burbuja): ");
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }
        System.out.println();

        // Utilizando métodos de clases que ya existen (Arrays.sort)
        int vector[] = {6, 8, 3, 5, 4, 9, 0, 2, 1, 7};
        Arrays.sort(vector);
        System.out.print("\nVector ordenado (Arrays.sort): ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();

        // Comprobar si dos vectores son iguales
        System.out.println("\n¿Son iguales los dos vectores? " + Arrays.equals(vec, vector));

        // Uso de ArrayList
        ArrayList<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(7);

        System.out.print("\nContenido del ArrayList: ");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();

        System.out.println("Quitar el último elemento:");
        // removeLast() no existe en ArrayList, usamos remove(size - 1)
        int valor = array.remove(array.size() - 1);
        System.out.println("Elemento eliminado: " + valor);

        System.out.print("ArrayList después de eliminar: ");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();

        if (array.contains(3)) {
            System.out.println("El ArrayList contiene el número 3");
        }

        // Uso de String
        String cadena = "viernes";
        System.out.println("\nCadena: " + cadena);

        if (cadena.equals("viernes")) {
            System.out.println("HOY ES HALLOWEEN");
        }

        System.out.println("Carácter en posición 3: " + cadena.charAt(3));

        String resultado = cadena.concat(" es festivo");
        System.out.println("Concatenación: " + resultado);

        String halloween = "HOY ES HALLOWEEN";

        System.out.println("Minúsculas: " + halloween.toLowerCase());
        System.out.println("Reemplazo de 'L' por 'Ñ': " + halloween.replace('L', 'Ñ'));
        System.out.println("Trim (sin espacios): " + halloween.trim());

        String texto = "hola, domingo, buenos dias";
        System.out.println("Texto: " + texto);
    }
}
