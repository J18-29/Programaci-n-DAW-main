

public class FuncionesJava {
    
    public static int suma(int numero1,int numero2){
        return numero1+numero2;
    }
        
    public static double suma(double numero1,double numero2){
        return numero1+numero2;
    }
    public static void escribir3saludos() {
         System.out.println("hola1");
         System.out.println("hola2");
         System.out.println("hola3");
    }
     
    public static int maximo(int numero1,int numero2) {
        if(numero1>=numero2) return numero1;
        return numero2;
    }
    public static void main(String[] args) {
        /*
         * 
         */
         escribir3saludos();
         /*
         * 
         * 
         * 
         */
        escribir3saludos();
        /*
         * 
         * 
         * 
         * 
         */
        escribir3saludos();
       /*
        * 
        */
          
        //Operacion
        System.out.println(suma(2,3));//Suma con parametros enteros
         System.out.println(suma(1.5,3.7));//Suma con parametros reales
      
      
       
        
        //maximo de 5 numeros (11,33,22,7,9)
        //System.out.println(maximo(numero1, numero2));
        
    }
}
