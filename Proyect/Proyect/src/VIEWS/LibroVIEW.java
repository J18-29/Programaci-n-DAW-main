package VIEWS;

import Componentes.NeonButton;
import Componentes.NeonLabel;
import Componentes.NeonPanel;
import Componentes.NeonTable;
import Componentes.NeonTextField;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LibroVIEW extends JPanel {
    // Colores del tema Neon/Cyberpunk
    private final Color COLOR_BG = new Color(13, 13, 20);
    private final Color COLOR_PANEL_BG = new Color(20, 20, 30);
    private final Color COLOR_NEON_CYAN = new Color(0, 255, 255);
    private final Color COLOR_NEON_MAGENTA = new Color(255, 0, 255);
    private final Color COLOR_TEXT = new Color(230, 230, 250);

    // ====== Campos de libro estilizados ======
    public NeonTextField txtId = new NeonTextField(5);
    public NeonTextField txtTitulo = new NeonTextField(15);
    public NeonTextField txtIsbn = new NeonTextField(15);
    public NeonTextField txtAnio = new NeonTextField(5);
    public NeonTextField txtDescripcion = new NeonTextField(20);
    public NeonTextField txtUrl = new NeonTextField(25);
    public NeonTextField txtIdAutor = new NeonTextField(5);
    public JLabel lblImagen = new JLabel();

    // ====== Botones con borde Neon ======
    public NeonButton btnInsertar = new NeonButton("Insertar", COLOR_NEON_CYAN);
    public NeonButton btnActualizar = new NeonButton("Actualizar", COLOR_NEON_MAGENTA);
    public NeonButton btnEliminar = new NeonButton("Eliminar", new Color(255, 50, 50));
    public NeonButton btnLimpiar = new NeonButton("Limpiar", Color.GRAY);

    // ====== Tabla de datos personalizada ======
    public DefaultTableModel modeloTabla = new DefaultTableModel(
            new Object[] { "ID", "Título", "ISBN", "Año", "Descripción", "URL", "ID Autor" }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public NeonTable tabla = new NeonTable(modeloTabla);

    public LibroVIEW() {
        // Configuración estética general
        setBackground(COLOR_BG);
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ====== PANEL DE FORMULARIO (GRID ESTRUCTURADO) ======
        NeonPanel panelFormulario = new NeonPanel(new GridBagLayout(), "DATOS DEL LIBRO", COLOR_NEON_CYAN);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: ID y Título
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        panelFormulario.add(new NeonLabel("ID:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelFormulario.add(txtId, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0.0;
        panelFormulario.add(new NeonLabel("Título:"), gbc);
        gbc.gridx = 3;
        gbc.weightx = 1.0;
        panelFormulario.add(txtTitulo, gbc);

        // Fila 1: ISBN y Año
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        panelFormulario.add(new NeonLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelFormulario.add(txtIsbn, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0.0;
        panelFormulario.add(new NeonLabel("Año:"), gbc);
        gbc.gridx = 3;
        gbc.weightx = 1.0;
        panelFormulario.add(txtAnio, gbc);

        // Fila 2: Autor ID y URL Libro
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        panelFormulario.add(new NeonLabel("Autor ID:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelFormulario.add(txtIdAutor, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0.0;
        panelFormulario.add(new NeonLabel("URL Libro:"), gbc);
        gbc.gridx = 3;
        gbc.weightx = 1.0;
        panelFormulario.add(txtUrl, gbc);

        // Fila 3: Descripción (Cubre todo el ancho)
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        gbc.gridwidth = 1;
        panelFormulario.add(new NeonLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = 3;
        panelFormulario.add(txtDescripcion, gbc);

        // ====== PANEL DE VISTA PREVIA (DERECHA) ======
        JPanel panelImagen = new JPanel(new BorderLayout(5, 5));
        panelImagen.setOpaque(false);
        panelImagen.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        // Marco para la previsualización de la imagen
        lblImagen.setPreferredSize(new Dimension(160, 200));
        lblImagen.setBorder(BorderFactory.createLineBorder(COLOR_NEON_CYAN, 1));
        lblImagen.setHorizontalAlignment(JLabel.CENTER);
        lblImagen.setForeground(COLOR_TEXT);
        lblImagen.setText("PREVIEW");

        // Etiqueta de título con estilo Neon
        NeonLabel lblTituloPreview = new NeonLabel("VISTA PREVIA", COLOR_NEON_CYAN);
        lblTituloPreview.setHorizontalAlignment(JLabel.CENTER);

        panelImagen.add(lblTituloPreview, BorderLayout.NORTH);
        panelImagen.add(lblImagen, BorderLayout.CENTER);

        // Contenedor unificado para Formulario e Imagen
        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.setOpaque(false);
        panelInfo.add(panelFormulario, BorderLayout.CENTER);
        panelInfo.add(panelImagen, BorderLayout.EAST);

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

        // Borde Neon para el contenedor de la tabla
        NeonPanel.styleNeonBorder(scroll, "LISTA DE LIBROS", COLOR_NEON_MAGENTA);

        // Contenedor Norte: Información + Botones
        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.setBackground(COLOR_BG);
        panelNorte.add(panelInfo, BorderLayout.CENTER);
        panelNorte.add(panelBotones, BorderLayout.SOUTH);

        // Ensamblado en el panel principal
        add(panelNorte, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

}