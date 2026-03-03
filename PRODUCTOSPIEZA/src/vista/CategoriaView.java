package vista;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CategoriaView extends JPanel {

    //Campos
    public JTextField txtCodigo= new JTextField();
    public JTextField txtNombre= new JTextField();

    //Botones
    public JButton btnAgregar= new JButton("Agregar");
    public JButton btnModificar= new JButton("Modificar");
    public JButton btnEliminar= new JButton("Eliminar");
    public JButton btnLimpiar= new JButton("Limpiar");

    //Tabla
    public DefaultTableModel modeloTabla= new DefaultTableModel(new Object[]{"Código", "Nombre"}, 0);
    public JTable tabla= new JTable(modeloTabla);

    public CategoriaView(){

        setLayout(new BorderLayout());

        //====PANEL SUPERIOR====
        JPanel panelFormulario= new JPanel();
        panelFormulario.setBorder(
                     BorderFactory.createTitledBorder("Formulario de Categoría"));
        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(txtCodigo);

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);

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
