import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Horarios {

    public static void main(String[] args) {
        // Crear un mapa para el horario semanal
        Map<String, List<String>> horario = new LinkedHashMap<>();

        // Asignar tus clases a cada día
        horario.put("LUNES", Arrays.asList("IPE", "Sistemas Informáticos", "Bases de Datos", "Programación"));
        horario.put("MARTES", Arrays.asList("LMSGI", "Sistemas Informáticos", "Programación", "Entornos de Desarrollo"));
        horario.put("MIÉRCOLES", Arrays.asList("Bases de Datos", "Sistemas Informáticos", "Programación"));
        horario.put("JUEVES", Arrays.asList("Programación", "Entornos de Desarrollo", "IPE", "Bases de Datos", "Sostenibilidad"));
        horario.put("VIERNES", Arrays.asList("Bases de Datos", "Digitalización", "LMSGI", "IPE", "Programación"));

        // Mostrar todo el horario
        System.out.println("===== HORARIO SEMANAL =====");
        for (Map.Entry<String, List<String>> dia : horario.entrySet()) {
            System.out.println(dia.getKey() + ": " + dia.getValue());
        }

        // Obtener el día actual
        DayOfWeek diaActual = LocalDate.now().getDayOfWeek();
        String diaTexto = diaActual.toString();

        // Pasar a mayúsculas con tildes corregidas si hace falta
        diaTexto = diaTexto.toUpperCase(Locale.ROOT);

        // Mostrar las clases del día actual
        System.out.println("\n===== CLASES DE HOY (" + diaTexto + ") =====");

        if (horario.containsKey(diaTexto)) {
            List<String> clasesHoy = horario.get(diaTexto);
            for (String clase : clasesHoy) {
                System.out.println("- " + clase);
            }
        } else {
            System.out.println("¡Hoy no hay clases! 🎉");
        }
    }
}
