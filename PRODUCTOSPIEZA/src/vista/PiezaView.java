package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class PiezaView extends JPanel {
     //Campos
    public JTextField txtCodigo= new JTextField(5);
    public JTextField txtNombre= new JTextField(15);
    public JTextField txtColor= new JTextField(10);
    public JTextField txtPrecio= new JTextField(10);
    public JTextField txtCodCategoria= new JTextField(5);

    //Botones
    public JButton btnAgregar= new JButton("Agregar");
    public JButton btnModificar= new JButton("Modificar");
    public JButton btnEliminar= new JButton("Eliminar");
    public JButton btnLimpiar= new JButton("Limpiar");

    //Tabla
    
public DefaultTableModel modeloTabla = new DefaultTableModel(
    new Object[]{"Código", "Nombre", "Color", "Precio", "Código de Categoría"}, 0
) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; 
    }
};

public JTable tabla = new JTable(modeloTabla);

    public PiezaView(){

        setLayout(new BorderLayout());

        //====PANEL SUPERIOR====
        JPanel panelFormulario= new JPanel();
        panelFormulario.setBorder(
                     BorderFactory.createTitledBorder("Formulario de Pieza"));
        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(txtCodigo);

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Color:"));
        panelFormulario.add(txtColor);

        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Código de Categoría:"));
        panelFormulario.add(txtCodCategoria);

        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnModificar);
        panelFormulario.add(btnEliminar);
        panelFormulario.add(btnLimpiar);

        //====PANEL INFERIOR====
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(
                         BorderFactory.createTitledBorder("Lista de Piezas"));
        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
    
}
