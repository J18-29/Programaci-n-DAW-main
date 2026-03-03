package controlador;

import java.util.List;

import javax.swing.JOptionPane;

import modelo.Categoria;
import modelo.CategoriaDAO;
import vista.CategoriaView;

public class CategoriaController {

    private CategoriaView view;
    private CategoriaDAO dao = new CategoriaDAO();

    public CategoriaController(CategoriaView view) {
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
    //Metodo crud
    //================

    private void insertar() {
        try{
            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String nombre = view.txtNombre.getText();

            dao.insertar(new Categoria(codigo, nombre));
            cargarTabla();
            limpiar();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Código inválido");
        }
    }
     
    private void actualizar(){
        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;
        try {
            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String nombre = view.txtNombre.getText();

            dao.actualizar(new Categoria(codigo, nombre));
            cargarTabla();
            limpiar();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Código inválido");
        }
}

 private void eliminar(){
     int fila = view.tabla.getSelectedRow();
     if (fila == -1) return;
        int codigo = Integer.parseInt(
            view.modeloTabla.getValueAt(fila, 0).toString()
        );
        dao.eliminar(codigo);
        cargarTabla();
        limpiar();
 }
   
  private void seleccionarFila(){
    int fila = view.tabla.getSelectedRow();
    if (fila == -1) return;
    view.txtCodigo.setText(
          view.modeloTabla.getValueAt(fila, 0).toString()
        );
    view.txtNombre.setText(
          view.modeloTabla.getValueAt(fila, 1).toString()
        );
  }
 
  private void cargarTabla(){
    view.modeloTabla.setRowCount(0);
    List<Categoria> lista = dao.listar();
    for (Categoria c : lista) {
        view.modeloTabla.addRow(new Object[]{
            c.getId(), 
            c.getNombre()
        });
    }
  }
  
  private void limpiar(){
    view.txtCodigo.setText("");
    view.txtNombre.setText("");
    view.tabla.clearSelection();
  }
}


