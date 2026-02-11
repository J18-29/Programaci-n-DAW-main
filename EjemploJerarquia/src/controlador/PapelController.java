package src.Controlador;

import java.time.LocalDate;
import java.util.List;

import src.Modelo.Papel;
import src.Modelo.PapelDAO;

public class PapelController {

    private PapelDAO papelDAO;

    public PapelController() {
        this.papelDAO = new PapelDAO();
    }

    public void crearPapel(LocalDate fechaImpresion, double precio, String lugarImpresion) {
        Papel papel = new Papel(0, fechaImpresion, precio, lugarImpresion);
        papelDAO.insertar(papel);
    }

    public List<Papel> obtenerPapeles() {
        return papelDAO.listar();
    }

    public void eliminarPapel(int id) {
        papelDAO.eliminar(id);
    }
}
