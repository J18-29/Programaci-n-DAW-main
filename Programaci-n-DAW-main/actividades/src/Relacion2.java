

import java.util.Scanner;

public class Relacion2 {

    public static void main(String[] args) {
         // Creamos un objeto Scanner para leer datos del usuario
        Scanner entrada = new Scanner(System.in);
         // Pedimos al usuario que introduzca el número de horas trabajadas
        System.out.print("Por favor, introduzca el número de horas trabajadas durante la semana: ");
        int horasTrabajadas = entrada.nextInt();
        int salario = 0; // Variable para guardar el salario calculado


         // Si trabajó 40 horas o menos, se pagan a 12 euros la hora
        if (horasTrabajadas <= 40) {
            salario = horasTrabajadas * 12;
        } else {
            // Si trabajó más de 40, las extras se pagan a 16 euros
            int extras = horasTrabajadas - 40;
            salario = (40 * 12) + (extras * 16);
        }
          // Mostramos el resultado al usuario
        System.out.println("El sueldo semanal que le corresponde es de " + salario + " euros");
        // Cerramos el Scanner
        entrada.close();
    }
}


