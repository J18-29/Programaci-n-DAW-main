package src.Controlador;


import src.Modelo.CategoriaDAO;
import src.Modelo.Categoria;

public class CategoriaController {

    // CREATE
    public void insertarCategoria(int codigo, String nombre) {
        CategoriaDAO.insertar(codigo, nombre);
    }

    // READ (listar todo)
    public void listarCategorias() {
        CategoriaDAO.listar();
    }

    // READ (buscar por id)
    public Categoria buscarCategoria(int id) {
        return CategoriaDAO.listar(id);
    }

    // UPDATE
    public void actualizarCategoria(int codigo, String nombre) {
        CategoriaDAO.actualizar(codigo, nombre);
    }

    public void actualizarCategoria(Categoria categoria) {
        CategoriaDAO.actualizar(categoria);
    }

    // DELETE
    public void borrarCategoria(int codigo) {
        CategoriaDAO.borrar(codigo);
    }
}
