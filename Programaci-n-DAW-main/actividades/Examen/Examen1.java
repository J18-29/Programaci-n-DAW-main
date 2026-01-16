package Examen;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Examen1 {

    public static void main(String[] args) {

        ArrayList<Integer> sorteo = generarSorteo();
        ArrayList<Integer> jugador = leerNumerosJugador();

        System.out.println("Números del sorteo: " + sorteo);
        System.out.println("Números del jugador: " + jugador);

        int aciertos = contarAciertos(sorteo, jugador);
        System.out.println("Aciertos: " + aciertos);

        int premio = calcularPremio(aciertos);
        System.out.println("Premio obtenido: " + premio + " €");
    }

    // Generamos 5 números aleatorios del 0 al 9
    public static ArrayList<Integer> generarSorteo() {
        ArrayList<Integer> sorteo = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            sorteo.add(rand.nextInt(10)); // 0–9
        }
        return sorteo;
    }

    // Leemos los 5 números del jugador
    public static ArrayList<Integer> leerNumerosJugador() {
        ArrayList<Integer> jugador = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tus 5 números (0 a 9):");
        for (int i = 0; i < 5; i++) {
            int num;
            do {
                System.out.print("Número " + (i + 1) + ": ");
                num = sc.nextInt();
            } while (num < 0 || num > 9);
            jugador.add(num);
        }
        return jugador;
    }

    // Contamos los aciertos posición por posición
    public static int contarAciertos(ArrayList<Integer> sorteo, ArrayList<Integer> jugador) {
        int aciertos = 0;

        for (int i = 0; i < 5; i++) {
            if (sorteo.get(i).equals(jugador.get(i))) {
                aciertos++;
            }
        }
        return aciertos;
    }

    // Devolvemos el premio según los aciertos
    public static int calcularPremio(int aciertos) {
        switch (aciertos) {
            case 5: return 100000;
            case 4: return 50000;
            case 3: return 200;
            case 2: return 50;
            case 1: return 10;
            default: return 0;
        }
    }
}
