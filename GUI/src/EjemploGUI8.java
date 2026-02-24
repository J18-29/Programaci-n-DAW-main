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

    
    if (!btn.getText().isEmpty()) return;

    btn.setText(turnoX ? "X" : "O");

    String ganador = obtenerGanador();
    if (!ganador.isEmpty()) {
        if (ganador.equals("X")) {
            JOptionPane.showMessageDialog(this, "¡Ha ganado el usuario!");
        } else {
            JOptionPane.showMessageDialog(this, "¡Ha ganado la IA!");
        }
        reiniciar();
        return;
    } else if (tableroLleno()) {
        JOptionPane.showMessageDialog(this, "Empate");
        reiniciar();
        return;
    }

    turnoX = !turnoX;

    // Turno de IA si es O
    if (!turnoX) {
        jugadaIA();

        ganador = obtenerGanador();
        if (!ganador.isEmpty()) {
            if (ganador.equals("X")) {
                JOptionPane.showMessageDialog(this, "¡Ha ganado el usuario!");
            } else {
                JOptionPane.showMessageDialog(this, "¡Ha ganado la IA!");
            }
            reiniciar();
            return;
        } else if (tableroLleno()) {
            JOptionPane.showMessageDialog(this, "Empate");
            reiniciar();
            return;
        }

        turnoX = !turnoX; 
    }
}

private String obtenerGanador() {
    // Filas
    for (int i = 0; i < 3; i++) {
        if (!botones[i][0].getText().isEmpty() &&
            botones[i][0].getText().equals(botones[i][1].getText()) &&
            botones[i][0].getText().equals(botones[i][2].getText())) {
            return botones[i][0].getText();
        }
    }
    // Columnas
    for (int j = 0; j < 3; j++) {
        if (!botones[0][j].getText().isEmpty() &&
            botones[0][j].getText().equals(botones[1][j].getText()) &&
            botones[0][j].getText().equals(botones[2][j].getText())) {
            return botones[0][j].getText();
        }
    }
    // Diagonales
    if (!botones[0][0].getText().isEmpty() &&
        botones[0][0].getText().equals(botones[1][1].getText()) &&
        botones[0][0].getText().equals(botones[2][2].getText())) {
        return botones[0][0].getText();
    }
    if (!botones[0][2].getText().isEmpty() &&
        botones[0][2].getText().equals(botones[1][1].getText()) &&
        botones[0][2].getText().equals(botones[2][0].getText())) {
        return botones[0][2].getText();
    }
    return ""; // nadie ganó
}

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (botones[i][j].getText().isEmpty()) return false;
        return true;
    }
    private void jugadaIA() {
    // IA elige una casilla vacía al azar
    java.util.List<JButton> vacios = new java.util.ArrayList<>();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (botones[i][j].getText().isEmpty()) {
                vacios.add(botones[i][j]);
            }
        }
    }

    if (!vacios.isEmpty()) {
        int indice = (int) (Math.random() * vacios.size());
        vacios.get(indice).setText("O");
    }
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