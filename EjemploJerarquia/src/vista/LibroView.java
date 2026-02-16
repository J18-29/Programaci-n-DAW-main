package src.Vista;



import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import src.Modelo.Ebook;
import src.Modelo.Libro;
import src.Modelo.Papel;


public class LibroView {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ PERSONAS ---");
        System.out.println("1. Listar Libros Papel");
        System.out.println("2. Listar Libros Ebook");
        System.out.println("3. Insertar Libro Papel");
        System.out.println("4. Insertar Libro Ebook");
        System.out.println("5. Eliminar Libro Papel");
        System.out.println("6. Eliminar Ebook");
        System.out.println("7. Obtener Libro Papel");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }
    public void mostrarLibros(List<Libro> libros) {
        System.out.println("\nLISTADO:");
        for (Libro l : libros) {
            if (l instanceof Papel){
                Papel p= (Papel)l;
                System.out.println(p.getId() + " - "+p.getIsbn()+" - "+ p.getTitulo()+" - "+" - "+p.getAnyo_publicacion()+" - "+p.getFecha_impresion()+" - "+p.getPrecio());
            }
            else{
                Ebook p= (Ebook)l;
                System.out.println(p.getId() + " - "+p.getIsbn()+" - "+ p.getTitulo()+" - "+" - "+p.getAnyo_publicacion()+" - "+p.getTamanyo()+" - "+p.getPrecio());
            }
        }
    }
    public void mostrarLibro(Libro l) {
        if (l instanceof Papel){
            Papel p= (Papel)l;
            System.out.println(p.getId() + " - "+p.getIsbn()+" - "+ p.getTitulo()+" - "+" - "+p.getAnyo_publicacion()+" - "+p.getFecha_impresion()+" - "+p.getPrecio());
        }
        else{
            Ebook p= (Ebook)l;
            System.out.println(p.getId() + " - "+p.getIsbn()+" - "+ p.getTitulo()+" - "+" - "+p.getAnyo_publicacion()+" - "+p.getTamanyo()+" - "+p.getPrecio());
        }
    }
    public Papel pedirNuevoLibroPapel() {
        sc.nextLine();
        System.out.print("ID: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Fecha publicación: ");
        Date anyo_publicacion = Date.valueOf(sc.nextLine());
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Fecha impresión: ");
        Date fecha_impresion = Date.valueOf(sc.nextLine());
        System.out.print("Lugar de impresión: ");
        String lugar_impresion = sc.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        return new Papel(id,isbn,anyo_publicacion,titulo, descripcion,0,fecha_impresion,lugar_impresion,precio);
    }
    public Ebook pedirNuevoLibroEbook() {
        sc.nextLine();
        System.out.print("ID: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Fecha publicación: ");
        Date anyo_publicacion = Date.valueOf(sc.nextLine());
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Tamaño: ");
        String tamanyo = sc.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        return new Ebook(id,isbn,anyo_publicacion,titulo, descripcion,0,tamanyo,precio);
    }
    
    public int pedirIdLibro() {
        System.out.print("ID del libro: ");
        return sc.nextInt();
    }

    public int pedirIdEliminar() {
        System.out.print("ID a eliminar: ");
        return sc.nextInt();
    }
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}