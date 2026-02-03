
public class Main {
    public static void main(String[] args) {
        
        Coche coche1 = new Coche("1234ABC");
        Moto moto1 = new Moto("5678DEF");
        Parkeable parkeable1 = new Parkeable("9012GHI");

        coche1.entrar();
        moto1.entrar();
        parkeable1.entrar();

        int horasCoche = (int) (Math.random() * 24) + 1;
        int horasMoto = (int) (Math.random() * 24) + 1;
       

        System.out.println("El coche ha estado " + horasCoche + " horas.");
        System.out.println("El coche paga: " + coche1.calcularTarifa(horasCoche) + " euros.");

        System.out.println("La moto ha estado " + horasMoto + " horas.");
        System.out.println("La moto paga: " + moto1.calcularTarifa(horasMoto) + " euros.");

      

        coche1.salir();
        moto1.salir();
        parkeable1.salir();

    }
}