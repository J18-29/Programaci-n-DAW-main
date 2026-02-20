import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploGUI2 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton botonMostrar;

    public EjemploGUI2(String title) {
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

        JDialog ventana = new JDialog(this, "Confirmación", true);
        ventana.setSize(300, 120);
        ventana.setLocationRelativeTo(this);

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        // Si pulsa Aceptar → cerrar ventana principal
        aceptar.addActionListener(e -> dispose());

        // Si pulsa Cancelar → cerrar solo la ventana de confirmación
        cancelar.addActionListener(e -> ventana.dispose());

        JPanel panelConfirmacion = new JPanel();
        panelConfirmacion.add(new JLabel("¿Estás seguro de que quieres salir?"));
        panelConfirmacion.add(aceptar);
        panelConfirmacion.add(cancelar);

        ventana.add(panelConfirmacion);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploGUI2("Ventana principal");
    }
}