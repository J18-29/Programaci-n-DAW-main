package CONTROLLERS;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import MODELS.Libro;
import MODELS.LibroDAO;
import VIEWS.LibroVIEW;

public class LibroCONTROLLERS {

    // Referencia a la vista para poder acceder a sus componentes
    private LibroVIEW view;

    // Objeto DAO encargado de realizar las operaciones con la base de datos
    private LibroDAO dao = new LibroDAO();

    // URL de imagen por defecto si el libro no tiene imagen
    private final String URL_IMAGEN_DEFAULT = "https://via.placeholder.com/150x200.png?text=Sin+Imagen";

    /*
     * Constructor del controlador
     * Recibe la vista y prepara el controlador
     */
    public LibroCONTROLLERS(LibroVIEW view) {
        this.view = view;
        initController(); // Inicializa los eventos de los botones
        cargarTabla(); // Carga los datos de los libros en la tabla
    }

    /*
     * Método que conecta los botones de la vista con sus funciones
     * Aquí se registran los eventos de la interfaz gráfica
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
         * en los campos del formulario
         */
        view.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });

        /*
         * Eventos que permiten cargar la imagen cuando:
         * - el usuario presiona Enter en el campo de URL
         * - el campo pierde el foco
         */
        view.txtUrl.addActionListener(e -> cargarImagen(view.txtUrl.getText(), view.lblImagen));

        view.txtUrl.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                cargarImagen(view.txtUrl.getText(), view.lblImagen);
            }
        });
    }

    /*
     * MÉTODO INSERTAR
     * Obtiene los datos escritos en la vista y crea un nuevo libro
     * que se guarda en la base de datos mediante el DAO
     */
    private void insertar() {
        try {

            // Obtener los datos introducidos por el usuario
            int id = Integer.parseInt(view.txtId.getText());
            String titulo = view.txtTitulo.getText();
            String isbn = view.txtIsbn.getText();
            int anio = Integer.parseInt(view.txtAnio.getText());
            String descripcion = view.txtDescripcion.getText();
            String url = view.txtUrl.getText();
            int idAutor = Integer.parseInt(view.txtIdAutor.getText());

            // Crear el objeto libro e insertarlo en la base de datos
            dao.insertar(new Libro(id, titulo, isbn, anio, descripcion, url, idAutor));

            // Actualizar la tabla y limpiar el formulario
            cargarTabla();
            limpiar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Datos ingresados no válidos");
        }
    }

    /*
     * MÉTODO ACTUALIZAR
     * Actualiza los datos de un libro seleccionado en la tabla
     */
    private void actualizar() {

        int fila = view.tabla.getSelectedRow();

        // Si no hay fila seleccionada no se puede actualizar
        if (fila == -1)
            return;

        try {

            // Obtener los datos modificados desde la vista
            int id = Integer.parseInt(view.txtId.getText());
            String titulo = view.txtTitulo.getText();
            String isbn = view.txtIsbn.getText();
            int anio = Integer.parseInt(view.txtAnio.getText());
            String descripcion = view.txtDescripcion.getText();
            String url = view.txtUrl.getText();
            int idAutor = Integer.parseInt(view.txtIdAutor.getText());

            // Enviar los datos actualizados al DAO
            dao.actualizar(new Libro(id, titulo, isbn, anio, descripcion, url, idAutor));

            // Recargar tabla y limpiar campos
            cargarTabla();
            limpiar();
                   // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres actualizar este libro?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION)
            return;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "No fue posible actualizar");
        }
    }

    /*
     * MÉTODO ELIMINAR
     * Elimina el libro seleccionado en la tabla
     */
    private void eliminar() {

        int fila = view.tabla.getSelectedRow();

        if (fila == -1)
            return;

        // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres eliminar este libro?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION)
            return;

        // Obtener el ID del libro seleccionado
        int id = Integer.parseInt(view.modeloTabla.getValueAt(fila, 0).toString());

        // Eliminar desde el DAO
        dao.eliminar(id);

        cargarTabla();
        limpiar();
    }

    /*
     * MÉTODO SELECCIONAR FILA
     * Cuando el usuario selecciona un libro en la tabla
     * se cargan sus datos en los campos del formulario
     */
    private void seleccionarFila() {

        int fila = view.tabla.getSelectedRow();
        if (fila == -1){
        }else{

        view.txtId.setText(view.modeloTabla.getValueAt(fila, 0).toString());
        view.txtTitulo.setText(view.modeloTabla.getValueAt(fila, 1).toString());
        view.txtIsbn.setText(view.modeloTabla.getValueAt(fila, 2).toString());
        view.txtAnio.setText(view.modeloTabla.getValueAt(fila, 3).toString());
        view.txtDescripcion.setText(view.modeloTabla.getValueAt(fila, 4).toString());

        // Evita error si la URL es null
        Object urlObj = view.modeloTabla.getValueAt(fila, 5);
        String urlString = (urlObj != null) ? urlObj.toString() : "";
        view.txtUrl.setText(urlString);

        view.txtIdAutor.setText(view.modeloTabla.getValueAt(fila, 6).toString());

        // Mostrar la imagen del libro usando la URL
        cargarImagen(urlString, view.lblImagen);
    }
}

    /*
     * MÉTODO CARGAR TABLA
     * Obtiene todos los libros de la base de datos
     * y los muestra en la JTable
     */
    private void cargarTabla() {

        view.modeloTabla.setRowCount(0);

        List<Libro> lista = dao.listar();

        for (Libro l : lista) {
            view.modeloTabla.addRow(new Object[] {
                    l.getId(),
                    l.getTitulo(),
                    l.getIsbn(),
                    l.getAnio(),
                    l.getDescripcion(),
                    l.getUrl(),
                    l.getId_Autor()
            });
        }
    }

    /*
     * MÉTODO LIMPIAR
     * Limpia todos los campos del formulario
     * y elimina la selección de la tabla
     */
    private void limpiar() {

        view.txtId.setText("");
        view.txtTitulo.setText("");
        view.txtIsbn.setText("");
        view.txtAnio.setText("");
        view.txtDescripcion.setText("");
        view.txtUrl.setText("");
        view.txtIdAutor.setText("");

        view.lblImagen.setIcon(null);
        view.lblImagen.setText("");

        view.tabla.clearSelection();
    }

  private void cargarImagen(String imagenURL, JLabel label) {

    label.setIcon(null);
    label.setText("");

    // Si no hay URL no se carga imagen
    if (imagenURL == null || imagenURL.isEmpty()) {
        return;
    }

    try {
        Image imgEscalada;

        if (imagenURL.startsWith("data:image")) {
            // Manejo de Base64
            String base64 = imagenURL.substring(imagenURL.indexOf(",") + 1);
            byte[] imagenBytes = java.util.Base64.getDecoder().decode(base64);
            ImageIcon icon = new ImageIcon(imagenBytes);

            imgEscalada = icon.getImage().getScaledInstance(
                    label.getWidth(),
                    label.getHeight(),
                    Image.SCALE_SMOOTH
            );

        } else {
            // URL normal (http/https)
            URL url = new URL(imagenURL);
            BufferedImage img = ImageIO.read(url);

            if (img == null) {
                label.setText("No se pudo cargar la imagen");
                return;
            }

            imgEscalada = img.getScaledInstance(
                    label.getWidth(),
                    label.getHeight(),
                    Image.SCALE_SMOOTH
            );
        }

        label.setIcon(new ImageIcon(imgEscalada));
        label.setHorizontalAlignment(JLabel.CENTER);

    } catch (Exception e) {
        label.setText("Error al cargar la imagen");
        e.printStackTrace();
    }
}
}