package BuscaLibro;

import java.util.ArrayList;

public class Biblioteca {
     String nombre;
     ArrayList<Libro> listaLibros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        listaLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        
        listaLibros.add(libro);
    }

    public Libro buscarLibro(String nombreLibro) {
        for (Libro l : listaLibros) {
            if (l.getNombre().equalsIgnoreCase(nombreLibro)) {
                return l;
            }
        }
        return null;
    }

    public void eliminarLibro(String nombreLibro) {
        Libro libro = buscarLibro(nombreLibro);
        if (libro != null) {
            listaLibros.remove(libro);
            System.out.println("Libro eliminado: " + nombreLibro);
        } else {
            System.out.println("No se encontró el libro: " + nombreLibro);
        }
    }

    public ArrayList<Libro> buscarPorAutor(String nombreAutor) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro l : listaLibros) {
            if (l.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public ArrayList<Libro> buscarPorCategoria(String categoria) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro l : listaLibros) {
            if (l.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(l);
            }
        }
        return resultado;
    }
}
