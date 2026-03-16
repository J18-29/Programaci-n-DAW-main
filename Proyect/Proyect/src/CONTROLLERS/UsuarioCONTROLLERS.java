package CONTROLLERS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import MODELS.Usuario;
import MODELS.UsuarioDAO;
import VIEWS.UsuarioVIEW;

public class UsuarioCONTROLLERS {

    // Referencia a la vista para acceder a sus componentes
    private UsuarioVIEW view;

    // DAO encargado de las operaciones con la base de datos
    private UsuarioDAO dao = new UsuarioDAO();

    // Formato utilizado para convertir fechas entre texto y objeto Date
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    /*
     * Constructor del controlador
     * Recibe la vista y prepara el controlador
     */
    public UsuarioCONTROLLERS(UsuarioVIEW view) {
        this.view = view;
        initController(); // Inicializa eventos de botones
        cargarTabla();    // Carga los usuarios en la tabla al iniciar
    }

    /*
     * Método que conecta los botones de la interfaz
     * con las funciones del controlador
     */
    private void initController() {

        // Botones CRUD
        view.btnInsertar.addActionListener(e -> insertar());
        view.btnActualizar.addActionListener(e -> actualizar());
        view.btnEliminar.addActionListener(e -> eliminar());
        view.btnLimpiar.addActionListener(e -> limpiar());

        /*
         * Evento que detecta cuando el usuario selecciona
         * una fila de la tabla para mostrar sus datos
         * en el formulario
         */
        view.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });
    }

    /*
     * MÉTODO INSERTAR
     * Obtiene los datos introducidos en la vista
     * y crea un nuevo usuario en la base de datos
     */
    private void insertar() {

        try {

            // Obtener datos de los campos de la vista
            String telefono = view.txtTelefono.getText();
            String nombre = view.txtNombre.getText();
            String apellido1 = view.txtApellido1.getText();
            String apellido2 = view.txtApellido2.getText();
            String sexo = view.txtSexo.getText();
            String fechaTexto = view.txtFechaNacimiento.getText();

            // Convertir el texto de fecha a objeto Date
            Date fechaNacimiento = null;
            if (!fechaTexto.isEmpty()) {
                fechaNacimiento = formato.parse(fechaTexto);
            }

            // Insertar usuario en la base de datos
            dao.insertar(new Usuario(0, telefono, nombre, apellido1, apellido2, sexo, fechaNacimiento));

            cargarTabla(); // Actualizar tabla
            limpiar();     // Limpiar formulario

        } catch (ParseException ex) {

            // Error si la fecha no tiene el formato correcto
            JOptionPane.showMessageDialog(view, "Formato de fecha incorrecto. Use yyyy-MM-dd");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(view, "Datos ingresados no válidos");
        }
    }

    /*
     * MÉTODO ACTUALIZAR
     * Modifica los datos de un usuario seleccionado en la tabla
     */
    private void actualizar() {

        int fila = view.tabla.getSelectedRow();

        // Verificar que haya una fila seleccionada
        if (fila == -1){

           JOptionPane.showMessageDialog(view,"No puede haber filas negativas");

        } else {

        try {

            // Obtener los datos actualizados desde la vista
            int codigo = Integer.parseInt(view.txtCodigo.getText());
            String telefono = view.txtTelefono.getText();
            String nombre = view.txtNombre.getText();
            String apellido1 = view.txtApellido1.getText();
            String apellido2 = view.txtApellido2.getText();
            String sexo = view.txtSexo.getText();
            String fechaTexto = view.txtFechaNacimiento.getText();

            // Convertir texto de fecha a Date
            Date fechaNacimiento = null;
            if (!fechaTexto.isEmpty()) {
                fechaNacimiento = formato.parse(fechaTexto);
            }
       // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres Actualizar este Usuario?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION)
            return;
            // Actualizar usuario en la base de datos
            dao.actualizar(new Usuario(codigo, telefono, nombre, apellido1, apellido2, sexo, fechaNacimiento));

            cargarTabla();
            limpiar();

        } catch (ParseException ex) {

            JOptionPane.showMessageDialog(view, "Formato de fecha incorrecto. Use yyyy-MM-dd");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(view, "No fue posible actualizar");
        }
    }
    }

    /*
     * MÉTODO ELIMINAR
     * Elimina el usuario seleccionado en la tabla
     */
    private void eliminar() {

        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;

        // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres eliminar este Usuario?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        // Obtener el código del usuario seleccionado
        int codigo = Integer.parseInt(view.modeloTabla.getValueAt(fila, 0).toString());

        // Eliminar usuario en la base de datos
        dao.eliminar(codigo);

        cargarTabla();
        limpiar();
    }

    /*
     * MÉTODO SELECCIONAR FILA
     * Cuando el usuario selecciona una fila de la tabla,
     * los datos se cargan en los campos del formulario
     */
    private void seleccionarFila() {

        int fila = view.tabla.getSelectedRow();
        if (fila == -1) return;

        view.txtCodigo.setText(view.modeloTabla.getValueAt(fila, 0).toString());
        view.txtTelefono.setText(view.modeloTabla.getValueAt(fila, 1).toString());
        view.txtNombre.setText(view.modeloTabla.getValueAt(fila, 2).toString());
        view.txtApellido1.setText(view.modeloTabla.getValueAt(fila, 3).toString());
        view.txtApellido2.setText(view.modeloTabla.getValueAt(fila, 4).toString());
        view.txtSexo.setText(view.modeloTabla.getValueAt(fila, 5).toString());

        // Convertir fecha Date a texto para mostrarla en el campo
        Date fecha = (Date) view.modeloTabla.getValueAt(fila, 6);

        if (fecha != null) {
            view.txtFechaNacimiento.setText(formato.format(fecha));
        } else {
            view.txtFechaNacimiento.setText("");
        }
    }

    /*
     * MÉTODO CARGAR TABLA
     * Obtiene todos los usuarios desde la base de datos
     * y los muestra en la JTable
     */
    private void cargarTabla() {

        view.modeloTabla.setRowCount(0);

        List<Usuario> lista = dao.listar();

        // Recorrer lista y añadir cada usuario a la tabla
        for (Usuario u : lista) {

            view.modeloTabla.addRow(new Object[]{
                u.getCodigo(),
                u.getTelefono(),
                u.getNombre(),
                u.getApellido1(),
                u.getApellido2(),
                u.getSexo(),
                u.getFechaNacimiento()
            });
        }
    }

    /*
     * MÉTODO LIMPIAR
     * Limpia todos los campos del formulario
     * y quita la selección de la tabla
     */
    private void limpiar() {

        view.txtCodigo.setText("");
        view.txtTelefono.setText("");
        view.txtNombre.setText("");
        view.txtApellido1.setText("");
        view.txtApellido2.setText("");
        view.txtSexo.setText("");
        view.txtFechaNacimiento.setText("");

        view.tabla.clearSelection();
    }
}