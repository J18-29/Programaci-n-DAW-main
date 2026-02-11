package src;


import src.Controlador.CategoriaController;

public class EjecutarProveedorPiezaMVC {
    public static void main(String[] args) throws Exception {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.listarCategorias();
        
    }
}
