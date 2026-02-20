import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EjemploGUI3 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton botonMostrar;

    public EjemploGUI3(String title) {
        super(title);
        initComponents();
    }

    private void initComponents() {

        setSize(300, 150);
        setLocationRelativeTo(null);

        // La X no hace nada
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        botonMostrar = new JButton("Mostrar información");
        botonMostrar.addActionListener(this);

        panel = new JPanel();
        panel.add(botonMostrar);

        setContentPane(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarConfirmacion();
    }

    private void mostrarConfirmacion() {
 int opcion = JOptionPane.showConfirmDialog(
 this, // ventana padre
 "¿Seguro que desea salir?", // mensaje
 "Confirmar salida", // título
 JOptionPane.YES_NO_OPTION, // tipo de opciones
 JOptionPane.QUESTION_MESSAGE // icono
 );
 if (opcion == JOptionPane.YES_OPTION) {
 System.exit(0);
 }
 // si es NO, no hace nada y la ventana principal sigue abierta
}
    public static void main(String[] args) {
        new EjemploGUI2("Ventana principal");
    }
}