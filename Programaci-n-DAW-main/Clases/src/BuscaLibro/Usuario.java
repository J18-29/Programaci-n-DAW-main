package BuscaLibro;
import java.util.ArrayList;

public class Usuario {
     String nombre;
     int codigo;
     ArrayList<Libro> librosPrestados;

    public Usuario(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        librosPrestados = new ArrayList<>();
    }

    public void prestarLibro(Libro libro) {
    // 1. VERIFICACIÓN DE DOBLE PRÉSTAMO (NUEVA LÓGICA)
    if (librosPrestados.contains(libro)) {
        System.out.println(" ERROR: " + nombre + " ya tiene prestado el libro: " + libro.getNombre());
        return; // Detiene la operación aquí
    }

    // 2. VERIFICACIÓN DE STOCK (LÓGICA EXISTENTE)
    if (libro.prestar()) {
        librosPrestados.add(libro);
        System.out.println(nombre + " ha prestado: " + libro.getNombre());
    } else {
        // Mensaje cuando el stock llega a cero
        System.out.println(" AGOTADO: No hay ejemplares disponibles de: " + libro.getNombre());
    }
}
    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            libro.devolver();
            librosPrestados.remove(libro);
            System.out.println(nombre + " ha devuelto: " + libro.getNombre());
        } else {
            System.out.println("ERROR: Ese libro no lo tiene prestado el usuario.");
        }
    }
}
