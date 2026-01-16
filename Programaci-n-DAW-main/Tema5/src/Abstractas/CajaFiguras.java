package Abstractas;

import java.util.ArrayList;

public class CajaFiguras<T extends Figura> {
    private ArrayList<T> figuras;

    public CajaFiguras() {
        figuras = new ArrayList<>();
    }

    public void guardar(T figura) {
        figuras.add(figura);
    }

    public void mostrarContenido() {
        for (T figura : figuras) {
            System.out.println(figura);
        }
    }

    public double calcularAreaTotal() {
        double total = 0;
        for (T figura : figuras) {
            total += figura.calcularArea();
        }
        return total;
    }
}
