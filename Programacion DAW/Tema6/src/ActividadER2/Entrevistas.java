

import java.util.Date;

public class Entrevistas {
    public static void main(String[] args) {

        // Crear sucursal
        SucursalDAO2 sucursal = new SucursalDAO2(0, "Calle Gran Vía", "Madrid", null, null
        );

        // Crear revista
        RevistaDAO2 revista = new RevistaDAO2(100, "TechHoy", null, null
        );
        sucursal.publicarRevista(revista);

        // Crear secciones
        SeccionDAO2 s1 = new SeccionDAO2("IA", 10);
        SeccionDAO2 s2 = new SeccionDAO2("Programación", 15);
        revista.agregarSeccion(s1);
        revista.agregarSeccion(s2);

        // Crear ejemplar
        EjemplarDAO2 ej = new EjemplarDAO2(new Date(), 50, 10000);
        revista.agregarEjemplar(ej);

        // Crear periodistas
        PeriodistaDAO2 p1 = new PeriodistaDAO2(1, "Laura", "Gómez", "Ruiz", "600111222", "Inteligencia Artificial"
        );
        revista.agregarPeriodista(p1);

        // Crear empleado
        EmpleadoDAO2 emp = new EmpleadoDAO2(1, "12345678A", "Carlos", "Pérez", "López", "600333444", sucursal
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
