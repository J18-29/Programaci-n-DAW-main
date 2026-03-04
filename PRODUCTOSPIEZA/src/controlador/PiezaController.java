package controlador;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pieza;
import modelo.PiezaDAO;
import vista.PiezaView;

public class PiezaController {

    private PiezaView view;
    private PiezaDAO dao = new PiezaDAO();

    public PiezaController(PiezaView view) {
        this.view = view;
        initController();
        cargarTabla();
    }

    private void initController() {
        view.btnAgregar.addActionListener(e -> insertar());
        view.btnModificar.addActionListener(e -> actualizar());
        view.btnEliminar.addActionListener(e -> eliminar());
        view.btnLimpiar.addActionListener(e -> limpiar());

        view.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });
    }

    //================
    // Métodos CRUD
    //================

    private void insertar() {
        try {
            if (view.txtCodigo.getText().isEmpty() ||
                view.txtNombre.getText().isEmpty() ||
                view.txtColor.getText().isEmpty() ||
                view.txtPrecio.getText().isEmpty() ||
                view.txtCodCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Complete todos los campos");
                return;
            }

            // Tomar valores de los campos
            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String nombre = view.txtNombre.getText();
            String color = view.txtColor.getText();
            double precio = Double.parseDouble(view.txtPrecio.getText());
            int codCategoria = Integer.parseInt(view.txtCodCategoria.getText());

            // Crear objeto Pieza (opcional si usas DAO)
            Pieza p = new Pieza(codigo, nombre, color, precio, codCategoria);

            // Insertar directamente en la tabla
            view.modeloTabla.addRow(new Object[]{
                p.getCodigo(),
                p.getNombre(),
                p.getColor(),
                p.getPrecio(),
                p.getCodCategoria()
            });

            // Limpiar campos
            limpiar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Revise los campos numéricos");
        }
    }

    // ===== Modificar fila seleccionada =====
    private void actualizar() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una fila para modificar");
            return;
        }

        try {
            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String nombre = view.txtNombre.getText();
            String color = view.txtColor.getText();
            double precio = Double.parseDouble(view.txtPrecio.getText());
            int codCategoria = Integer.parseInt(view.txtCodCategoria.getText());

            // Actualizar directamente la fila de la tabla
            view.modeloTabla.setValueAt(codigo, fila, 0);
            view.modeloTabla.setValueAt(nombre, fila, 1);
            view.modeloTabla.setValueAt(color, fila, 2);
            view.modeloTabla.setValueAt(precio, fila, 3);
            view.modeloTabla.setValueAt(codCategoria, fila, 4);

            limpiar(); // limpiar campos después de modificar

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

        int opcion = JOptionPane.showConfirmDialog(view, "¿Desea eliminar esta pieza?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            view.modeloTabla.removeRow(fila);
            limpiar();
        }
    }

    private void seleccionarFila() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;

        view.txtCodigo.setText(view.modeloTabla.getValueAt(fila, 0).toString());
        view.txtNombre.setText(view.modeloTabla.getValueAt(fila, 1).toString());
        view.txtColor.setText(view.modeloTabla.getValueAt(fila, 2).toString());
        view.txtPrecio.setText(view.modeloTabla.getValueAt(fila, 3).toString());
        view.txtCodCategoria.setText(view.modeloTabla.getValueAt(fila, 4).toString());
    }

    private void cargarTabla() {
        view.modeloTabla.setRowCount(0);
        List<Pieza> lista = dao.listar();
        for (Pieza p : lista) {
            view.modeloTabla.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    p.getColor(),
                    p.getPrecio(),
                    p.getCodCategoria()
            });
        }
    }

    private void limpiar() {
        view.txtCodigo.setText("");
        view.txtNombre.setText("");
        view.txtColor.setText("");
        view.txtPrecio.setText("");
        view.txtCodCategoria.setText("");
        view.tabla.clearSelection();
    }
}