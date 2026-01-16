
import java.time.LocalDateTime;

public class Relacion1 {

    public static void main(String[] args) {
        // Obtiene la hora actual
        LocalDateTime ahora = LocalDateTime.now();
        int hora = ahora.getHour();  // Extraer solo la hora del día (0-23)

        // Determina el saludo según el tramo horario
        if (hora >= 6 && hora <= 12) {
            System.out.println("Buenos días");
        } else if (hora >= 13 && hora <= 20) {
            System.out.println("Buenas tardes");
        } else {
            System.out.println("Buenas noches");
        }
    }
}



