package src.Controlador;

import java.util.List;

import src.Modelo.Ebook;
import src.Modelo.EbookDAO;


public class EbookController {

    private EbookDAO ebookDAO;

    public EbookController() {
        this.ebookDAO = new EbookDAO();
    }

    public void crearEbook(String tamaño, double precio) {
        Ebook ebook = new Ebook(0, tamaño, precio);
        ebookDAO.insertar(ebook);
    }

    public List<Ebook> obtenerEbooks() {
        return ebookDAO.listar();
    }

    public void eliminarEbook(int id) {
        ebookDAO.eliminar(id);
    }
}

