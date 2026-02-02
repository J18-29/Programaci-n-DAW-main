public class App {
public static void main(String[] args) {
  char[] cadena1={'J','o','s','e'};
  char[] cadena2={'J','o','s','e'};
  if (compararCadenas(cadena1, cadena2)) System.out.println("Son iguales"); 
   else System.out.println("Son diferentes"); 
  

   String palabra1="Jose";
   String palabra2="Jose";
   if(palabra1.equals(palabra2)) System.out.println("Son iguales");
   else System.out.println("Son diferentes");

   int[] numeros={3,5,7,9,1,3,54};
   for(int i=0;i<numeros.length;i++){
    System.out.println(numeros[i]+"");
   }
}
public static boolean compararCadenas(char[] cadena1,char[] cadena2){
      if(cadena1.length!=cadena2.length) return false;
      for(int i=0;i<cadena1.length;i++){
        if(cadena1[i]!=cadena2[i]) return false;
      }
      return true;
}
}
 
