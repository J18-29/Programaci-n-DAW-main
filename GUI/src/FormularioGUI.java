import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class FormularioGUI extends JFrame implements ActionListener {

    private JTextField tfNombre, tfTelefono, tfImagenURL;
    private JTextArea taDireccion, taDatos;
    private JRadioButton rbMasculino, rbFemenino;
    private ButtonGroup bgGenero;
    private JComboBox<String> cbDia, cbMes, cbAnio;
    private JCheckBox cbTerminos;
    private JButton btnEnviar, btnReiniciar;
    private JLabel lblImagen;
    
    // Definimos la fuente Arial para reutilizarla
    private Font fuenteNormal = new Font("Arial", Font.PLAIN, 13);
    private Font fuenteNegrita = new Font("Arial", Font.BOLD, 13);

    public FormularioGUI() {
        setTitle("Registro de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        setLayout(new GridLayout(1, 2, 15, 15));

        // --- PANEL IZQUIERDO (FORMULARIO) ---
        JPanel panelIzquierdo = new JPanel(new GridLayout(9, 2, 5, 10));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder(null, "Datos de Entrada", 0, 0, fuenteNegrita));

        // Metodo auxiliar para añadir etiquetas con Arial
        panelIzquierdo.add(crearLabel("Nombre:"));
        tfNombre = new JTextField();
        tfNombre.setFont(fuenteNormal);
        panelIzquierdo.add(tfNombre);

        panelIzquierdo.add(crearLabel("Teléfono:"));
        tfTelefono = new JTextField();
        tfTelefono.setFont(fuenteNormal);
        panelIzquierdo.add(tfTelefono);

        panelIzquierdo.add(crearLabel("Género:"));
        JPanel pGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbMasculino = new JRadioButton("M");
        rbFemenino = new JRadioButton("F");
        rbMasculino.setFont(fuenteNormal);
        rbFemenino.setFont(fuenteNormal);
        bgGenero = new ButtonGroup();
        bgGenero.add(rbMasculino); bgGenero.add(rbFemenino);
        pGenero.add(rbMasculino); pGenero.add(rbFemenino);
        panelIzquierdo.add(pGenero);

        panelIzquierdo.add(crearLabel("Fecha Nac:"));
        JPanel pFecha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cbDia = new JComboBox<>(); for(int i=1; i<=31; i++) cbDia.addItem(String.valueOf(i));
        cbMes = new JComboBox<>(new String[]{"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"});
        cbAnio = new JComboBox<>(); for(int i=1950; i<=2026; i++) cbAnio.addItem(String.valueOf(i));
        
        // Aplicar fuente a los combos
        cbDia.setFont(fuenteNormal); cbMes.setFont(fuenteNormal); cbAnio.setFont(fuenteNormal);
        
        pFecha.add(cbDia); pFecha.add(cbMes); pFecha.add(cbAnio);
        panelIzquierdo.add(pFecha);

        panelIzquierdo.add(crearLabel("Dirección:"));
        taDireccion = new JTextArea(2, 10);
        taDireccion.setFont(fuenteNormal);
        panelIzquierdo.add(new JScrollPane(taDireccion));

        panelIzquierdo.add(crearLabel("URL Imagen:"));
        tfImagenURL = new JTextField();
        tfImagenURL.setFont(fuenteNormal);
        panelIzquierdo.add(tfImagenURL);

        panelIzquierdo.add(new JLabel(""));
        cbTerminos = new JCheckBox("Acepto términos");
        cbTerminos.setFont(fuenteNormal);
        panelIzquierdo.add(cbTerminos);

        btnEnviar = new JButton("Enviar Datos");
        btnReiniciar = new JButton("Limpiar");
        btnEnviar.setFont(fuenteNegrita);
        btnReiniciar.setFont(fuenteNegrita);
        btnEnviar.addActionListener(this);
        btnReiniciar.addActionListener(this);
        panelIzquierdo.add(btnEnviar);
        panelIzquierdo.add(btnReiniciar);

        // --- PANEL DERECHO (VISUALIZACIÓN) ---
        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));
        panelDerecho.setBorder(BorderFactory.createTitledBorder(null, "Resultado", 0, 0, fuenteNegrita));

        lblImagen = new JLabel("La imagen aparecerá aquí", SwingConstants.CENTER);
        lblImagen.setFont(fuenteNormal);
        lblImagen.setPreferredSize(new Dimension(200, 200));
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        taDatos = new JTextArea();
        taDatos.setEditable(false);
        taDatos.setFont(fuenteNormal); // Aquí cambiamos de Monospaced a Arial normal
        taDatos.setMargin(new Insets(10, 10, 10, 10)); // Margen interno para que no pegue al borde

        panelDerecho.add(lblImagen, BorderLayout.NORTH);
        panelDerecho.add(new JScrollPane(taDatos), BorderLayout.CENTER);

        add(panelIzquierdo);
        add(panelDerecho);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Método simple para no repetir código de fuentes en los labels
    private JLabel crearLabel(String texto) {
        JLabel lb = new JLabel(texto);
        lb.setFont(fuenteNegrita);
        return lb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnviar) {
            if (!cbTerminos.isSelected()) {
                JOptionPane.showMessageDialog(this, "Debes aceptar los términos.");
                return;
            }
            procesarEnvio();
        } else if (e.getSource() == btnReiniciar) {
            limpiarCampos();
        }
    }

    private void procesarEnvio() {
        String genero = rbMasculino.isSelected() ? "Masculino" : (rbFemenino.isSelected() ? "Femenino" : "No indicado");
        
        String textoResultado = "--- FICHA DE USUARIO ---\n\n" +
                                "Nombre: " + tfNombre.getText() + "\n" +
                                "Teléfono: " + tfTelefono.getText() + "\n" +
                                "Género: " + genero + "\n" +
                                "Nacimiento: " + cbDia.getSelectedItem() + "/" + cbMes.getSelectedItem() + "/" + cbAnio.getSelectedItem() + "\n" +
                                "Dirección: " + taDireccion.getText();
        
        taDatos.setText(textoResultado);

        try {
            URL url = new URL(tfImagenURL.getText());
            ImageIcon icon = new ImageIcon(url);
            // Redimensionar para que se vea como en tu imagen
            Image img = icon.getImage().getScaledInstance(250, 180, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
            lblImagen.setText("");
        } catch (Exception ex) {
            lblImagen.setIcon(null);
            lblImagen.setText("URL de imagen no válida");
        }
    }

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

    public static void main(String[] args) {
        new FormularioGUI();
    }
}