import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class CopiarFichero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Pedir ruta del fichero original
        System.out.print("Introduce la ruta del fichero: ");
        String ruta = sc.nextLine();

        File ficheroOriginal = new File(ruta);

        if (!ficheroOriginal.exists()) {
            System.out.println("El fichero no existe.");
            sc.close();
            return;
        }

        // Obtener nombre del fichero
        String nombre = ficheroOriginal.getName();

        // Nombre sin extensión
        String nombreSinExtension =
                nombre.substring(0, nombre.lastIndexOf('.'));

        // Fecha actual
        LocalDate fecha = LocalDate.now();

        // Crear nombre del fichero copia
        String nombreCopia = nombreSinExtension + "_copia_"
                + fecha.getYear() + "_"
                + fecha.getMonthValue() + "_"
                + fecha.getDayOfMonth() + ".txt";

        // Crear fichero copia en el mismo directorio
        File ficheroCopia = new File(
                ficheroOriginal.getParent(), nombreCopia);

        try {
            Scanner lector = new Scanner(ficheroOriginal);
            PrintWriter escritor = new PrintWriter(ficheroCopia);

            // Copiar contenido
            while (lector.hasNextLine()) {
                escritor.println(lector.nextLine());
            }

            lector.close();
            escritor.close();

            System.out.println("Fichero copiado correctamente:");
            System.out.println(ficheroCopia.getAbsolutePath());

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer o escribir el fichero.");
        }

        sc.close();
    }
}
