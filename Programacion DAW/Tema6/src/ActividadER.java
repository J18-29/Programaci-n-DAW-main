import ActividadER.CategoriaDAO;


public class ActividadER {
    public static void main(String[] args) {
        //Insertar una categoría de prueba
        // CategoriaDAO.insertar(1, "Electrónica");
        // CategoriaDAO.insertar(2, "Muebles");
        // CategoriaDAO.insertar(3, "Borrar");

        //Actualizar una categoría
        CategoriaDAO.actualizar(2, "Electrónica y Gadgets");

        //Borrar una categoría
        CategoriaDAO.borrar(3);

        //Listar todas las categorías
        CategoriaDAO.listar();

        //Insertar un Proveedor de prueba
        
    }
}
