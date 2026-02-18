import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EjemploGUI extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel etiquetaTitulo;
    private JLabel etiquetaResultado;

    private JTextField campo1;
    private JTextField campo2;

    private JButton botonSumar;
    private JButton botonRestar;

    public EjemploGUI(String titulo) {

        setTitle(titulo);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(); // FlowLayout por defecto

        // Título
        etiquetaTitulo = new JLabel("Calculadora Simple");
        etiquetaTitulo.setForeground(Color.BLUE);

        // Campos
        campo1 = new JTextField(5);
        campo2 = new JTextField(5);

        // Botones
        botonSumar = new JButton("Sumar");
        botonRestar = new JButton("Restar");

        botonSumar.addActionListener(this);
        botonRestar.addActionListener(this);

        // Resultado
        etiquetaResultado = new JLabel("Resultado: ");
        etiquetaResultado.setForeground(Color.RED);

        // Añadir al panel
        panel.add(etiquetaTitulo);
        panel.add(new JLabel("Número 1:"));
        panel.add(campo1);
        panel.add(new JLabel("Número 2:"));
        panel.add(campo2);
        panel.add(botonSumar);
        panel.add(botonRestar);
        panel.add(etiquetaResultado);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            int n1 = Integer.parseInt(campo1.getText());
            int n2 = Integer.parseInt(campo2.getText());
            int resultado;

            if (e.getSource() == botonSumar) {
                resultado = n1 + n2;
            } else {
                resultado = n1 - n2;
            }

            etiquetaResultado.setText("Resultado: " + resultado);

        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Introduce números válidos");
        }
    }

    public static void main(String[] args) {
        new EjemploGUI("Ventana principal");
    }
}
