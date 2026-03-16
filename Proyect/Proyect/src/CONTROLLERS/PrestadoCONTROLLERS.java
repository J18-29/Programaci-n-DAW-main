package CONTROLLERS;

import java.util.List;
import javax.swing.JOptionPane;
import MODELS.Prestado;
import MODELS.PrestadoDAO;
import VIEWS.PrestadoVIEW;

public class PrestadoCONTROLLERS {

    // Referencia a la vista para acceder a sus componentes
    private PrestadoVIEW view;

    // Objeto DAO encargado de comunicarse con la base de datos
    private PrestadoDAO dao = new PrestadoDAO();

    /*
     * Constructor del controlador
     * Recibe la vista y prepara el controlador
     */
    public PrestadoCONTROLLERS(PrestadoVIEW view) {
        this.view = view;
        initController(); // Inicializa los eventos de la interfaz
        cargarTabla();    // Carga los datos existentes en la tabla
    }

    /*
     * Método que conecta los botones de la vista con las funciones
     * del controlador (eventos de la interfaz)
     */
    private void initController() {

        // Botones para las operaciones CRUD
        view.btnInsertar.addActionListener(e -> insertar());
        view.btnActualizar.addActionListener(e -> actualizar());
        view.btnEliminar.addActionListener(e -> eliminar());
        view.btnLimpiar.addActionListener(e -> limpiar());

        /*
         * Evento que detecta cuando el usuario selecciona
         * una fila de la tabla para mostrar sus datos
         * en los campos del formulario
         */
        view.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });
    }

    /*
     * MÉTODO INSERTAR
     * Obtiene los datos de la vista y crea un nuevo préstamo
     * que se guarda en la base de datos mediante el DAO
     */
    private void insertar() {

        // Crear objeto Prestado a partir de los datos de la vista
        Prestado p = obtenerPrestadoDesdeVista();

        if (p != null) {

            // Insertar el préstamo en la base de datos
            if (dao.insertarPrestado(p)) {

                cargarTabla(); // Actualizar tabla
                limpiar();     // Limpiar formulario

            } else {
                JOptionPane.showMessageDialog(view, "No se pudo insertar porque no existen esas claves");
            }
        }
    }

    /*
     * MÉTODO ACTUALIZAR
     * Actualiza un préstamo seleccionado en la tabla
     */
    private void actualizar() {

        // Obtener la fila seleccionada
        int fila = view.tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Selecciona una fila para actualizar");
            return;
        }

        // Obtener los datos desde la vista
        Prestado p = obtenerPrestadoDesdeVista();

        if (p != null) {

            // Actualizar el registro en la base de datos
            if (dao.actualizarPrestado(p)) {

                cargarTabla(); // Recargar tabla
                limpiar();     // Limpiar campos

            } else {
                JOptionPane.showMessageDialog(view, "No se pudo actualizar el registro");
            }
        }
               // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres actualizar este Prestamo?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION)
            return;
    }

    /*
     * MÉTODO ELIMINAR
     * Elimina un préstamo seleccionado en la tabla
     */
    private void eliminar() {

        int fila = view.tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Selecciona una fila para eliminar");
            return;
        }

        // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres eliminar el préstamo?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        /*
         * Obtener los identificadores del préstamo desde la tabla.
         * En este caso la clave es compuesta:
         * - ID del libro
         * - Código del usuario
         */
        int idLibro = Integer.parseInt(view.modeloTabla.getValueAt(fila,0).toString());
        int codigoUsuario = Integer.parseInt(view.modeloTabla.getValueAt(fila,1).toString());

        // Eliminar registro en la base de datos
        if (dao.eliminarPrestado(idLibro,codigoUsuario)) {

            cargarTabla();
            limpiar();

        } else {
            JOptionPane.showMessageDialog(view, "No se pudo eliminar el registro");
        }
    }

    /*
     * MÉTODO SELECCIONAR FILA
     * Cuando el usuario selecciona una fila de la tabla
     * se cargan los datos en los campos del formulario
     */
    private void seleccionarFila() {

        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;

        view.txtIdLibro.setText(view.modeloTabla.getValueAt(fila,0).toString());
        view.txtCodigoUsuario.setText(view.modeloTabla.getValueAt(fila,1).toString());
    }

    /*
     * MÉTODO CARGAR TABLA
     * Obtiene todos los préstamos desde la base de datos
     * y los muestra en la JTable
     */
    private void cargarTabla() {

        // Limpiar tabla antes de cargar nuevos datos
        view.modeloTabla.setRowCount(0);

        List<Prestado> lista = dao.listarPrestados();

        // Recorrer lista y añadir cada préstamo a la tabla
        for(Prestado p : lista){
            view.modeloTabla.addRow(new Object[]{
                p.getIdLibro(),
                p.getCodigoUsuario()
            });
        }
    }

    /*
     * MÉTODO LIMPIAR
     * Limpia los campos del formulario
     * y quita la selección de la tabla
     */
    private void limpiar() {

        view.txtIdLibro.setText("");
        view.txtCodigoUsuario.setText("");
        view.tabla.clearSelection();
    }

    /*
     * MÉTODO AUXILIAR
     * Crea un objeto Prestado utilizando los datos
     * introducidos por el usuario en la vista
     */
    private Prestado obtenerPrestadoDesdeVista() {

        try {

            int idLibro = Integer.parseInt(view.txtIdLibro.getText().trim());
            int codigoUsuario = Integer.parseInt(view.txtCodigoUsuario.getText().trim());

            return new Prestado(idLibro,codigoUsuario);

        } catch(NumberFormatException ex) {

            JOptionPane.showMessageDialog(view,"ID Libro o Código Usuario inválido");
            return null;
        }
    }
}