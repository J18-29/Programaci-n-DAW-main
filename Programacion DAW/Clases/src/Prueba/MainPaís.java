package Prueba;

import País.País;

public class MainPaís {
    public static void main(String[] args) {
        // Crear un objeto País
        País pais1 = new País("España", 47000000, 1400); // PIB en millones

        // Mostrar datos usando getters
        System.out.println("Nombre del país: " + pais1.getNombre());
        System.out.println("Población: " + pais1.getPoblacion());
        System.out.println("PIB: " + pais1.getPib() + " millones");

        // Calcular y mostrar PIB per cápita
        System.out.println("PIB per cápita: " + pais1.calcularPibPerCapita());

        // Modificar valores usando setters
        pais1.setPoblacion(48000000);
        pais1.setPib(1500);

        System.out.println("\nDespués de actualizar datos:");
        System.out.println("Población: " + pais1.getPoblacion());
        System.out.println("PIB: " + pais1.getPib() + " millones");
        System.out.println("PIB per cápita: " + pais1.calcularPibPerCapita());
    }
}
