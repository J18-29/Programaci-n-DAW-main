public class Funciones1{

    public static void buscarNumero(int[] array, int numeroBuscado) {
        boolean encontrado = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroBuscado) {
                System.out.println("El número " + numeroBuscado + " se encuentra en la posición " + i + ".");
                encontrado = true;
                break;  // Si solo quieres la primera aparición
            }
        }

        if (!encontrado) {
            System.out.println("El número " + numeroBuscado + " no se encuentra en el array.");
        }
    }

    public static void main(String[] args) {
        int[] miArray = {10, 20, 30, 40, 50};

        buscarNumero(miArray, 10);  // Salida: posición 2
        buscarNumero(miArray, 70);  // Salida: no se encuentra
    }
}

