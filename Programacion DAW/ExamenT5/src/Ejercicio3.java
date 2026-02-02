import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio3 {
    //Buscar palabras en español a ingles con HashMap<String, String>
    public static void main(String[] args) {
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("calientes", "hot");
        diccionario.put("rojo", "red");
        diccionario.put("ardiente", "hot");
        diccionario.put("verde", "green");
        diccionario.put("agujetas", "stiff");
        diccionario.put("abrasador", "hot");
        diccionario.put("hierro", "iron");
        diccionario.put("grande", "big");

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra en español: ");
        String palabra = sc.nextLine();

        String traduccion = diccionario.get(palabra);
        if (traduccion != null) {
            System.out.println("La traducción al inglés es: " + traduccion);
        } else {
            System.out.println("La palabra no se encuentra en el diccionario.");
        }
        sc.close();
    }
}
