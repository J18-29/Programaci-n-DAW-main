
public class Aparcamientos {
    public static void main(String[] args) {
        
        Parkeable coche1 = new Coche("1234ABC");
        Parkeable moto1 = new Moto("5678DEF");  
        

        coche1.entrar();
        moto1.entrar();
       
        double tarifaCoche = coche1.calcularTarifa(3);
        double tarifaMoto = moto1.calcularTarifa(3);    
        
        System.out.println("Tarifa del coche: " + tarifaCoche + " euros.");
        System.out.println("Tarifa de la moto: " + tarifaMoto + " euros.");
        coche1.salir();
        moto1.salir();  
    }
}