package src.Controlador;



import src.Modelo.PiezaDAO;

public class PiezaController {

    private PiezaDAO piezaDAO;

    public PiezaController() {
        piezaDAO = new PiezaDAO();
    }

    // CREATE
    public void insertarPieza(int codigo, String nombre, String color,double precio, int codigoCategoria) {

        piezaDAO.insertar(codigo, nombre, color, precio, codigoCategoria);
    }

    // READ
    public void listarPiezas() {
        piezaDAO.listar();
    }

    // UPDATE
    public void actualizarPieza(int codigo, String nombre, String color,double precio, int codigoCategoria) {

        piezaDAO.actualizar(codigo, nombre, color, precio, codigoCategoria);
    }

    // DELETE
    public void borrarPieza(int codigo) {
        piezaDAO.borrar(codigo);
    }
}

