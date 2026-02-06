

import java.util.Date;

public class Entrevistas {
    public static void main(String[] args) {

        // Crear sucursal
        SucursalDAO sucursal = new SucursalDAO(1, "Calle Gran Vía", "Madrid", "Madrid", "910000000"
        );

        // Crear revista
        RevistaDAO revista = new RevistaDAO(100, "TechHoy", "Tecnología", "Mensual"
        );
        sucursal.publicarRevista(revista);

        // Crear secciones
        SeccionDAO s1 = new SeccionDAO("IA", 10);
        SeccionDAO s2 = new SeccionDAO("Programación", 15);
        revista.agregarSeccion(s1);
        revista.agregarSeccion(s2);

        // Crear ejemplar
        EjemplarDAO ej = new EjemplarDAO(new Date(), 50, 10000);
        revista.agregarEjemplar(ej);

        // Crear periodistas
        PeriodistaDAO p1 = new PeriodistaDAO(1, "Laura", "Gómez", "Ruiz", "600111222", "Inteligencia Artificial"
        );
        revista.agregarPeriodista(p1);

        // Crear empleado
        EmpleadoDAO emp = new EmpleadoDAO(1, "12345678A", "Carlos", "Pérez", "López", "600333444", sucursal
        );

        // Mostrar resultados
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Revista: " + revista);
        System.out.println("Secciones:");
        System.out.println(" - " + s1);
        System.out.println(" - " + s2);
        System.out.println("Ejemplar: " + ej);
        System.out.println("Periodista: " + p1);
        System.out.println("Empleado: " + emp);
    }
}
