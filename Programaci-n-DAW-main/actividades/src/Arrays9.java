import java.util.ArrayList;
import java.util.Scanner;

public class Arrays9 {
    public static void main(String[] args) {

        // Crear una lista dinámica de enteros
        ArrayList<Integer> lista = new ArrayList<>();

        // Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        int opcion; // Variable para almacenar la opción elegida en el menú

        // Bucle principal del menú, se repetirá hasta que el usuario elija salir
        do {
            // Mostrar el menú
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un número");
            System.out.println("2. Eliminar un número");
            System.out.println("3. Mostrar todos los números");
            System.out.println("4. Comprobar si un número está en la lista");
            System.out.println("5. Eliminar todos los números");
            System.out.println("6. Consultar el tamaño de la lista");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = sc.nextInt(); // Leer opción del usuario

            // Ejecutar acción según la opción elegida
            switch (opcion) {

                case 1:
                    // Agregar un número positivo
                    System.out.print("Introduce un número positivo: ");
                    int num = sc.nextInt();

                    // Validar que sea positivo
                    while (num < 0) {
                        System.out.print("Número negativo, intenta de nuevo: ");
                        num = sc.nextInt();
                    }

                    lista.add(num); // Agregar número a la lista
                    break;

                case 2:
                    // Eliminar un número de la lista
                    System.out.print("Número a eliminar: ");
                    int eliminar = sc.nextInt();
                    // removeIf elimina todos los elementos que cumplan la condición
                    lista.removeIf(n -> n == eliminar);
                    break;

                case 3:
                    // Mostrar todos los números de la lista
                    System.out.println("Lista completa: " + lista);
                    break;

                case 4:
                    // Comprobar si un número está en la lista
                    System.out.print("Número a comprobar: ");
                    int comprobar = sc.nextInt();
                    if (lista.contains(comprobar)) {
                        System.out.println("El número está en la lista");
                    } else {
                        System.out.println("El número NO está en la lista");
                    }
                    break;

                case 5:
                    // Eliminar todos los números de la lista
                    lista.clear();
                    System.out.println("Lista eliminada");
                    break;

                case 6:
                    // Consultar el tamaño actual de la lista
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;

                case 7:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    break;

                default:
                    // Opción no válida
                    System.out.println("Opción no válida");
            }

        } while (opcion != 7); // Repetir mientras no se elija salir
    }
}
