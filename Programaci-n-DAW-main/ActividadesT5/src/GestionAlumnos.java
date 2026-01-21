import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GestionAlumnos {

    public static void main(String[] args) {

        StringBuilder json = new StringBuilder();

        // 1. Leer el fichero alumnos.json
        try (BufferedReader br = new BufferedReader(new FileReader("Programaci-n-DAW-main/ActividadesT5/Alumnos.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                json.append(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
            return;
        }

        // 2. Inicializar HashMap de resultados
        HashMap<String, Integer> resultados = new HashMap<>();
        resultados.put("Suspensos", 0);
        resultados.put("Aprobados", 0);
        resultados.put("Notables", 0);
        resultados.put("Sobresalientes", 0);

        // 3. Procesar el JSON manualmente
        String[] alumnos = json.toString().split("\\{\\s*\"nombre\"");

        for (int i = 1; i < alumnos.length; i++) {

            String bloque = alumnos[i];

            // Nombre
            String nombre = bloque.substring(
                    bloque.indexOf(":") + 2,
                    bloque.indexOf("\",")
            );

            // Notas
            String notasTexto = bloque.substring(
                    bloque.indexOf("[") + 1,
                    bloque.indexOf("]")
            );

            String[] notasArray = notasTexto.split(",");
            ArrayList<Integer> notas = new ArrayList<>();

            for (String n : notasArray) {
                notas.add(Integer.parseInt(n.trim()));
            }

            // Media
            double suma = 0;
            for (int nota : notas) {
                suma += nota;
            }
            double media = suma / notas.size();

            System.out.printf("Alumno: %s - Media: %.2f%n", nombre, media);

            // Clasificación
            if (media < 5) {
                resultados.put("Suspensos", resultados.get("Suspensos") + 1);
            } else if (media < 7) {
                resultados.put("Aprobados", resultados.get("Aprobados") + 1);
            } else if (media < 9) {
                resultados.put("Notables", resultados.get("Notables") + 1);
            } else {
                resultados.put("Sobresalientes", resultados.get("Sobresalientes") + 1);
            }
        }

        // 4. Mostrar resumen
        System.out.println("\nResumen de calificaciones:");
        for (String clave : resultados.keySet()) {
            System.out.println(clave + ": " + resultados.get(clave));
        }
    }
}
