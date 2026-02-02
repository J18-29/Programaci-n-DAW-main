package Agenda.src;

public class Agenda {
    public static void main(String[] args) throws Exception {
       //Necesito tener un vector de personas
       Persona [] lista=new Persona[5];
       lista[1]=new Persona();
       
       //Imprimir las personas
       for(int i=0;i< lista.length;i++){
           lista[i].imprimePersona();
       }
    }
}
