import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HeroesDC {

    public static void main(String[] args) {

        StringBuilder jsonBuilder = new StringBuilder();

        // 1️⃣ Leer el fichero heroes.json
        try (BufferedReader br = new BufferedReader(new FileReader("Programaci-n-DAW-main/ActividadesT5/heroes.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                jsonBuilder.append(linea.trim());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

        String json = jsonBuilder.toString();

        // 2️⃣ Separar los héroes (cada bloque entre {})
        String[] heroes = json.split("\\},\\{");

        System.out.printf("%-20s | %-20s | %-20s%n", "Superhero", "Alter Ego", "First Appearance");
        System.out.println("---------------------------------------------------------------------");

        for (String hero : heroes) {

            // Limpiar caracteres { o } al inicio o final
            hero = hero.replace("{", "").replace("}", "").trim();

            // Extraer campos
            String superhero = extraerValor(hero, "superhero");
            String publisher = extraerValor(hero, "publisher");
            String alter_ego = extraerValor(hero, "alter_ego");
            String first_appearance = extraerValor(hero, "first_appearance");

            // Filtrar: DC y superhero empieza por G
            if ("DC".equalsIgnoreCase(publisher) && superhero.startsWith("G")) {
                System.out.printf("%-20s | %-20s | %-20s%n",
                        superhero, alter_ego, first_appearance);
            }
        }
    }

    // Método auxiliar para extraer valores
    private static String extraerValor(String bloque, String clave) {
        String busqueda = "\"" + clave + "\":";
        int inicio = bloque.indexOf(busqueda);
        if (inicio == -1) return "";

        inicio += busqueda.length();

        // Quitar posibles espacios y comillas
        while (inicio < bloque.length() && (bloque.charAt(inicio) == ' ' || bloque.charAt(inicio) == '\"')) {
            inicio++;
        }

        int fin = inicio;
        while (fin < bloque.length() && bloque.charAt(fin) != '\"' && bloque.charAt(fin) != ',') {
            fin++;
        }

        return bloque.substring(inicio, fin).trim();
    }
}
