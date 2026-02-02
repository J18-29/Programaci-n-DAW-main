import java.util.Arrays;

public class Arrays1 {
    private int[] pila;  // Array que representa la pila
    private int tamaño;  // Número de elementos actuales en la pila

    // Constructor: inicializa la pila vacía
    public Arrays1() {
        pila = new int[0]; // Pila vacía
        tamaño = 0;        // Tamaño inicial 0
    }

    // Función push: agrega un número al final del arreglo
    public void push(int numero) {
        // Creamos un nuevo array con un tamaño mayor en 1
        int[] nuevaPila = new int[tamaño + 1];

        // Copiamos los elementos existentes al nuevo array
        for (int i = 0; i < tamaño; i++) {
            nuevaPila[i] = pila[i];
        }

        // Agregamos el nuevo elemento al final
        nuevaPila[tamaño] = numero;

        // Actualizamos la referencia de la pila y el tamaño
        pila = nuevaPila;
        tamaño++;
    }

    // Función pop: elimina el último número del arreglo y lo devuelve
    public int pop() {
        if (tamaño == 0) { // Verificamos si la pila está vacía
            System.out.println("La pila está vacía.");
            return -1; // Valor indicativo de pila vacía
        }

        // Guardamos el último elemento
        int ultimo = pila[tamaño - 1];

        // Creamos un nuevo array con tamaño reducido en 1
        int[] nuevaPila = new int[tamaño - 1];
        for (int i = 0; i < tamaño - 1; i++) {
            nuevaPila[i] = pila[i];
        }

        // Actualizamos la pila y el tamaño
        pila = nuevaPila;
        tamaño--;

        // Devolvemos el elemento eliminado
        return ultimo;
    }

    // Método para mostrar los elementos actuales de la pila
    public void mostrarPila() {
        System.out.println(Arrays.toString(pila));
    }

    // Método main para probar las funciones
    public static void main(String[] args) {
       Arrays1 miPila = new Arrays1();

        // Agregamos elementos a la pila
        miPila.push(10);
        miPila.push(20);
        miPila.push(30);

        // Mostramos la pila después de los push
        System.out.print("Pila después de push: ");
        miPila.mostrarPila();

        // Extraemos el último elemento
        int extraido = miPila.pop();
        System.out.println("Elemento extraído: " + extraido);

        // Mostramos la pila después del pop
        System.out.print("Pila después de pop: ");
        miPila.mostrarPila();
    }
}

