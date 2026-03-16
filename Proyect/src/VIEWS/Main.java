package VIEWS;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import CONTROLLERS.AutorCONTROLLERS;
import CONTROLLERS.LibroCONTROLLERS;
import CONTROLLERS.PrestadoCONTROLLERS;
import CONTROLLERS.UsuarioCONTROLLERS;

public class Main {
    public static void main(String []args){
         JFrame frame =new JFrame("IES Cura Valera");

        JTabbedPane tabbedPane=new JTabbedPane();
        tabbedPane.setBounds(50,50,300,200);

        AutorVIEW view=new AutorVIEW();
        LibroVIEW view2= new LibroVIEW();
        UsuarioVIEW view3= new UsuarioVIEW();
        PrestadoVIEW view4 =new PrestadoVIEW();

        // Añadir los paneles como pestañas

        tabbedPane.addTab("Autor",view);
        tabbedPane.addTab("Libro",view2);
       tabbedPane.addTab("Usuario",view3);
       tabbedPane.addTab("Prestado",view4);

        // Definir el controlador asociado

        AutorCONTROLLERS c1=new AutorCONTROLLERS(view);
        LibroCONTROLLERS c2= new LibroCONTROLLERS(view2);
        UsuarioCONTROLLERS c3= new UsuarioCONTROLLERS(view3);
        PrestadoCONTROLLERS c4= new PrestadoCONTROLLERS(view4);

        // Asociar el tabbedPane

        frame.setContentPane(tabbedPane);

        // Tamaño y visibilidad
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
