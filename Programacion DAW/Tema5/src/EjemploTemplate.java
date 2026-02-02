public class EjemploTemplate {
   
    //Metodo especifico para double
    public static void imprimirArray(Integer[] numeros) {
          for (double elemento : numeros) {
                System.out.print(elemento + " ");
          }
          System.out.println();
     }

     //Metodo especifico para int
     public static void imprimirArray(int[] arrayEnteros) {
          for (int elemento : arrayEnteros) {
                System.out.print(elemento + " ");
          }
          System.out.println();
     }
   //Metodo generico (TEMPLATE)
    public static <T> void imprimirArrayGenerico(T[] array) {
          for (T elemento : array) {
                System.out.print(elemento + " ");
          }
          System.out.println();
     }

     public static void main(String[] args) {
      //double[] arrayDoubles = {1.1, 2.2, 3.3};
     // int[] arrayEnteros = {1, 2, 3};
     // EjemploTemplate.imprimirArray(arrayDoubles);
    // EjemploTemplate.imprimirArray(arrayEnteros);
     // EjemploTemplate.imprimirArray(arrayDoubles);
      //Integer[] arrayEnterosObj = {1, 2, 3};
      //EjemploTemplate.imprimirArrayGenerico(arrayEnterosObj);

       //System.out.println("Uso de metodo generico:");
       //imprimirArrayGenerico(arrayEnterosObj);//
       Integer[] numeros = {1, 2, 3, 4, 5};
       imprimirArray(numeros);
        intercambiarElementos(numeros, 1, 3);
            imprimirArray(numeros);
           
            System.out.println("Esta en la posicion: " + localizarElemento(numeros, 2));
           
     }
   
        // Realiza un método genérico que intercambie el contenido 
    public static <T> void intercambiarElementos(T[] vector, int pos1, int pos2) {
        T temp = vector[pos1];
        vector[pos1] = vector[pos2];
        vector[pos2] = temp;
    }
    //Realiza un método genérico que localiza un elemento abuscar en el array o devuelva -1 si no lo encuentra
    public static boolean localizarElemento(Integer[] array, Integer elementoBuscado) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(elementoBuscado)) {
                return true;
            }
        }
        return false;
    }
    //Realiza un método genérico que devuelve el máximo de dos Valores
    public <T extends Comparable<T>> T maximo(T valor1, T valor2) {
        if (valor1.compareTo(valor2) > 0) {
            return valor1;
        } else {
            return valor2;
        }
    }

}
