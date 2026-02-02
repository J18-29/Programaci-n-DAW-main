import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ControlAcceso {

    public static void main(String[] args) {

        HashMap<String, String> usuarios = new HashMap<>();

        // Leer el fichero y cargar el HashMap
        try (BufferedReader br = new BufferedReader(new FileReader("Programaci-n-DAW-main/ActividadesT5/usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    usuarios.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de usuarios.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int intentos = 3;
        boolean acceso = false;

        while (intentos > 0 && !acceso) {

            System.out.print("Introduzca nombre de usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Introduzca contraseña: ");
            String password = sc.nextLine();

            if (usuarios.containsKey(usuario) &&
                usuarios.get(usuario).equals(password)) {

                System.out.println("Ha accedido al área restringida");
                acceso = true;

            } else {
                intentos--;
                System.out.println("Datos incorrectos. Intentos restantes: " + intentos);
            }
        }

        if (!acceso) {
            System.out.println("Lo siento, no tiene acceso al área restringida");
        }

        sc.close();
    }
}
