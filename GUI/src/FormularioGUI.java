import javax.swing.*;      
import java.awt.*;         
import java.awt.event.*;   
import java.net.URL;       
import java.net.URI;       

// Clase que implementa ActionListener para manejar eventos de botones
public class FormularioGUI extends JFrame implements ActionListener {

    // ----------- DECLARACIÓN DE COMPONENTES -----------
    private JTextField tfNombre, tfTelefono, tfImagenURL;
    private JTextArea taDireccion, taDatos;
    private JRadioButton rbMasculino, rbFemenino;
    private ButtonGroup bgGenero;
    private JComboBox<String> cbDia, cbMes, cbAnio;
    private JCheckBox cbTerminos;
    private JButton btnEnviar, btnReiniciar;
    private JLabel lblImagen;

    // Fuentes reutilizables para mantener estilo uniforme
    private Font fuenteNormal = new Font("Arial", Font.PLAIN, 13);
    private Font fuenteNegrita = new Font("Arial", Font.BOLD, 13);

    // ----------- CONSTRUCTOR (CREA LA VENTANA) -----------
    public FormularioGUI() {

        setTitle("Registro de Usuarios");  // Título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar programa al salir
        setSize(850, 500);  // Tamaño de la ventana
        setLayout(new GridLayout(1, 2, 15, 15)); // Divide en 2 columnas

        // ----------- PANEL IZQUIERDO (FORMULARIO) -----------
        JPanel panelIzquierdo = new JPanel(new GridLayout(9, 2, 5, 10));
        panelIzquierdo.setBorder(
                BorderFactory.createTitledBorder(null, "Datos de Entrada", 0, 0, fuenteNegrita));

        // Campo Nombre
        panelIzquierdo.add(crearLabel("Nombre:"));
        tfNombre = new JTextField();
        tfNombre.setFont(fuenteNormal);
        panelIzquierdo.add(tfNombre);

        // Campo Teléfono
        panelIzquierdo.add(crearLabel("Teléfono:"));
        tfTelefono = new JTextField();
        tfTelefono.setFont(fuenteNormal);
        panelIzquierdo.add(tfTelefono);

        // Género con botones de opción
        panelIzquierdo.add(crearLabel("Género:"));
        JPanel pGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));

        rbMasculino = new JRadioButton("M");
        rbFemenino = new JRadioButton("F");

        rbMasculino.setFont(fuenteNormal);
        rbFemenino.setFont(fuenteNormal);

        // Agrupamos los radio buttons para que solo se pueda seleccionar uno
        bgGenero = new ButtonGroup();
        bgGenero.add(rbMasculino);
        bgGenero.add(rbFemenino);

        pGenero.add(rbMasculino);
        pGenero.add(rbFemenino);
        panelIzquierdo.add(pGenero);

        // Fecha de nacimiento con combos
        panelIzquierdo.add(crearLabel("Fecha Nac:"));
        JPanel pFecha = new JPanel(new FlowLayout(FlowLayout.LEFT));

        cbDia = new JComboBox<>();
        for(int i=1; i<=31; i++) cbDia.addItem(String.valueOf(i));

        cbMes = new JComboBox<>(new String[]{
                "Ene","Feb","Mar","Abr","May","Jun",
                "Jul","Ago","Sep","Oct","Nov","Dic"
        });

        cbAnio = new JComboBox<>();
        for(int i=1950; i<=2026; i++) cbAnio.addItem(String.valueOf(i));

        cbDia.setFont(fuenteNormal);
        cbMes.setFont(fuenteNormal);
        cbAnio.setFont(fuenteNormal);

        pFecha.add(cbDia);
        pFecha.add(cbMes);
        pFecha.add(cbAnio);
        panelIzquierdo.add(pFecha);

        // Dirección
        panelIzquierdo.add(crearLabel("Dirección:"));
        taDireccion = new JTextArea(2, 10);
        taDireccion.setFont(fuenteNormal);
        panelIzquierdo.add(new JScrollPane(taDireccion));

        // URL de imagen
        panelIzquierdo.add(crearLabel("URL Imagen:"));
        tfImagenURL = new JTextField();
        tfImagenURL.setFont(fuenteNormal);
        panelIzquierdo.add(tfImagenURL);

        // Checkbox términos
        panelIzquierdo.add(new JLabel(""));
        cbTerminos = new JCheckBox("Acepto términos");
        cbTerminos.setFont(fuenteNormal);
        panelIzquierdo.add(cbTerminos);

        // Botones
        btnEnviar = new JButton("Enviar Datos");
        btnReiniciar = new JButton("Limpiar");

        btnEnviar.setFont(fuenteNegrita);
        btnReiniciar.setFont(fuenteNegrita);

        // Asociamos los botones al ActionListener
        btnEnviar.addActionListener(this);
        btnReiniciar.addActionListener(this);

        panelIzquierdo.add(btnEnviar);
        panelIzquierdo.add(btnReiniciar);

        // ----------- PANEL DERECHO (RESULTADO) -----------
        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));
        panelDerecho.setBorder(
                BorderFactory.createTitledBorder(null, "Resultado", 0, 0, fuenteNegrita));

        // Etiqueta donde se mostrará la imagen
        lblImagen = new JLabel("La imagen aparecerá aquí", SwingConstants.CENTER);
        lblImagen.setFont(fuenteNormal);
        lblImagen.setPreferredSize(new Dimension(200, 200));
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Área donde se mostrarán los datos enviados
        taDatos = new JTextArea();
        taDatos.setEditable(false);
        taDatos.setFont(fuenteNormal);
        taDatos.setMargin(new Insets(10, 10, 10, 10));

        panelDerecho.add(lblImagen, BorderLayout.NORTH);
        panelDerecho.add(new JScrollPane(taDatos), BorderLayout.CENTER);

        add(panelIzquierdo);
        add(panelDerecho);

        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true); // Hace visible la ventana
    }

    // Método auxiliar para crear labels con misma fuente
    private JLabel crearLabel(String texto) {
        JLabel lb = new JLabel(texto);
        lb.setFont(fuenteNegrita);
        return lb;
    }

    // ----------- MANEJO DE EVENTOS -----------
    @Override
    public void actionPerformed(ActionEvent e) {

        // Si se pulsa Enviar
        if (e.getSource() == btnEnviar) {

            // Validamos que todos los campos estén completos
            if (!camposCompletos()) {
                JOptionPane.showMessageDialog(this,
                        "Debes rellenar todos los campos.",
                        "Campos incompletos",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validamos que se acepten los términos
            if (!cbTerminos.isSelected()) {
                JOptionPane.showMessageDialog(this,
                        "Debes aceptar los términos.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            procesarEnvio();
        }

        // Si se pulsa Limpiar
        else if (e.getSource() == btnReiniciar) {
            limpiarCampos();
        }
    }

    // Método que verifica que ningún campo esté vacío
    private boolean camposCompletos() {

        if (tfNombre.getText().trim().isEmpty()) return false;
        if (tfTelefono.getText().trim().isEmpty()) return false;
        if (taDireccion.getText().trim().isEmpty()) return false;
        if (tfImagenURL.getText().trim().isEmpty()) return false;

        if (!rbMasculino.isSelected() && !rbFemenino.isSelected()) return false;

        return true;
    }

    // Método que recoge los datos y los muestra en el panel derecho
    private void procesarEnvio() {

        String genero = rbMasculino.isSelected() ? "Masculino"
                : (rbFemenino.isSelected() ? "Femenino" : "No indicado");

        String textoResultado =
                "--- FICHA DE USUARIO ---\n\n" +
                "Nombre: " + tfNombre.getText() + "\n" +
                "Teléfono: " + tfTelefono.getText() + "\n" +
                "Género: " + genero + "\n" +
                "Nacimiento: " + cbDia.getSelectedItem() + "/" +
                cbMes.getSelectedItem() + "/" +
                cbAnio.getSelectedItem() + "\n" +
                "Dirección: " + taDireccion.getText();

        taDatos.setText(textoResultado);

        // Intentamos cargar la imagen desde la URL
        try {
            URL url = URI.create(tfImagenURL.getText()).toURL();
            ImageIcon icon = new ImageIcon(url);

            Image img = icon.getImage()
                    .getScaledInstance(250, 180, Image.SCALE_SMOOTH);

            lblImagen.setIcon(new ImageIcon(img));
            lblImagen.setText("");

        } catch (Exception ex) {
            lblImagen.setIcon(null);
            lblImagen.setText("URL de imagen no válida");
        }
    }

    // Método que limpia todos los campos del formulario
    private void limpiarCampos() {

        tfNombre.setText("");
        tfTelefono.setText("");
        tfImagenURL.setText("");
        taDireccion.setText("");
        taDatos.setText("");

        bgGenero.clearSelection();
        cbTerminos.setSelected(false);

        lblImagen.setIcon(null);
        lblImagen.setText("La imagen aparecerá aquí");
    }

    // Método principal que ejecuta el programa
    public static void main(String[] args) {
        new FormularioGUI();
    }
}