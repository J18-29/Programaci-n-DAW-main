import java.io.*;
import java.util.*;

public class GestionAlumnosCSV {

    private static String rutaFichero;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta del fichero CSV: ");
        rutaFichero = sc.nextLine();

        File f = new File(rutaFichero);
        if (!f.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Mostrar alumnos");
            System.out.println("2. Insertar alumno");
            System.out.println("3. Modificar nombre por ID");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> mostrarAlumnos();
                case 2 -> insertarAlumno(sc);
                case 3 -> modificarNombre(sc);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta");
            }

        } while (opcion != 0);

        sc.close();
    }

    // 1 Mostrar alumnos
    private static void mostrarAlumnos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }

    // 2 Insertar alumno
    private static void insertarAlumno(Scanner sc) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            String cabecera = br.readLine();
            br.close();

            String[] columnas = cabecera.split(",");
            StringBuilder alumno = new StringBuilder();

            System.out.println("Introduce los datos:");

            for (int i = 0; i < columnas.length; i++) {
                System.out.print(columnas[i] + ": ");
                alumno.append(sc.nextLine());
                if (i < columnas.length - 1) alumno.append(",");
            }

            PrintWriter pw = new PrintWriter(new FileWriter(rutaFichero, true));
            pw.println(alumno);
            pw.close();

            System.out.println("Alumno insertado.");

        } catch (IOException e) {
            System.out.println("Error al insertar alumno.");
        }
    }

    // 3 Modificar nombre por ID (ArrayList)
    private static void modificarNombre(Scanner sc) {

        ArrayList<String> lineas = new ArrayList<>();
        boolean modificado = false;

        System.out.print("Introduce el ID del alumno: ");
        String idBuscado = sc.nextLine();

        System.out.print("Introduce el nuevo nombre: ");
        String nuevoNombre = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {

            String linea;

            // Guardamos la cabecera sin modificar
            linea = br.readLine();
            lineas.add(linea);

            // Procesar alumnos
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");

                if (campos[0].equals(idBuscado)) {
                    campos[1] = nuevoNombre; // modificar nombre
                    modificado = true;
                    linea = String.join(",", campos);
                }

                lineas.add(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
            return;
        }

        if (!modificado) {
            System.out.println("No se encontró ningún alumno con ese ID.");
            return;
        }

        // Sobrescribir el fichero
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaFichero))) {
            for (String l : lineas) {
                pw.println(l);
            }
            System.out.println("Nombre modificado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }
    }
}
