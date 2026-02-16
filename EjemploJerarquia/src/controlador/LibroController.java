package src.Controlador;

import src.Modelo.EbookDAO;
import src.Modelo.PapelDAO;
import src.Vista.LibroView;

public class LibroController {

    private EbookDAO ebookdao;
    private PapelDAO papeldao;
    private LibroView view;

    public LibroController() {
        papeldao = new PapelDAO();
        ebookdao = new EbookDAO();
        view = new LibroView();
    }
    public void iniciar() {
        int opcion;
        try{
            do {
                opcion = view.mostrarMenu();
                switch (opcion) {
                    case 1: view.mostrarLibros(papeldao.listar());
                        view.mostrarMensaje("Listar el contenido de Papel..."); break;
                    case 2: view.mostrarLibros(ebookdao.listar());
                        view.mostrarMensaje("Listar el contenido de Ebook..."); break;
                    case 3: papeldao.insertar(view.pedirNuevoLibroPapel());
                        view.mostrarMensaje("Nuevo libro papel insertado"); break; 
                    case 4: ebookdao.insertar(view.pedirNuevoLibroEbook());
                        view.mostrarMensaje("Nuevo libro EBOOK insertado"); break; 
                    case 5: papeldao.eliminar(view.pedirIdEliminar());
                        view.mostrarMensaje("Libro Papel eliminado"); break;
                    case 6: ebookdao.eliminar(view.pedirIdEliminar());
                        view.mostrarMensaje("Libro Ebook eliminado"); break;
                    case 7: view.mostrarMensaje("Información del libro Papel por id "); 
                        view.mostrarLibro(papeldao.listarById(view.pedirIdLibro())); break;
                    case 0: view.mostrarMensaje("Saliendo..."); break;
                    default: view.mostrarMensaje("Opción incorrecta"); break;
                }
            } while (opcion != 0);
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
    }
}