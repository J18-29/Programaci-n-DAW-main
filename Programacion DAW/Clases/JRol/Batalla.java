package Clases.JRol;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Batalla {

    private ArrayList<Personaje> heroes = new ArrayList<>();
    private ArrayList<Personaje> orcos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    public void mostrarMenu() {
        int opcion;
           
        //Creamos el menu de opciones
        do {
            System.out.println("\n--- MENU BATALLA ---");
            System.out.println("1. Crear héroe (Caballero / Mago)");
            System.out.println("2. Crear orco");
            System.out.println("3. Mostrar listas");
            System.out.println("4. Iniciar batalla");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) sc.next(); 
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> crearPersonaje(false);
                case 2 -> crearPersonaje(true);
                case 3 -> muestraListas();
                case 4 -> iniciaBatalla();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }
     //Creacion del personaje
     //Nota:No le pongais vida negativa 
    public void crearPersonaje(boolean esOrco) {
        sc.nextLine(); 

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Vida: ");
        int vida = sc.nextInt();

        System.out.print("Ataque: ");
        int ataque = sc.nextInt();

        System.out.print("Defensa: ");
        int defensa = sc.nextInt();

        Tipo tipo;

        //Definimos si el personaje es un heroe elegimos si es mago o caballero
        if (esOrco) {
            tipo = Tipo.ORCO;
        } else {
            System.out.print("Tipo (1=Caballero, 2=Mago): ");
            int t = sc.nextInt();
            tipo = (t == 1 ? Tipo.CABALLERO : Tipo.MAGO);
        }
         
        //Mostramos el personaje creado
        Personaje p = new Personaje(nombre, vida, ataque, defensa, tipo);

        if (esOrco) {
            orcos.add(p);
        } else {
            heroes.add(p);
        }

        System.out.println("Personaje creado: " + p);
    }
  
     //Mostramos las lista de Ambos jugadores
     //Nota:Aseguraos de que habeis creado los personajes, si no las listas apareceran vacias
    public void muestraListas() {
        System.out.println("\n--- HÉROES ---");
        heroes.forEach(System.out::println);

        System.out.println("\n--- ORCOS ---");
        orcos.forEach(System.out::println);
    }

    //Inicamos la batalla
    public void iniciaBatalla() {

        if (heroes.isEmpty() || orcos.isEmpty()) {
            System.out.println("No hay suficientes personajes para la batalla.");
            return;
        }

        System.out.println("\n=== ¡COMIENZA LA BATALLA! ===");

        while (!heroes.isEmpty() && !orcos.isEmpty()) {

            Personaje h = heroes.get(rand.nextInt(heroes.size()));
            Personaje o = orcos.get(rand.nextInt(orcos.size()));

            System.out.println("\nCombate entre: " + h.getNombre() + " VS " + o.getNombre());

            h.atacar(o);
            o.atacar(h);

            System.out.println(h.getNombre() + " vida restante: " + h.getVida());
            System.out.println(o.getNombre() + " vida restante: " + o.getVida());

            if (!h.estaVivo()) {
                System.out.println(h.getNombre() + " ha muerto.");
                heroes.remove(h);
            }

            if (!o.estaVivo()) {
                System.out.println(o.getNombre() + " ha muerto.");
                orcos.remove(o);
            }
        }

        //Mostramos el resultado de la batalla
        if (heroes.isEmpty()) {
            System.out.println("\n=== ¡LOS ORCOS GANAN! ===");
        } else {
            System.out.println("\n=== ¡LOS HÉROES GANAN! ===");
        }

        muestraListas();
    }
}
