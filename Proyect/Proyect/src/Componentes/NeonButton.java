package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NeonButton extends JButton {
    private Color neonColor;
    private Color originalBg = new Color(40, 40, 60);

    public NeonButton(String text, Color color) {
        super(text);
        this.neonColor = color;
        initNeonStyle();
    }

    private void initNeonStyle() {
        setFont(new Font("Segoe UI", Font.BOLD, 13));
        setForeground(Color.WHITE);
        setBackground(originalBg);
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(neonColor, 2));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(neonColor);
                setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalBg);
                setForeground(Color.WHITE);
            }
        });
    }

    public void setNeonColor(Color color) {
        this.neonColor = color;
        setBorder(BorderFactory.createLineBorder(color, 2));
    }
}
