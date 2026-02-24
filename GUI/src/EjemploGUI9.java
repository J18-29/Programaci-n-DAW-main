import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

public class EjemploGUI9 extends JFrame{
 private ImageIcon icono;
 public EjemploGUI9(){
 initComponents();
 }
 public void initComponents(){
 // Pedir URL
 String urlTexto = JOptionPane.showInputDialog(
 null, "Introduce la URL de la imagen:",
 "Cargar Imagen",JOptionPane.QUESTION_MESSAGE);
 // Crear ventana
 setTitle("Imagen cargada");
 setSize(600, 400);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setLocationRelativeTo(null);//Centrar en ventana
 try {
 if (urlTexto!=null && !urlTexto.trim().isEmpty()){
 URL url = new java.net.URI(urlTexto).toURL();
 icono = new ImageIcon(url);
 }

 // Si el usuario cancela se intenta leer desde FICHERO
 else if (urlTexto == null || urlTexto.isEmpty()) {
 JFileChooser fileChooser = new JFileChooser();
 int resultado = fileChooser.showOpenDialog(null);
 if (resultado == JFileChooser.APPROVE_OPTION) {
 File archivo = fileChooser.getSelectedFile();
 icono = new ImageIcon(archivo.getAbsolutePath());
 } else {
 urlTexto=null; // Si cancela también el fileChooser
 }
 }
Image imagenEscalada = icono.getImage()
 .getScaledInstance(550, 350, Image.SCALE_SMOOTH);
 JLabel label = new JLabel(new ImageIcon(imagenEscalada));
 add(label);
 } catch (Exception e) {
 JOptionPane.showMessageDialog(
 null, "URL no válida o no se pudo cargar la imagen",
 "Error", JOptionPane.ERROR_MESSAGE);
 }
 setVisible(true);
 }
 public static void main(String[] args) { 
    new EjemploGUI9(); 

 }
}