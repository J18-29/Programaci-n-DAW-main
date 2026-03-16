package VIEWS;

import Componentes.NeonButton;
import Componentes.NeonLabel;
import Componentes.NeonPanel;
import Componentes.NeonTable;
import Componentes.NeonTextField;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AutorVIEW extends JPanel {
    // Colores del tema Neon/Cyberpunk
    private final Color COLOR_BG = new Color(13, 13, 20);
    private final Color COLOR_PANEL_BG = new Color(20, 20, 30);
    private final Color COLOR_NEON_CYAN = new Color(0, 255, 255);
    private final Color COLOR_NEON_MAGENTA = new Color(255, 0, 255);

    // Campos de texto personalizados con estilo Neon
    public NeonTextField txtId = new NeonTextField(5);
    public NeonTextField txtNombre = new NeonTextField(15);
    public NeonTextField txtTelefono = new NeonTextField(15);

    // Botones con efectos de iluminación Neon
    public NeonButton btnInsertar = new NeonButton("Insertar", COLOR_NEON_CYAN);
    public NeonButton btnActualizar = new NeonButton("Actualizar", COLOR_NEON_MAGENTA);
    public NeonButton btnEliminar = new NeonButton("Eliminar", new Color(255, 50, 50));
    public NeonButton btnLimpiar = new NeonButton("Limpiar", Color.GRAY);

    // Modelo y Tabla estilizada
    public DefaultTableModel modeloTabla = new DefaultTableModel(
            new Object[]{"ID", "Nombre", "Teléfono"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public NeonTable tabla = new NeonTable(modeloTabla);

    public AutorVIEW() {
        // Configuración básica del panel principal
        setBackground(COLOR_BG);
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ====== PANEL DE FORMULARIO (GRID) ======
        // Usamos GridBagLayout para alinear etiquetas y campos perfectamente
        NeonPanel panelFormulario = new NeonPanel(new GridBagLayout(), "DATOS AUTOR", COLOR_NEON_CYAN);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: Campo ID
        gbc.gridy = 0; 
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtId, gbc);

        // Fila 1: Campo Nombre
        gbc.gridy = 1;
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtNombre, gbc);

        // Fila 2: Campo Teléfono
        gbc.gridy = 2;
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Teléfono:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtTelefono, gbc);

        // ====== PANEL DE ACCIONES (BOTONES) ======
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotones.setBackground(COLOR_BG);
        panelBotones.add(btnInsertar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        // ====== PANEL DE DATOS (TABLA) ======
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.getViewport().setBackground(COLOR_PANEL_BG);
        scroll.setBackground(COLOR_PANEL_BG);
        
        // Aplicar borde Neon al scroll de la tabla
        NeonPanel.styleNeonBorder(scroll, "LISTA AUTORES", COLOR_NEON_MAGENTA);

        // Contenedor Norte: Agrupa el formulario y los botones
        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.setBackground(COLOR_BG);
        panelNorte.add(panelFormulario, BorderLayout.NORTH);
        panelNorte.add(panelBotones, BorderLayout.SOUTH);

        // Ensamblado final en el panel principal
        add(panelNorte, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }










}
