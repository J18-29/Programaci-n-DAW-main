import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ContadorPalabras {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta del fichero: ");
        String ruta = sc.nextLine();

        File fichero = new File(ruta);

        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
        } else {
            System.out.print("Introduce la palabra a buscar: ");
            String palabraBuscada = sc.nextLine().toLowerCase();

            int contador = 0;

            try {
                BufferedReader br = new BufferedReader(new FileReader(fichero));
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] palabras = linea.toLowerCase().split("\\s+");

                    for (String p : palabras) {
                        if (p.equals(palabraBuscada)) {
                            contador++;
                        }
                    }
                }

                br.close();

                System.out.println("La palabra aparece " + contador + " veces.");

            } catch (Exception e) {
                System.out.println("Error al leer el fichero.");
            }
        }

        sc.close();
    }
}
