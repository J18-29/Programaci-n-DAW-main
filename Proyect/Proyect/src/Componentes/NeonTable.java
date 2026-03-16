package Componentes;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class NeonTable extends JTable {
    private final Color COLOR_PANEL_BG = new Color(20, 20, 30);
    private final Color COLOR_NEON_CYAN = new Color(0, 255, 255);
    private final Color COLOR_NEON_MAGENTA = new Color(255, 0, 255);
    private final Color COLOR_TEXT = new Color(230, 230, 250);

    public NeonTable(DefaultTableModel model) {
        super(model);
        initNeonStyle();
    }

    private void initNeonStyle() {
        setBackground(COLOR_PANEL_BG);
        setForeground(COLOR_TEXT);
        setGridColor(new Color(50, 50, 70));
        setRowHeight(30);
        setFont(new Font("Segoe UI", Font.PLAIN, 13));
        setSelectionBackground(COLOR_NEON_CYAN);
        setSelectionForeground(Color.BLACK);
        setShowGrid(true);
        setIntercellSpacing(new Dimension(1, 1));

        // Style Header
        JTableHeader header = getTableHeader();
        header.setBackground(new Color(30, 30, 45));
        header.setForeground(COLOR_NEON_MAGENTA);
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 70)));

        // Center align contents
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setBackground(COLOR_PANEL_BG);
        setDefaultRenderer(Object.class, centerRenderer);
    }
}
