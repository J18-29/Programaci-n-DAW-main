public class EjemploTemplate {
   
    public static void imprimirArray(Integer[] numeros) {
          for (double elemento : numeros) {
                System.out.print(elemento + " ");
          }
          System.out.println();
     }

     public static void imprimirArray(int[] arrayEnteros) {
          for (int elemento : arrayEnteros) {
                System.out.print(elemento + " ");
          }
          System.out.println();
     }
    public static <T> void imprimirArrayGenerico(T[] array) {
          for (T elemento : array) {
                System.out.print(elemento + " ");
          }
          System.out.println();
     }

     public static void main(String[] args) {

       Integer[] numeros = {1, 2, 3, 4, 5};
       imprimirArray(numeros);
        intercambiarElementos(numeros, 1, 3);
            imprimirArray(numeros);
           
            System.out.println("Esta en la posicion: " + localizarElemento(numeros, 2));
           
     }
   
    public static <T> void intercambiarElementos(T[] vector, int pos1, int pos2) {
        T temp = vector[pos1];
        vector[pos1] = vector[pos2];
        vector[pos2] = temp;
    }
    public static boolean localizarElemento(Integer[] array, Integer elementoBuscado) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(elementoBuscado)) {
                return true;
            }
        }
        return false;
    }
    public <T extends Comparable<T>> T maximo(T valor1, T valor2) {
        if (valor1.compareTo(valor2) > 0) {
            return valor1;
        } else {
            return valor2;
        }
    }

}
