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
    // Método CRUD
    //================

    private void insertar() {
        try {
            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String nombre = view.txtNombre.getText();
            String color = view.txtColor.getText();
            double precio = Double.parseDouble(view.txtPrecio.getText());
            int codCategoria = Integer.parseInt(view.txtCodCategoria.getText());

            dao.insertar(new Pieza(codigo, nombre, color, precio, codCategoria));
            cargarTabla();
            limpiar();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Revise los campos numéricos");
        }
    }

    private void actualizar() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una fila para modificar");
            return;
        }

        try {
            
            int filaModelo = view.tabla.convertRowIndexToModel(fila);

            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String nombre = view.txtNombre.getText();
            String color = view.txtColor.getText();
            double precio = Double.parseDouble(view.txtPrecio.getText());
            int codCategoria = Integer.parseInt(view.txtCodCategoria.getText());

            dao.actualizar(new Pieza(codigo, nombre, color, precio, codCategoria));
            cargarTabla();
            limpiar();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Revise los campos numéricos");
        }
    }

    private void eliminar() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una fila para eliminar");
            return;
        }

        int filaModelo = view.tabla.convertRowIndexToModel(fila);
        int codigo = Integer.parseInt(view.modeloTabla.getValueAt(filaModelo, 0).toString());
        dao.borrar(codigo);
        cargarTabla();
        limpiar();
    }

    private void seleccionarFila() {
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;

        int filaModelo = view.tabla.convertRowIndexToModel(fila);

        view.txtCodigo.setText(view.modeloTabla.getValueAt(filaModelo, 0).toString());
        view.txtNombre.setText(view.modeloTabla.getValueAt(filaModelo, 1).toString());
        view.txtColor.setText(view.modeloTabla.getValueAt(filaModelo, 2).toString());
        view.txtPrecio.setText(view.modeloTabla.getValueAt(filaModelo, 3).toString());
        view.txtCodCategoria.setText(view.modeloTabla.getValueAt(filaModelo, 4).toString());
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
