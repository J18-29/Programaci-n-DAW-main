import java.util.Scanner;

public class Condicional {
    
    public static void main(String[] args) {
        int user = 45;
        if (user <=18) {
            System.out.println("User is 18 or younger");
            }
            else if (user >18 && user< 40) {
                System.out.println("User is between 19 and 39");
            }
            else if (user ==45 || user ==50) {
                System.out.println("User is either 45 OR 50");
            }
            else{
                System.out.println("User is older than 40");
            }
       

           // Haz un programa al que le pasas un entero y te dice el nombre del mes correspondiente.
           //Código para ver la diferencia de uso de if-else con switch
            Scanner teclado=new Scanner(System.in);
            int numero=teclado.nextInt();
            System.out.println();
            if (numero==1) {
                System.out.println("Enero");

                 }
             else if (numero==2) {
                System.out.println("Febrero");
                
             }
            else if (numero==3) {
                System.out.println("Marzo");
                
            }
            else if (numero==4) {
                System.out.println("Abril");
               }
            else if (numero==5) {
                System.out.println("Mayo");
                
            }
            else if (numero==6){
                System.out.println("Junio");
            }
            else if (numero==7) {
                System.out.println("Julio");
                
            }
            else if (numero==8) {
                System.out.println("Agosto");
                
            }
            else if (numero==9) {
                System.out.println("Septiembre");
                
            }
            else if (numero==10) {
                System.out.println("Octubre");
                
            }

            else if (numero==11) {
                System.out.println("Noviembre");
                
            }

            else if (numero==12) {
                System.out.println("Diciembre");
                
            }
        }

    }
