package Abstractas;

public class Geometria {
    public static void main(String[] args) {

        // Caja solo de círculos
        CajaFiguras<Circulo> cajaCirculos = new CajaFiguras<>();
        cajaCirculos.guardar(new Circulo("Círculo 1", 5));
        cajaCirculos.guardar(new Circulo("Círculo 2", 10));

        // Caja solo de rectángulos
        CajaFiguras<Rectangulo> cajaRectangulos = new CajaFiguras<>();
        cajaRectangulos.guardar(new Rectangulo("Rectángulo 1", 4, 6));
        cajaRectangulos.guardar(new Rectangulo("Rectángulo 2", 2, 8));

        // Caja general
        CajaFiguras<Figura> cajaGeneral = new CajaFiguras<>();
        cajaGeneral.guardar(new Circulo("Círculo General", 4));
        cajaGeneral.guardar(new Rectangulo("Rectángulo General", 3, 7));

        // Mostrar resultados
        System.out.println("=== Caja de Círculos ===");
        cajaCirculos.mostrarContenido();
        System.out.println("Área total: " + cajaCirculos.calcularAreaTotal());

        System.out.println("\n=== Caja de Rectángulos ===");
        cajaRectangulos.mostrarContenido();
        System.out.println("Área total: " + cajaRectangulos.calcularAreaTotal());

        System.out.println("\n=== Caja General ===");
        cajaGeneral.mostrarContenido();
        System.out.println("Área total: " + cajaGeneral.calcularAreaTotal());
    }
}
