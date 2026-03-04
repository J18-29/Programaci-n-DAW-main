package controlador;

import javax.swing.JOptionPane;
import vista.ProveedorView;

public class ProveedorController {

    private ProveedorView view;

    public ProveedorController(ProveedorView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.btnAgregar.addActionListener(e -> agregar());
        view.btnModificar.addActionListener(e -> modificar());
        view.btnEliminar.addActionListener(e -> eliminar());
        view.btnLimpiar.addActionListener(e -> limpiar());

        view.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) seleccionarFila();
        });
    }

    // ===== Agregar fila =====
    private void agregar() {
        try {
            if (view.txtCodigo.getText().isEmpty() ||
                view.txtDireccion.getText().isEmpty() ||
                view.txtCiudad.getText().isEmpty() ||
                view.txtProvincia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Complete todos los campos");
                return;
            }

            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String direccion = view.txtDireccion.getText();
            String ciudad = view.txtCiudad.getText();
            String provincia = view.txtProvincia.getText();

            view.modeloTabla.addRow(new Object[]{codigo, direccion, ciudad, provincia});
            limpiar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Código inválido");
        }
    }

    // ===== Modificar fila seleccionada =====
    private void modificar() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una fila para modificar");
            return;
        }

        try {
            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String direccion = view.txtDireccion.getText();
            String ciudad = view.txtCiudad.getText();
            String provincia = view.txtProvincia.getText();

            view.modeloTabla.setValueAt(codigo, fila, 0);
            view.modeloTabla.setValueAt(direccion, fila, 1);
            view.modeloTabla.setValueAt(ciudad, fila, 2);
            view.modeloTabla.setValueAt(provincia, fila, 3);

            limpiar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Código inválido");
        }
    }

    // ===== Eliminar fila seleccionada =====
    private void eliminar() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una fila para eliminar");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(view, "¿Desea eliminar este proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            view.modeloTabla.removeRow(fila);
            limpiar();
        }
    }

    // ===== Seleccionar fila =====
    private void seleccionarFila() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;

        view.txtCodigo.setText(view.modeloTabla.getValueAt(fila, 0).toString());
        view.txtDireccion.setText(view.modeloTabla.getValueAt(fila, 1).toString());
        view.txtCiudad.setText(view.modeloTabla.getValueAt(fila, 2).toString());
        view.txtProvincia.setText(view.modeloTabla.getValueAt(fila, 3).toString());
    }

    // ===== Limpiar campos =====
    private void limpiar() {
        view.txtCodigo.setText("");
        view.txtDireccion.setText("");
        view.txtCiudad.setText("");
        view.txtProvincia.setText("");
        view.tabla.clearSelection();
    }
}