import java.text.Normalizer;
import java.util.Scanner;

public class Arrays8 {
    public static void main(String[] args) {

        // Crear un Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase:");

        // Leer la línea completa introducida por el usuario
        String frase = sc.nextLine();

        // Comprobar si la frase es un palíndromo
        if (esPalindromo(frase)) {
            System.out.println("La frase es palíndroma");
        } else {
            System.out.println("La frase no es palíndroma");
        }
    }

    // Método que devuelve true si el texto es palíndromo, false si no
    public static boolean esPalindromo(String texto) {

        // Quitar tildes y normalizar caracteres
        // Normalizer.Form.NFD separa las letras de los acentos
        // [\\p{M}] elimina los marcadores de acento
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[\\p{M}]", "");

        // Quitar todos los espacios y convertir a minúsculas
        texto = texto.replaceAll("\\s+", "").toLowerCase();

        // Crear la cadena inversa
        String inversa = new StringBuilder(texto).reverse().toString();

        // Comprobar si la cadena original (procesada) es igual a la inversa
        return texto.equals(inversa);
    }
}
