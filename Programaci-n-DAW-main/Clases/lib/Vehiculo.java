public class Vehiculo {
    boolean useFlag;
    String model;
    int numTires;
//Constructor
public Vehiculo(boolean useF,String modelo,int numT){
    useFlag=useF;
    model=modelo;
    numTires=numT;
}
//Métodos de la clase
public void start(){
  System.out.println("Arranca");
}
public void turnLeft(){
   System.out.println("Moverse a la izquierda");
}
public void turnRight(){
    System.out.println("Moverse a la derecha"); 
}
public void stop(){
     System.out.println("Detenerse");
}
public void foward(int speed){
     System.out.println("Moverse hacia delante a una velocidad" +speed);
}
public static void imprimirDatos() {
    System.out.println("Estas en un concesionario");
}
public static void main(String[] args) {
    System.out.println("CREACION DE CLASE VEHICULO Y OBJETOS");
    Vehiculo moto = new Vehiculo(false,"Honda",2);
    Vehiculo coche = new Vehiculo(true,"Toyota",4);
    //Usando Objetos
    moto.start();
    moto.turnLeft();
    moto.foward(100);

    coche.start();
    coche.turnRight();
    coche.foward(120);
     
    coche.foward(12);
}
}
