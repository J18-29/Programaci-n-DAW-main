public class Muestra {
    public static void main(String[] args) {
        int array[]={2,5,14,7,8,2,9};
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+""); // El +"" es innecesario, se puede quitar
        }
        System.out.println();
    }
}
 

//El + "" convierte el valor numérico en una cadena antes de imprimirlo. 
//En este caso no es necesario, porque System.out.print() ya puede imprimir enteros directamente. 
//Solo se usaría si quisiéramos forzar que el resultado sea tratado como texto