package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class SuministraView extends JPanel {
    // Campos
    public JTextField txtCodProveedor= new JTextField(5);
    public JTextField txtCodPieza= new JTextField(15);
    public JTextField txtCantidad= new JTextField(5);
    public JTextField txtFecha= new JTextField(10);

    // Botones
    public JButton btnAgregar= new JButton("Agregar");
    public JButton btnModificar= new JButton("Modificar");
    public JButton btnEliminar= new JButton("Eliminar");
    public JButton btnLimpiar= new JButton("Limpiar");

    // Tabla
    public DefaultTableModel modeloTabla = new DefaultTableModel(
        new Object[]{"Código Proveedor", "Código Pieza", "Cantidad", "Fecha"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public JTable tabla = new JTable(modeloTabla);

    public SuministraView() {

        setLayout(new BorderLayout());

        //====PANEL SUPERIOR====
        JPanel panelFormulario= new JPanel();
        panelFormulario.setBorder(
                     BorderFactory.createTitledBorder("Formulario de Suministra"));

        panelFormulario.add(new JLabel("Código Proveedor:"));
        panelFormulario.add(txtCodProveedor);

        panelFormulario.add(new JLabel("Código Pieza:"));
        panelFormulario.add(txtCodPieza);

        panelFormulario.add(new JLabel("Cantidad:"));
        panelFormulario.add(txtCantidad);

        panelFormulario.add(new JLabel("Fecha (MM-DD-AAAA):"));
        panelFormulario.add(txtFecha);

        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnModificar);
        panelFormulario.add(btnEliminar);
        panelFormulario.add(btnLimpiar);

        //====PANEL INFERIOR====
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(
                         BorderFactory.createTitledBorder("Lista de Suministros"));
        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}