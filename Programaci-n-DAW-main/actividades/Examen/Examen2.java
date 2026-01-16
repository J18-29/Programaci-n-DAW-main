package Examen;

import java.util.Random;

public class Examen2{
    public static void main(String[] args) {
       
        int[][] matriz = new int[5][5];
        Random rand = new Random();

        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = rand.nextInt(101); 
            }
        }

    }
}
