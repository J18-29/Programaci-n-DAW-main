public class Bucles {

     public static void main(String[] args) {

//         // Bucle for: imprime del 0 al 4
//         System.out.println("Bucle for:");
//         for (int i = 0; i < 5; i++) {
//             System.out.println(i);
//         }

//         // Bucle while: imprime del 0 al 4
//         System.out.println("\nBucle while:");
//         int j = 0;
//         while (j < 5) {
//             System.out.println(j);
//             j++;
//         }

//         // Bucle do-while: imprime del 0 al 4
//         System.out.println("\nBucle do-while:");
//         int k = 0;
//         do {
//             System.out.println(k);
//             k++;
//         } while (k < 5);

//         // Validación de entrada del usuario entre 1 y 5
//         Scanner teclado = new Scanner(System.in);
//         int numero;

//         do {
//             System.out.print("\nEscribe un número entre 1 y 5: ");
//             numero = teclado.nextInt();
//         } while (numero < 1 || numero > 5);

//         System.out.println("Número válido ingresado: " + numero);

//         teclado.close(); // Buenas prácticas: cerrar el Scanner

        //Bucles anidados
        for (int i=1;i<=4;i++){
            
            for(int j=1;j<=i;j++){
                 System.out.println("*");
            }
           System.out.println("");
        }

        
    }
 }
