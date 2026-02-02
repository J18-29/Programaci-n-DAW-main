package Herencia;

public class Granja {
    public static void main(String[] args) {

        Perro perro = new Perro("Max", "Carnívoro", 5, 63, "Labrador");
        Gato gato = new Gato("Michi", "Carnívoro", 3, 65, "Sí");
        Caballo caballo = new Caballo("Relámpago", "Herbívoro", 7, 340,
                                      "Pasto y avena", 3);

        perro.mostrarInfo();
        gato.mostrarInfo();
        caballo.mostrarInfo();
    }
}
