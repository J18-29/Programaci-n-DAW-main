
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio1 {

    public static void main(String[] args) {
       System.out.println("Introduce la ruta del fichero Java:");
        String rutaFichero;
        try (Scanner sc = new Scanner(System.in)) {
            rutaFichero = sc.nextLine();
        }
        File fichero = new File(rutaFichero);
        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }
        ArrayList<String> lineasSinComentarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().startsWith("//")) {
                    lineasSinComentarios.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            for (String linea : lineasSinComentarios) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
        System.out.println("Fichero procesado correctamente, comentarios eliminados.");

}
}
