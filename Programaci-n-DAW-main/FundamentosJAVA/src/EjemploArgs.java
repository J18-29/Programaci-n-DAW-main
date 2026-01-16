public class EjemploArgs {
 public static void main(String[] args) {
 // Imprime los argumentos recibidos por consola
 System.out.println("Argumentos recibidos:");
 for (String arg : args) {
 System.out.println(arg);
 }
 // Verifica si se han pasado argumentos numéricos para sumarlos
 if (args.length > 1) {
 try {
 int num1 = Integer.parseInt(args[0]);
 int num2 = Integer.parseInt(args[1]);
 System.out.println("\nLa suma de los dos primeros argumentos es: " + (num1 + num2));
 } catch (NumberFormatException e) {
 System.out.println("\nLos dos primeros argumentos deben ser números para realizar la suma.");
 }
 }
 }
}
