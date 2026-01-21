import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ControlAcceso {

    private static final int MAX_INTENTOS = 3;
    private static final String FICHERO_USUARIOS = "Programaci-n-DAW-main/ActividadesT5/usuarios.txt";

    public static void main(String[] args) {

        HashMap<String, String> usuarios = cargarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("No se pudieron cargar los usuarios.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int intentos = 0;
        boolean acceso = false;

        while (intentos < MAX_INTENTOS && !acceso) {

            System.out.print("Introduce nombre de usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Introduce contraseña: ");
            String password = sc.nextLine();

            if (usuarios.containsKey(usuario) &&
                usuarios.get(usuario).equals(password)) {

                System.out.println("Ha accedido al área restringida");
                acceso = true;
            } else {
                intentos++;
                System.out.println("Datos incorrectos. Intentos restantes: "
                        + (MAX_INTENTOS - intentos));
            }
        }

        if (!acceso) {
            System.out.println("Lo siento, no tiene acceso al área restringida");
        }

        sc.close();
    }

    // Método para cargar usuarios desde el fichero
    private static HashMap<String, String> cargarUsuarios() {
        HashMap<String, String> mapa = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_USUARIOS))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.length() > 0) {
                    // Separamos usuario y contraseña
                    String usuario = linea.substring(0, linea.length() / 2);
                    String password = linea.substring(linea.length() / 2);
                    mapa.put(usuario, password);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        return mapa;
    }
}
