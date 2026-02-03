public class PruebaClase {
    public static void main(String[] args) {
        CategoriaDAO.listar();
        Categoria nuevo= CategoriaDAO.listar(2);
        System.out.println(nuevo);
        nuevo.setNombre("Electrónica");
        CategoriaDAO.actualizar(1, nuevo.getNombre());
        CategoriaDAO.actualizar(nuevo);

    }
}
