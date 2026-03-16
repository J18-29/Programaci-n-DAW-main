package VIEWS;

import Componentes.NeonButton;
import Componentes.NeonLabel;
import Componentes.NeonPanel;
import Componentes.NeonTable;
import Componentes.NeonTextField;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UsuarioVIEW extends JPanel {
    // Colores del tema Neon/Cyberpunk
    private final Color COLOR_BG = new Color(13, 13, 20);
    private final Color COLOR_PANEL_BG = new Color(20, 20, 30);
    private final Color COLOR_NEON_CYAN = new Color(0, 255, 255);
    private final Color COLOR_NEON_MAGENTA = new Color(255, 0, 255);

    // ====== Campos de usuario estilizados ======
    public NeonTextField txtCodigo = new NeonTextField(5);
    public NeonTextField txtTelefono = new NeonTextField(10);
    public NeonTextField txtNombre = new NeonTextField(15);
    public NeonTextField txtApellido1 = new NeonTextField(15);
    public NeonTextField txtApellido2 = new NeonTextField(15);
    public NeonTextField txtSexo = new NeonTextField(5);
    public NeonTextField txtFechaNacimiento = new NeonTextField(10);

    // ====== Botones con efecto Neon ======
    public NeonButton btnInsertar = new NeonButton("Insertar", COLOR_NEON_CYAN);
    public NeonButton btnActualizar = new NeonButton("Actualizar", COLOR_NEON_MAGENTA);
    public NeonButton btnEliminar = new NeonButton("Eliminar", new Color(255, 50, 50));
    public NeonButton btnLimpiar = new NeonButton("Limpiar", Color.GRAY);

    // ====== Tabla de usuarios personalizada ======
    public DefaultTableModel modeloTabla =
            new DefaultTableModel(new Object[]{"Código", "Teléfono", "Nombre", "Apellido1", "Apellido2", "Sexo", "Fecha Nacimiento"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
    };
    public NeonTable tabla = new NeonTable(modeloTabla);

    public UsuarioVIEW() {
        // Configuración estética general
        setBackground(COLOR_BG);
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ====== PANEL DE FORMULARIO (GRID ESTRUCTURADO) ======
        NeonPanel panelFormulario = new NeonPanel(new GridBagLayout(), "DATOS USUARIO", COLOR_NEON_CYAN);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: Código y Teléfono
        gbc.gridy = 0;
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Código:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtCodigo, gbc);
        gbc.gridx = 2; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Teléfono:"), gbc);
        gbc.gridx = 3; gbc.weightx = 1.0; panelFormulario.add(txtTelefono, gbc);

        // Fila 1: Nombre y Apellido1
        gbc.gridy = 1;
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtNombre, gbc);
        gbc.gridx = 2; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Apellido 1:"), gbc);
        gbc.gridx = 3; gbc.weightx = 1.0; panelFormulario.add(txtApellido1, gbc);

        // Fila 2: Apellido2 y Sexo
        gbc.gridy = 2;
        gbc.gridx = 0; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Apellido 2:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelFormulario.add(txtApellido2, gbc);
        gbc.gridx = 2; gbc.weightx = 0.0; panelFormulario.add(new NeonLabel("Sexo:"), gbc);
        gbc.gridx = 3; gbc.weightx = 1.0; panelFormulario.add(txtSexo, gbc);

        // Fila 3: Fecha Nacimiento (Ocupa todo el ancho)
        gbc.gridy = 3;
        gbc.gridx = 0; gbc.weightx = 0.0; gbc.gridwidth = 1; 
        panelFormulario.add(new NeonLabel("Fecha Nac. (yyyy-MM-dd):"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; gbc.gridwidth = 3; 
        panelFormulario.add(txtFechaNacimiento, gbc);

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
        NeonPanel.styleNeonBorder(scroll, "LISTA USUARIOS", COLOR_NEON_MAGENTA);

        // Contenedor Norte: Organiza formulario y botones
        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.setBackground(COLOR_BG);
        panelNorte.add(panelFormulario, BorderLayout.CENTER);
        panelNorte.add(panelBotones, BorderLayout.SOUTH);

        // Añadir todo al panel principal
        add(panelNorte, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}