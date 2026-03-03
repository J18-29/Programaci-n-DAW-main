import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controlador.CategoriaController;
import vista.PiezaView;
import vista.ProveedorView;
import vista.SuministraView;
import vista.CategoriaView;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IES Cura Valera");
        //Crear el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50,50,300,200);
        CategoriaView view = new CategoriaView();
        // PiezaView viewPieza = new PiezaView();
        // ProveedorView viewProveedor = new ProveedorView();
        // SuministraView viewSuministra = new SuministraView();
        //Añadir los paneles como pestañas
        tabbedPane.addTab("Categorías", view);
        // tabbedPane.addTab("Piezas", viewPieza);
        // tabbedPane.addTab("Proveedores", viewProveedor);
        // tabbedPane.addTab("Suministra", viewSuministra);
        //Definir el controlador asociado
        CategoriaController c1 = new CategoriaController(view);
        // PiezaController controllerPieza = new PiezaController(viewPieza);
        // ProveedorController controllerProveedor = new ProveedorController(viewProveedor);
        // SuministraController controllerSuministra = new SuministraController(viewSuministra);
        //Asociar el TabbedPane
        frame.setContentPane(tabbedPane);
        //Tamaño y visibilidad
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
