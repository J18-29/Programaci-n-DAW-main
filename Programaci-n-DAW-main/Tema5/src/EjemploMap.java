import java.util.HashMap;
import java.util.Map;

public class EjemploMap {
 public static void main(String[] args) {
 // 1. Declaración del Map (Clave: String, Valor: String)
 Map<String, String> heroes = new HashMap<>();
 // 2. Insertar datos (put)
 heroes.put("Batman", "DC Comics");
 heroes.put("Spider-Man", "Marvel Comics");
 heroes.put("Iron Man", "Marvel Comics");
 heroes.put("Wonder Woman", "DC Comics");
 heroes.put("Superman", "DC Comics");
 heroes.put("Thor", "Marvel Comics");
 // 3. Acceder a un valor por su clave (get)
 String editorial = heroes.get("Batman");
 System.out.println("La editorial de Batman es: " + editorial);
 // 4. Comprobar si existe una clave
 if (heroes.containsKey("Hulk")) {
 System.out.println("Hulk está en el mapa.");
 } else {
 System.out.println("Hulk no está registrado.");
 }

// 5. Recorrer el Map (EntrySet)
 // Muy útil para mostrar tablas en una web
 System.out.println("\n--- Lista completa de Héroes ---");
 for (Map.Entry<String, String> entrada : heroes.entrySet()) {
    System.out.println("Héroe: " + entrada.getKey() + ", Editorial: " + entrada.getValue());
 }
 // 6. Eliminar un elemento
 heroes.remove("Spider-Man");
 System.out.println("\nTras borrar a Spider-Man, el tamaño es: "
+ heroes.size());
 }
}
