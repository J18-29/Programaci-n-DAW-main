package Componentes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class NeonPanel extends JPanel {
    private Color bgColor = new Color(20, 20, 30);

    public NeonPanel(LayoutManager layout, String title, Color color) {
        super(layout);
        setBackground(bgColor);
        styleNeonBorder(this, title, color);
    }

    public NeonPanel(String title, Color color) {
        this(new FlowLayout(), title, color);
    }

    public void setNeonColor(String title, Color color) {
        styleNeonBorder(this, title, color);
    }

    public static void styleNeonBorder(JComponent component, String title, Color color) {
        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(color, 1),
                title,
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                color
        );
        component.setBorder(border);
    }
}
