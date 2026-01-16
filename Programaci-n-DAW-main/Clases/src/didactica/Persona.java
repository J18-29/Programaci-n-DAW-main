package didactica;


    import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

enum ESTUDIOS{
    ESO,BACHILLERATO,UNIVERSIDAD,DOCTORADO
}

public class Persona {
    // === Atributos ===
    private String dni;
    private LocalDate fechaNacimiento;
    public int hijos;
    private Persona pareja;
    ESTUDIOS educacion;

    // === Constructores ===
    public Persona(String dni, String fechaNacimiento) {
        this.dni = dni;
        this.hijos = 0; // por defecto
        setFechaNacimiento(fechaNacimiento);
        educacion=ESTUDIOS.ESO; 
    }

    public Persona(String dni, String fechaNacimiento, int hijos) {
        this.dni = dni;
        this.hijos = hijos;
        setFechaNacimiento(fechaNacimiento);
    }

    // === Setter con control de formato de fecha ===
    public void setFechaNacimiento(String fechaNacimiento) {
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
            this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formato);
        } catch (DateTimeParseException e) {
            System.out.println("Error: formato de fecha incorrecto. Usa formato dd/MM/yyyy");
            this.fechaNacimiento = null;
        }
    }

    // === Obtener edad ===
    public int obtenerEdad() {
        if (fechaNacimiento == null) {
            System.out.println("No se puede calcular edad: fecha no válida");
            return -1;
        }
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return edad;
    }

    // === Asigna pareja ===
    public void asignaPareja(Persona p) {
        this.pareja = p;
    }

    // === Mostrar datos ===
    public void mostrarDatos() {
        System.out.println("------------------------");
        System.out.println("DNI: " + dni);
        if (fechaNacimiento != null)
            System.out.println("Fecha de nacimiento: " + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Edad: " + obtenerEdad() + " años");
        System.out.println("Hijos: " + hijos);
        if (pareja != null) {
            System.out.println("Pareja: " + pareja.dni);
        } else {
            System.out.println("Pareja: no tiene");
        }
        System.out.println("------------------------");
    }

    // === MAIN ===
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== PROGRAMA DE PERSONAS ===");

        // === 1) Crear personas ===
        System.out.println("\n[1] Crear primera persona");
        System.out.print("Introduce el DNI: ");
        String dni1 = sc.nextLine();
        System.out.print("Introduce la fecha de nacimiento (dd/MM/yyyy): ");
        String fecha1 = sc.nextLine();
        System.out.print("Introduce el número de hijos: ");
        int hijos1 = Integer.parseInt(sc.nextLine());

        Persona p1 = new Persona(dni1, fecha1, hijos1);

        System.out.println("\n[1] Crear segunda persona");
        System.out.print("Introduce el DNI: ");
        String dni2 = sc.nextLine();
        System.out.print("Introduce la fecha de nacimiento (dd/MM/yyyy): ");
        String fecha2 = sc.nextLine();
        System.out.print("Introduce el número de hijos: ");
        int hijos2 = Integer.parseInt(sc.nextLine());

        Persona p2 = new Persona(dni2, fecha2, hijos2);

        // === 2) Asignar pareja y mostrar datos ===
        System.out.println("\n[2] Asignando pareja...");
        p1.asignaPareja(p2);
        p2.asignaPareja(p1);

        System.out.println("\nDatos de las personas con pareja asignada:");
        p1.mostrarDatos();
        p2.mostrarDatos();

        // === 3) Cambiar atributo de p2 y ver si cambia en la pareja ===
        System.out.println("\n[3] Cambiar un atributo de p2");
        System.out.print("Introduce nuevo número de hijos para p2: ");
        p2.hijos = Integer.parseInt(sc.nextLine());

        System.out.println("\nDatos actualizados:");
        p1.mostrarDatos();
        p2.mostrarDatos();

        // === 4) Probar formato de fecha incorrecto ===
        System.out.println("\n[4] Intentar insertar una fecha con formato erróneo");
        System.out.print("Introduce el DNI: ");
        String dni3 = sc.nextLine();
        System.out.print("Introduce la fecha (por ejemplo 1987-01-05): ");
        String fecha3 = sc.nextLine();

        Persona p3 = new Persona(dni3, fecha3);
        p3.obtenerEdad(); // muestra mensaje de error si formato inválido

        System.out.println("\nDatos de la persona con fecha incorrecta:");
        p3.mostrarDatos();

        sc.close();
        System.out.println("\n Programa finalizado.");
    }
}

