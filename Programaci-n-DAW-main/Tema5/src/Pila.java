import java.util.ArrayList;

public class Pila<T> {
    private ArrayList<T> elementos;

    // Constructor
    public Pila() {
        elementos = new ArrayList<>();
    }

    // Método para insertar un elemento en la pila (push)
    public void insertar(T elemento) {
        elementos.add(elemento);
    }

    // Método para borrar el elemento superior de la pila (pop)
    public T borrar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no se puede borrar.");
            return null;
        }
        return elementos.remove(elementos.size() - 1);
    }

    // Método para buscar un elemento en la pila
    public boolean buscar(T elemento) {
        return elementos.contains(elemento);
    }

    // Método para devolver el elemento superior de la pila sin borrarlo (peek)
    public T devolver() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return elementos.get(elementos.size() - 1);
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

   
    @Override
    public String toString() {
        return "Pila: " + elementos.toString();
    }

   
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        // Insertamos elementos
        pila.insertar(10);
        pila.insertar(20);
        pila.insertar(30);
        pila.insertar(40);
        System.out.println(pila);

        // Devolvemos el elemento superior
        System.out.println("Elemento superior: " + pila.devolver());

        // Buscamos un elemento
        System.out.println("¿Contiene 20? " + pila.buscar(20));
        System.out.println("¿Contiene 40? " + pila.buscar(40));

        // Borramos elementos
        System.out.println("Elemento borrado: " + pila.borrar());
        System.out.println(pila);

        // Verificamos si está vacía
        System.out.println("¿La pila está vacía? " + pila.estaVacia());
    }
}
