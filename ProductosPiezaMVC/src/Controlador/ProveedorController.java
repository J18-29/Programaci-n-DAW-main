

package src.Controlador;




import src.Modelo.ProveedorDAO;

public class ProveedorController {

    private ProveedorDAO proveedorDAO;

    public ProveedorController() {
        proveedorDAO = new ProveedorDAO();
    }

    public void insertarProveedor(int codigo, String direccion, String ciudad, String provincia) {
        proveedorDAO.insertar(codigo, direccion, ciudad, provincia);
    }

    public void listarProveedores() {
        proveedorDAO.listar();
    }

    public void actualizarProveedor(int codigo, String direccion, String ciudad, String provincia) {
        proveedorDAO.actualizar(codigo, direccion, ciudad, provincia);
    }

    public void borrarProveedor(int codigo) {
        proveedorDAO.borrar(codigo);
    }
}
