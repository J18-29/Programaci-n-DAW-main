package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProveedorView extends JPanel {
    
    //Campos
    public JTextField txtCodigo= new JTextField(5);
    public JTextField txtDireccion= new JTextField(15);
    public JTextField txtCiudad= new JTextField(15);
    public JTextField txtProvincia= new JTextField(15);

    //Botones
    public JButton btnAgregar= new JButton("Agregar");
    public JButton btnModificar= new JButton("Modificar");
    public JButton btnEliminar= new JButton("Eliminar");
    public JButton btnLimpiar= new JButton("Limpiar");

    //Tabla
    public DefaultTableModel modeloTabla= new DefaultTableModel(new Object[]{"Código", "Nombre"}, 0);
    public JTable tabla= new JTable(modeloTabla);

    public ProveedorView(){

        setLayout(new BorderLayout());

        //====PANEL SUPERIOR====
        JPanel panelFormulario= new JPanel();
        panelFormulario.setBorder(
                     BorderFactory.createTitledBorder("Formulario de Proveedor"));
        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(txtCodigo);

        panelFormulario.add(new JLabel("Dirección:"));
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel("Ciudad:"));
        panelFormulario.add(txtCiudad);

        panelFormulario.add(new JLabel("Provincia:"));
        panelFormulario.add(txtProvincia);  

        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnModificar);
        panelFormulario.add(btnEliminar);
        panelFormulario.add(btnLimpiar);

        //====PANEL INFERIOR====
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(
                         BorderFactory.createTitledBorder("Lista de Categorías"));
        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
    
}
