package controlador;

import javax.swing.JOptionPane;
import vista.SuministraView;

public class SuministraController {

    private SuministraView view;

    public SuministraController(SuministraView view) {
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
            if (view.txtCodProveedor.getText().isEmpty() ||
                view.txtCodPieza.getText().isEmpty() ||
                view.txtCantidad.getText().isEmpty() ||
                view.txtFecha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Complete todos los campos");
                return;
            }

            int codProveedor = Integer.parseInt(view.txtCodProveedor.getText());
            int codPieza = Integer.parseInt(view.txtCodPieza.getText());
            int cantidad = Integer.parseInt(view.txtCantidad.getText());
            String fecha = view.txtFecha.getText();

            view.modeloTabla.addRow(new Object[]{codProveedor, codPieza, cantidad, fecha});
            limpiar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Revise los campos numéricos");
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
            int codProveedor = Integer.parseInt(view.txtCodProveedor.getText());
            int codPieza = Integer.parseInt(view.txtCodPieza.getText());
            int cantidad = Integer.parseInt(view.txtCantidad.getText());
            String fecha = view.txtFecha.getText();

            view.modeloTabla.setValueAt(codProveedor, fila, 0);
            view.modeloTabla.setValueAt(codPieza, fila, 1);
            view.modeloTabla.setValueAt(cantidad, fila, 2);
            view.modeloTabla.setValueAt(fecha, fila, 3);

            limpiar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Revise los campos numéricos");
        }
    }

    // ===== Eliminar fila seleccionada =====
    private void eliminar() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una fila para eliminar");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(view, "¿Desea eliminar este suministro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            view.modeloTabla.removeRow(fila);
            limpiar();
        }
    }

    // ===== Seleccionar fila =====
    private void seleccionarFila() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;

        view.txtCodProveedor.setText(view.modeloTabla.getValueAt(fila, 0).toString());
        view.txtCodPieza.setText(view.modeloTabla.getValueAt(fila, 1).toString());
        view.txtCantidad.setText(view.modeloTabla.getValueAt(fila, 2).toString());
        view.txtFecha.setText(view.modeloTabla.getValueAt(fila, 3).toString());
    }

    // ===== Limpiar campos =====
    private void limpiar() {
        view.txtCodProveedor.setText("");
        view.txtCodPieza.setText("");
        view.txtCantidad.setText("");
        view.txtFecha.setText("");
        view.tabla.clearSelection();
    }
}