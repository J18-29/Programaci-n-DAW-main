

public class Recursividad {
    //Función que calcula abusando recursividad. Recordad que a*b=a*ab-1
    public static double potencia(int base, int exponente) {
        //Caso Base
        if(exponente==0) return 1;
        else return base*potencia(base, exponente-1);
    }
  public static void main(String[] args) {
    System.out.println(potencia(2, 10));
  }  
}

