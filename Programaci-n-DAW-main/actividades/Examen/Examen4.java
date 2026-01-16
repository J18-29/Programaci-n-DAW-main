package Examen;

public class Examen4{
   

    public static boolean tieneLasCincoVocales(String palabra) {
        // las Convertirmos a minúsculas y quitar tildes (ej: 'é' -> 'e')
        String palabraLimpia = palabra.toLowerCase()
        .replaceAll("á", "a")
        .replaceAll("é", "e")
        .replaceAll("í", "i")
        .replaceAll("ó", "o")
        .replaceAll("ú", "u");

        //  Verificamos cada vocal
        boolean tieneA = palabraLimpia.contains("a");
        boolean tieneE = palabraLimpia.contains("e");
        boolean tieneI = palabraLimpia.contains("i");
        boolean tieneO = palabraLimpia.contains("o");
        boolean tieneU = palabraLimpia.contains("u");

        //  Devolvemos true si están todas
        return tieneA && tieneE && tieneI && tieneO && tieneU;
    }

    public static void main(String[] args) {
        String ejemplo1 = "Murcielago"; 
        String ejemplo2 = "Euforia"; 
        String ejemplo3 = "Aurelio";      
        String ejemplo4 = "Pizza"; 

        System.out.println(ejemplo1 + " tiene las 5 vocales: " + tieneLasCincoVocales(ejemplo1));
        System.out.println(ejemplo2 + " tiene las 5 vocales: " + tieneLasCincoVocales(ejemplo2));
        System.out.println(ejemplo3 + " tiene las 5 vocales: " + tieneLasCincoVocales(ejemplo3));
        System.out.println(ejemplo4 + " tiene las 5 vocales: " + tieneLasCincoVocales(ejemplo4));
    }
}

