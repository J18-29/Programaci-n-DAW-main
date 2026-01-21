import java.nio.file.Files;
import java.nio.file.Paths;

public class HeroesDCG {
    public static void main(String[] args) {
        try {
            // Leer todo el archivo heroes.json
           String contenido = new String(Files.readAllBytes(Paths.get("./Tema5/heroes.json")));
            // Eliminar saltos de línea y espacios innecesarios
            contenido = contenido.replace("\n", "").replace("\r", "").trim();

            // Quitar los corchetes inicial y final
            if (contenido.startsWith("[")) contenido = contenido.substring(1);
            if (contenido.endsWith("]")) contenido = contenido.substring(0, contenido.length() - 1);

            // Separar cada héroe por "},{"
            String[] heroes = contenido.split("\\},\\s*\\{");

            // Encabezado de la tabla
            System.out.printf("%-5s %-20s %-15s %-20s %-25s %-40s%n",
                    "ID", "Superhéroe", "Editor", "Alter Ego", "Primera Aparición", "Personajes");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");

            int idContador = 1;

            for (String h : heroes) {
                // Limpiar llaves al inicio y al final
                h = h.replace("{", "").replace("}", "").trim();

                // Variables de cada héroe
                String superheroe = "";
                String editor = "";
                String alter_ego = "";
                String primera_aparicion = "";
                String personajes = "";

                // Separar campos por coma
                String[] campos = h.split("\",\\s*\"");
                for (String campo : campos) {
                    campo = campo.replace("\"", "");
                    String[] kv = campo.split(":", 2);
                    if (kv.length < 2) continue;
                    String key = kv[0].trim();
                    String value = kv[1].trim();

                    switch (key) {
                        case "superhéroe" -> superheroe = value;
                        case "editor" -> editor = value;
                        case "alter_ego" -> alter_ego = value;
                        case "primera_aparición", "first_appearance" -> primera_aparicion = value;
                        case "personajes" -> personajes = value;
                    }
                }

                // Filtrar héroes DC cuyo superhéroe empieza por G
                if (editor.toLowerCase().contains("dc") && superheroe.startsWith("G")) {
                    System.out.printf("%-5d %-20s %-15s %-20s %-25s %-40s%n",
                            idContador++, superheroe, editor, alter_ego, primera_aparicion, personajes);
                }
            }

        } catch (Exception e) {
            System.err.println("Error leyendo o procesando heroes.json");
            e.printStackTrace();
        }
    }
}
