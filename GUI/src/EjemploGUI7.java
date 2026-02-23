import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EjemploGUI7 extends JFrame implements ActionListener {

    private JTextField pantalla;
    private String operador = "";
    private double num1 = 0;

    public EjemploGUI7() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Calculadora Grid");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Pantalla
        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        add(pantalla, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5)); // ahora 5 filas para los botones nuevos
        String[] botones = { "7", "8", "9", "/", 
                             "4", "5", "6", "*", 
                             "1", "2", "3", "-", 
                             "C", "0", "=", "+",
                             "^", "√", "", "" }; // ^ potencia y √ raíz cuadrada

        for (String texto : botones) {
            JButton boton;
            if (!texto.isEmpty()) {
                boton = new JButton(texto);
                boton.setFont(new Font("Arial", Font.BOLD, 18));
                boton.addActionListener(this);
            } else {
                boton = new JButton(); // botón vacío
                boton.setEnabled(false);
            }
            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        // Si es número
        if (comando.matches("[0-9]")) {
            pantalla.setText(pantalla.getText() + comando);
        }
        // Si es operación básica
        else if (comando.matches("[+\\-*/^]")) {
            if (!pantalla.getText().isEmpty()) {
                num1 = Double.parseDouble(pantalla.getText());
                operador = comando;
                pantalla.setText("");
            }
        }
        // Si es raíz cuadrada
        else if (comando.equals("√")) {
            if (!pantalla.getText().isEmpty()) {
                double num = Double.parseDouble(pantalla.getText());
                if (num < 0) {
                    JOptionPane.showMessageDialog(this, "No se puede calcular raíz de número negativo");
                    return;
                }
                double resultado = Math.sqrt(num);
                pantalla.setText(String.valueOf(resultado));
            }
        }
        // Si es =
        else if (comando.equals("=")) {
            if (!pantalla.getText().isEmpty()) {
                double num2 = Double.parseDouble(pantalla.getText());
                double resultado = 0;
                switch (operador) {
                    case "+": resultado = num1 + num2; break;
                    case "-": resultado = num1 - num2; break;
                    case "*": resultado = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(this, "No se puede dividir entre 0");
                            return;
                        }
                        resultado = num1 / num2;
                        break;
                    case "^": // potencia
                        resultado = Math.pow(num1, num2);
                        break;
                }
                pantalla.setText(String.valueOf(resultado));
            }
        }
        // Si es C
        else if (comando.equals("C")) {
            pantalla.setText("");
            operador = "";
            num1 = 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjemploGUI7 calc = new EjemploGUI7();
            calc.setVisible(true);
        });
    }
}