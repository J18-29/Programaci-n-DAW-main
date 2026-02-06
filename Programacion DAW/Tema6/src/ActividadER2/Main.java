

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Crear provincia y localidad
        ProvinciaDAO madrid = new ProvinciaDAO(1, "Madrid");
        LocalidadDAO alcala = new LocalidadDAO(1, "Alcalá de Henares", madrid);

        // Crear cliente
        ClienteDAO cliente = new ClienteDAO(1,"Carlos","Ruiz","Gómez","Calle Mayor", "carlos@email.com", "600123456",alcala);

        // Crear autor y editorial
        AutorDAO autor = new AutorDAO(1, "Miguel", "Cervantes", "Saavedra");
        EditorialDAO editorial = new EditorialDAO(1, "Editorial Clásicos");

        // Crear libro
        LibroConcretoDAO libro1 = new LibroConcretoDAO(1, "Don Quijote", "ISBN123", 1605, 25.99);
      libro1.agregarAutor(autor);
      libro1.setEditorial(editorial);


        // Crear cesta de compra usando LocalDate
        CestaDAO cesta = new CestaDAO(1, LocalDate.now(), cliente);
        cesta.agregarLibro(libro1, 2);

        // Crear almacén y almacenar libro
        AlmacenDAO almacen = new AlmacenDAO(1, "Polígono Norte", "911223344");
        almacen.almacenarLibro(libro1, 50);

        // Mostrar resultados
        System.out.println(cliente);
        System.out.println(cesta);
        System.out.println("Libro comprado: " + libro1);
        System.out.println("Autor: " + autor);
        System.out.println("Editorial: " + editorial);
    }
}
