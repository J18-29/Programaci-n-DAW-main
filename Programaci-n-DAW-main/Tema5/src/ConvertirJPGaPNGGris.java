import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ConvertirJPGaPNGGris {
 public static void main(String[] args) {
 // Rutas de entrada y salida
 String rutaEntrada = "./Tema5/Renos.png";
 String rutaSalida = "./Tema5/salida4.png";
 try {
 // Leer imagen JPEG
 BufferedImage imagenColor = ImageIO.read(new File(rutaEntrada));
 if (imagenColor == null) {
 System.out.println("No se pudo leer la imagen. Verifica la ruta y el archivo.");
 return;
 }
 // Crear una imagen en escala de grises
 BufferedImage imagenGris = new BufferedImage(
 imagenColor.getWidth(),
 imagenColor.getHeight(),
 BufferedImage.TYPE_INT_RGB
 );
 // Convertir pixel por pixel a escala de grises
 for (int y = 0; y < imagenColor.getHeight(); y++) {
 for (int x = 0; x < imagenColor.getWidth(); x++) {
 Color color = new Color(imagenColor.getRGB(x, y));
//int gris = (int)(color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);
//int gris = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
int nuevoColor = new Color(0,color.getGreen(),color.getBlue()).getRGB();
imagenGris.setRGB(x, y, nuevoColor);
 }
 }
 // Guardar como PNG
 boolean resultado = ImageIO.write(imagenGris, "png", new File(rutaSalida));
 if (resultado) {
 System.out.println("Conversión completada: imagen en escala de grises guardada como " + rutaSalida);
 } else {
 System.out.println("No fue posible guardar la imagen.");
 }
 } catch (IOException e) {
 System.err.println("Error al leer o escribir la imagen: " + e.getMessage());
 }
 }
}