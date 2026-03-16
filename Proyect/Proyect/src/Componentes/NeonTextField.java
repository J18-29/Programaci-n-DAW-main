package Componentes;

import javax.swing.*;
import java.awt.*;

public class NeonTextField extends JTextField {
    private Color neonColor = new Color(0, 255, 255); // Default Cyan

    public NeonTextField(int columns) {
        super(columns);
        initNeonStyle();
    }

    public NeonTextField(String text) {
        super(text);
        initNeonStyle();
    }

    public NeonTextField(int columns, Color color) {
        super(columns);
        this.neonColor = color;
        initNeonStyle();
    }

    private void initNeonStyle() {
        setBackground(new Color(30, 30, 45));
        setForeground(neonColor);
        setCaretColor(neonColor);
        setFont(new Font("Consolas", Font.PLAIN, 14));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 60, 80), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    public void setNeonColor(Color color) {
        this.neonColor = color;
        setForeground(color);
        setCaretColor(color);
    }
}
