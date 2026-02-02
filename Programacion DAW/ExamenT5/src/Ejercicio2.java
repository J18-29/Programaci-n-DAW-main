import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Scanner;

public class Ejercicio2 {
    private static String ruta;
    public static void main(String[] args){
        //Leer archivo json
       Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta del fichero: ");
        ruta = sc.nextLine();

        File fichero = new File(ruta);

            if (!fichero.exists()) {
                System.out.println("El fichero no existe.");
            }
        sc.close();
        empleadosActivos();
        empleadosAdmin();
        datosEmpresa();
        datosEmpleado(ruta);
        

        }
        //Número de empleados activos y cómo se llaman
        private static void empleadosActivos(){
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                String linea;
                int activos = 0;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains("\"activo\": true")) {
                        activos++;
                    }
                }
                System.out.println("Número de empleados activos: " + activos);
            } catch (Exception e) {

        }
    }
    //Número de empleados que tienen rol admin
    private static void empleadosAdmin(){
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int roles = 0;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("\"roles\": \"admin\"")) {
                    roles++;
                }
            }
            System.out.println("Número de empleados con rol admin: " + roles);
        } catch (Exception e) {

        }
    }
   //Imprime los datos de la empresa (Nombre y dirección)
    private static void datosEmpresa(){
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("\"empresa\":")) {
                    System.out.println("Datos de la empresa:");
                    while (!(linea = br.readLine()).contains("},")) {
                        System.out.println(linea.trim());
                    }
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
    //Preguntar por un empleado y decir sus datos o mostrar que no es empleado
    
    private static void datosEmpleado(String ruta){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del empleado: ");
        String nombreEmpleado = sc.nextLine();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("\"nombre\": \"" + nombreEmpleado + "\"")) {
                    encontrado = true;
                    System.out.println("Datos del empleado " + nombreEmpleado + ":");
                    System.out.println(linea.trim());
                    while (!(linea = br.readLine()).contains("},")) {
                        System.out.println(linea.trim());
                    }
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("El empleado " + nombreEmpleado + " no existe.");
            }
        } catch (Exception e) {

        }
        sc.close();
    }
}
