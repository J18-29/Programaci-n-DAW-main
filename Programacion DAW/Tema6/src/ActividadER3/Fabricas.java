public class Fabricas {
    public static void main(String[] args) {
        
        Revista rev = new Revista(101, "Mundo Tech");
        
       
        rev.secciones.add(new Seccion("Hardware", 12));
        rev.secciones.add(new Seccion("Software", 15));
        
        
        rev.ejemplares.add(new Ejemplar("01-02-2024", 60, 1000));
        
        
        Periodista p1 = new Periodista("P-01", "Lucía García", "IA");
        rev.periodistas.add(p1);

        
        System.out.println("\n===========================================");
        System.out.println("       SISTEMA DE GESTIÓN EDITORIAL       ");
        System.out.println("===========================================");
        
        System.out.println("REVISTA: " + rev.getTitulo());
        System.out.println("ESCRITA POR: " + rev.periodistas.get(0)); 
        System.out.println("\n--- DETALLES DE CONTENIDO ---");
        for (Seccion s : rev.secciones) {
            System.out.println(" > " + s.getInfo());
        }

        System.out.println("\n--- REGISTRO DE EJEMPLARES ---");
        for (Ejemplar e : rev.ejemplares) {
            System.out.println(" [OK] " + e.getInfo());
        }
        
        System.out.println("===========================================\n");
    }
}