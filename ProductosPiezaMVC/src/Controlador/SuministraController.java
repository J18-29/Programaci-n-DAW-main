package src.Controlador;



import src.Modelo.SuministraDAO;
import java.sql.Timestamp;

public class SuministraController {

    private SuministraDAO suministraDAO;

    public SuministraController() {
        suministraDAO = new SuministraDAO();
    }

    // CREATE
    public void insertarSuministro(int codigoProveedor, int codigoPieza,Timestamp fechaHora, int cantidad) {

        suministraDAO.insertar(codigoProveedor, codigoPieza, fechaHora, cantidad);
    }

    // READ
    public void listarSuministros() {
        suministraDAO.listar();
    }

    // UPDATE
    public void actualizarSuministro(int codigoProveedor, int codigoPieza,Timestamp fechaHora, int cantidad) {

        suministraDAO.actualizar(codigoProveedor, codigoPieza, fechaHora, cantidad);
    }

    // DELETE
    public void borrarSuministro(int codigoProveedor, int codigoPieza) {
        suministraDAO.borrar(codigoProveedor, codigoPieza);
    }
}
