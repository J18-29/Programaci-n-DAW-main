

public class App{
    public static void main(String[] args) throws Exception {
    //Actividades tema 2 diapositiva 9
    //Realiza un programa que genera dos numeros aleatorios
    
    /*
     * Pseudocodigo
     * Inicio_Programa
     *      generar numero1 aleatorio
     *      generar numero2 aleatorio
     *      Hacer Cuentas (cociente,media,potencia,raiz cuadrada)
     *      imprimir cociente,media,potencia y raiz de cada número
     *   Fin_Programa
        */
        int min=1,  max=100;
        int numero1=(int) (Math.random()*(max-min+1))+min;
        int numero2=(int) (Math.random()*(max-min+1))+min;
        int cociente=numero1/numero2;
        double media=(numero1+numero2)/2.0;
        double potencia=Math.pow(numero1,numero2);
        double raiz1=Math.sqrt(numero1);
        double raiz2=Math.sqrt(numero2);
        //Sacar Resultados
        System.out.println("los numeros generados son:"+numero1+ "y"+numero2);
        System.out.println("El cociente es: "+cociente);
        System.out.println("La media es:"+media);
        System.out.println("La potencia es:"+potencia);
        System.out.println("la raiz cuadrada de numero1 es:"+raiz1);
        System.out.println("la raiz cuadrada de numero2 es:"+raiz2);
     }
}