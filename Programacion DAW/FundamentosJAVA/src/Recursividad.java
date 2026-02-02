public class Recursividad {
     public static void main(String[] args) {
 int a = 1002;
 System.out.println(funcion(a, 2));
 }
 public static int funcion(int num, int pos){
 if(num < 10){
 return num;
 }else{
 return (num % 10) * (int) Math.pow(10, pos) + (funcion(num/10, pos-1));
 }
 }
}
