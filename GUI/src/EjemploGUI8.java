import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EjemploGUI8 extends JFrame implements ActionListener {

    private JButton[][] botones = new JButton[3][3];
    private boolean turnoX = true; // true = X, false = O

    public EjemploGUI8() {
        setTitle("3 en Raya");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 3));

        inicializarBotones();
        setVisible(true);
    }

    private void inicializarBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton("");
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                botones[i][j].addActionListener(this);
                add(botones[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        // Ignorar si ya hay X u O
        if (!btn.getText().isEmpty()) return;

        btn.setText(turnoX ? "X" : "O");
        turnoX = !turnoX;

        if (hayGanador()) {
            JOptionPane.showMessageDialog(this, "¡Hay ganador!");
            reiniciar();
        } else if (tableroLleno()) {
            JOptionPane.showMessageDialog(this, "Empate");
            reiniciar();
        }
    }

    private boolean hayGanador() {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (!botones[i][0].getText().isEmpty() &&
                botones[i][0].getText().equals(botones[i][1].getText()) &&
                botones[i][0].getText().equals(botones[i][2].getText())) {
                return true;
            }
        }
        // Columnas
        for (int j = 0; j < 3; j++) {
            if (!botones[0][j].getText().isEmpty() &&
                botones[0][j].getText().equals(botones[1][j].getText()) &&
                botones[0][j].getText().equals(botones[2][j].getText())) {
                return true;
            }
        }
        // Diagonales
        if (!botones[0][0].getText().isEmpty() &&
            botones[0][0].getText().equals(botones[1][1].getText()) &&
            botones[0][0].getText().equals(botones[2][2].getText())) {
            return true;
        }
        if (!botones[0][2].getText().isEmpty() &&
            botones[0][2].getText().equals(botones[1][1].getText()) &&
            botones[0][2].getText().equals(botones[2][0].getText())) {
            return true;
        }
        return false;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (botones[i][j].getText().isEmpty()) return false;
        return true;
    }

    private void reiniciar() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                botones[i][j].setText("");
        turnoX = true;
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EjemploGUI8());
    }
}