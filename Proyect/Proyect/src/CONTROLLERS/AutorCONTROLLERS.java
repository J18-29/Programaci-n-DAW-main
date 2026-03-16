package CONTROLLERS;


import java.util.List;
import javax.swing.JOptionPane;
import MODELS.Autor;
import MODELS.AutorDAO;
import VIEWS.AutorVIEW;

// Controlador que conecta la vista (interfaz gráfica) con el modelo (datos)

public class AutorCONTROLLERS {

    private AutorVIEW view;

     // Objeto DAO que se encarga de acceder a la base de datos
    private AutorDAO dao = new AutorDAO();

  
    public AutorCONTROLLERS(AutorVIEW view) {
        this.view = view;
        initController();
        cargarTabla();
    }

  // Método que conecta los botones de la vista con sus acciones
    private void initController() {
       // Cuando se pulsa el botón insertar se ejecuta el método insertar()
        view.btnInsertar.addActionListener(e -> insertar());

        // Cuando se pulsa actualizar se ejecuta actualizar()
        view.btnActualizar.addActionListener(e -> actualizar());

        // Cuando se pulsa eliminar se ejecuta eliminar()
        view.btnEliminar.addActionListener(e -> eliminar());

        // Limpia los campos del formulario
        view.btnLimpiar.addActionListener(e -> limpiar());

        // Detecta cuando el usuario selecciona una fila de la tabla
        view.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });
    }

    // ====================
    // Métodos CRUD
    // ====================

   // INSERTAR un autor en la base de datos
    private void insertar() {

        // Obtiene los datos escritos en la vista
        Autor autor = obtenerAutorDesdeVista();

        if (autor != null) {

            // Llama al DAO para insertar el autor en la base de datos
            if (dao.insertarAutor(autor)) {

                cargarTabla(); // Actualiza la tabla
                limpiar();     // Limpia los campos

            } else {
                JOptionPane.showMessageDialog(view, "Error al insertar el autor");
            }
        }
    }
     // ACTUALIZAR un autor existente
    private void actualizar() {

        // Obtiene la fila seleccionada de la tabla
        int fila = view.tabla.getSelectedRow();

        // Si no hay fila seleccionada se muestra un mensaje
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Selecciona una fila para actualizar");
            return;
        }

        // Obtiene los datos de la vista
        Autor autor = obtenerAutorDesdeVista();
               // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres Actualizar este Autor?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION)
            return;
        if (autor != null) {

            // Llama al DAO para actualizar el autor
            if (dao.actualizarAutor(autor)) {
                cargarTabla(); // Recarga la tabla
                limpiar();     // Limpia los campos
                
            } else {
                JOptionPane.showMessageDialog(view, "Error al actualizar el autor");
            }
        }
    }
    // ELIMINAR un autor
    private void eliminar() {

        // Obtiene la fila seleccionada
        int fila = view.tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Selecciona una fila para eliminar");
            return;
        }

        // Obtiene el ID del autor desde la tabla
        int id = Integer.parseInt(view.modeloTabla.getValueAt(fila, 0).toString());

        // Ventana de confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Deseas eliminar este autor?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {

            // Llama al DAO para eliminar el autor
            if (dao.eliminarAutor(id)) {

                cargarTabla(); // Recarga los datos
                limpiar();     // Limpia los campos

            } else {
                JOptionPane.showMessageDialog(view, "Error al eliminar el autor");
            }
        }
    }
 // Cuando se selecciona una fila de la tabla se muestran los datos en los campos
    private void seleccionarFila() {

        int fila = view.tabla.getSelectedRow();

        if (fila == -1) return;

        // Pasa los datos de la tabla a los campos de texto
        view.txtId.setText(view.modeloTabla.getValueAt(fila, 0).toString());
        view.txtNombre.setText(view.modeloTabla.getValueAt(fila, 1).toString());
        view.txtTelefono.setText(view.modeloTabla.getValueAt(fila, 2).toString());
    }

    // Carga todos los autores desde la base de datos a la tabla
    private void cargarTabla() {

        // Limpia la tabla antes de cargar datos nuevos
        view.modeloTabla.setRowCount(0);

        // Obtiene la lista de autores desde el DAO
        List<Autor> lista = dao.listarAutores();

        // Recorre la lista y añade cada autor a la tabla
        for (Autor a : lista) {
            view.modeloTabla.addRow(new Object[]{
                a.getId(),
                a.getNombre(),
                a.getTelefono()
            });
        }
    }

    // Limpia los campos del formulario
    private void limpiar() {

        view.txtId.setText("");
        view.txtNombre.setText("");
        view.txtTelefono.setText("");
        view.tabla.clearSelection(); // Quita la selección de la tabla
    }


  // Método auxiliar que crea un objeto Autor con los datos de la vista
    private Autor obtenerAutorDesdeVista() {

        try {

            // Obtiene los datos escritos por el usuario
            int id = Integer.parseInt(view.txtId.getText().trim());
            String nombre = view.txtNombre.getText().trim();
            String telefono = view.txtTelefono.getText().trim();

            // Devuelve el objeto Autor
            return new Autor(id, nombre, telefono);

        } catch (NumberFormatException ex) {

            // Si el ID o teléfono no son números se muestra un error
            JOptionPane.showMessageDialog(view, "ID o teléfono inválido");
            return null;
        }
    }
}