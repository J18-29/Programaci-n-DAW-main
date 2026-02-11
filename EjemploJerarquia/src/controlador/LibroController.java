package src.controlador;

import java.util.List;

import src.modelo.Libro;
import src.modelo.LibroDAO;

public class LibroController {

    private LibroDAO libroDAO;

    public LibroController() {
        this.libroDAO = new LibroDAO();
    }

    public void crearLibro(String isbn, String titulo, int año, String descripcion) {
        Libro libro = new Libro(0, isbn, titulo, año, descripcion);
        libroDAO.insertar(libro);
    }

    public List<Libro> obtenerLibros() {
        return libroDAO.listar();
    }

    public void eliminarLibro(int id) {
        libroDAO.eliminar(id);
    }
}
