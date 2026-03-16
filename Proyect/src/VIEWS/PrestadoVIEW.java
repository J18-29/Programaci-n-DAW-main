package VIEWS;

import Componentes.NeonButton;
import Componentes.NeonLabel;
import Componentes.NeonPanel;
import Componentes.NeonTable;
import Componentes.NeonTextField;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrestadoVIEW extends JPanel {
    // Colores del tema Neon/Cyberpunk
    private final Color COLOR_BG = new Color(13, 13, 20);
    private final Color COLOR_PANEL_BG = new Color(20, 20, 30);
    private final Color COLOR_NEON_CYAN = new Color(0, 255, 255);
    private final Color COLOR_NEON_MAGENTA = new Color(255, 0, 255);

    // ====== Campos estilizados para préstamos ======
    public NeonTextField txtIdLibro = new NeonTextField(10);
    public NeonTextField txtCodigoUsuario = new NeonTextField(10);

    // ====== Botones con iluminación Neon ======
    public NeonButton btnInsertar = new NeonButton("Insertar", COLOR_NEON_CYAN);
    public NeonButton btnActualizar = new NeonButton("Actualizar", COLOR_NEON_MAGENTA);
    public NeonButton btnEliminar = new NeonButton("Eliminar", new Color(255, 50, 50));
    public NeonButton btnLimpiar = new NeonButton("Limpiar", Color.GRAY);

    // ====== Tabla de préstamos personalizada ======
    public DefaultTableModel modeloTabla = new DefaultTableModel(
            new Object[]{"ID Libro", "Código Usuario"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
    };
    public NeonTable tabla = new NeonTable(modeloTabla);

    public PrestadoVIEW() {
        // Configuración estética general
        setBackground(COLOR_BG);
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ====== PANEL DE FORMULARIO (GRID) ======
        NeonPanel panelFormulario = new NeonPanel(new GridBagLayout(), "DATOS PRESTADO", COLOR_NEON_CYAN);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: ID Libro
        gbc.gridy = 0; 
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("ID Libro:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtIdLibro, gbc);

        // Fila 1: Código Usuario
        gbc.gridy = 1;
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Código Usuario:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtCodigoUsuario, gbc);

        // ====== PANEL DE ACCIONES (BOTONES) ======
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(COLOR_BG);
        panelBotones.add(btnInsertar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        // ====== PANEL DE DATOS (TABLA) ======
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.getViewport().setBackground(COLOR_PANEL_BG);
        scroll.setBackground(COLOR_PANEL_BG);
        
        // Aplicar borde Neon al contenedor de la tabla
        NeonPanel.styleNeonBorder(scroll, "LISTA DE PRESTADOS", COLOR_NEON_MAGENTA);

        // Contenedor Norte: Información y Botones
        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.setBackground(COLOR_BG);
        panelNorte.add(panelFormulario, BorderLayout.NORTH);
        panelNorte.add(panelBotones, BorderLayout.SOUTH);

        // Ensamblado final
        add(panelNorte, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}