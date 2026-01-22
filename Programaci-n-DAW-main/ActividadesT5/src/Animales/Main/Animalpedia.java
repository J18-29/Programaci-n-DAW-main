package Animales.Main;



import Animales.Animal;
import Animales.Vertebrados.*;
import Animales.Invertebrados.*;

public class Animalpedia {

    public static void main(String[] args) {

        Animal[] animales = {
            new Mamifero("Perro"),
            new Ave("Loro"),
            new Reptil("Lagarto"),
            new Anfibio("Rana"),
            new Pez("Salmón"),
            new Aracnido("Araña"),
            new Molusco("Caracol"),
            new Anelido("Lombriz"),
            new Equinodermo("Erizo de mar"),
            new Cefalopodo("Calamar")
        };

        for (Animal a : animales) {
            a.describir();
        }
    }
}

