
import java.io.*;
import java.util.Scanner;

public class Actividad1T5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce la ruta del primer fichero: ");
            String ruta1 = sc.nextLine();

            System.out.print("Introduce la ruta del segundo fichero: ");
            String ruta2 = sc.nextLine();

            System.out.print("Introduce la ruta del directorio destino: ");
            String rutaDestino = sc.nextLine();

            File fichero1 = new File(ruta1);
            File fichero2 = new File(ruta2);

            String nombre1 = fichero1.getName().replace(".txt", "");
            String nombre2 = fichero2.getName().replace(".txt", "");

            File ficheroResultado = new File(
                    rutaDestino + File.separator + nombre1 + "_" + nombre2 + ".txt"
            );

            BufferedReader br1 = new BufferedReader(new FileReader(fichero1));
            BufferedReader br2 = new BufferedReader(new FileReader(fichero2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroResultado));

            String linea;

            while ((linea = br1.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            while ((linea = br2.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            br1.close();
            br2.close();
            bw.close();

            System.out.println("Fichero creado correctamente en: "
                    + ficheroResultado.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al trabajar con los ficheros.");
            e.printStackTrace();
        }

        sc.close();
    }
}


