import java.util.Map;

public class Coches {
    public static void main(String[] args) {
        String[] listaCoches = {"Toyota", "Ford", "BMW", "Toyota", "Audi", "Ford", "Toyota", "BMW", "Mercedes", "Audi", "Ford"};

        Map<String, Integer> contadorMarcas = new java.util.HashMap<>();

        for (String marca : listaCoches) {
            if (contadorMarcas.containsKey(marca)) {
                contadorMarcas.put(marca, contadorMarcas.get(marca) + 1);
            } else {
                contadorMarcas.put(marca, 1);
            }
        }

        System.out.println("Frecuencia de marcas de coches:");
        for (Map.Entry<String, Integer> entrada : contadorMarcas.entrySet()) {
            System.out.println("Marca: " + entrada.getKey() + ", Frecuencia: " + entrada.getValue());
        }
    }

}
