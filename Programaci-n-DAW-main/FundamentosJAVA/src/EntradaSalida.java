import java.util.Scanner;

public class EntradaSalida{
    public static void main(String[] args) {
            //Instrucciones de salida por pantalla
            int valor=7;
            System.out.print(valor);

            //Usar printf
            double precio=130.354;
            System.out.printf("El precio del producto %s tiene un valor de %5.2f y se han comprado %d" ,"Tablet",precio,valor);
            //Incluir un icono
            System.out.println("Que ganas tengo de unas vacaciones");

            //Formato reciente de System
            System.out.println("El precio del producto "+"Tablet "+"tique un valor de "+precio+" y se han comprado "+valor);
            //Formato salida texto
            System.out.printf("%15s, %-15s","José","Informatico");

            //Formato tabla
            System.out.println("|----------|----------|----------|");
            System.out.printf("|%-10s|%-10s|%10s|\n","Producto","Cantidad","Valor");
            System.out.println("|----------|----------|----------|");
            System.out.printf("|%-10s|%d|%f|\n","Producto",valor,precio);

            System.out.println("|----------|----------|----------|");
            System.out.println("|"+"Producto"+"|"+"Cantidad"+"|"+"Precio"+"|");
            System.out.println("|----------|----------|----------|");
            System.out.println("|"+"Tablet"+"   |   "+valor+"    |   "+precio+"   |");
            System.out.println("|----------|----------|----------|");
            
            //Operaciones de entrada por teckado
            Scanner teclado=new Scanner(System.in);
            //System.out.println("Introduce la cadena de texto deseada");
            //String cadena=teclado.nextLine();
            //System.out.println("La cadena introducida es:"+cadena);
            System.out.println("Introduce: Nombre");
            //Lee Nombre
            String nombre=teclado.nextLine();
             System.out.println("Introduce: Apellido");
           //Leer Apellido
            String apellido=teclado.nextLine();
          
           //Leer Edad
            System.out.println("Introduce: Edad");

            int edad=Integer.parseInt(teclado.nextLine());
            //Leer Profesión
            System.out.println("Introduce: Profesion");
            String profesion=teclado.nextLine();
            System.out.println("El usuario se llama "+nombre+" "+apellido+". Tiene "+edad+" años y trabaja de "+profesion);

            
            teclado.close();

        
        
        }

    
}
