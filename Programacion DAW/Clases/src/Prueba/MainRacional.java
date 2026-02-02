package Prueba;

import NumerosRacionales.Racional;

public class MainRacional {
    public static void main(String[] args) {
        // Crear números racionales
        Racional r1 = new Racional(2, 3);
        Racional r2 = new Racional(4, 5);

        System.out.print("r1 = ");
        r1.imprimirRacional();
        System.out.print("r2 = ");
        r2.imprimirRacional();

        // Suma
        Racional suma = r1.sumar(r2);
        System.out.print("Suma: ");
        suma.imprimirRacional();

        // Resta
        Racional resta = r1.restar(r2);
        System.out.print("Resta: ");
        resta.imprimirRacional();

        // Producto
        Racional producto = r1.multiplicar(r2);
        System.out.print("Producto: ");
        producto.imprimirRacional();

        // División
        Racional division = r1.dividir(r2);
        System.out.print("División: ");
        division.imprimirRacional();

        // Comparar igualdad
        Racional r3 = new Racional(4, 6); // equivalente a 2/3
        System.out.println("r1 es igual a r3? " + r1.esIgual(r3));
    }
}
