package Componentes;

import javax.swing.*;
import java.awt.*;

public class NeonLabel extends JLabel {
    public NeonLabel(String text) {
        super(text);
        setForeground(new Color(230, 230, 250)); // COLOR_TEXT
        setFont(new Font("Segoe UI", Font.BOLD, 12));
    }

    public NeonLabel(String text, Color color) {
        super(text);
        setForeground(color);
        setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
}
