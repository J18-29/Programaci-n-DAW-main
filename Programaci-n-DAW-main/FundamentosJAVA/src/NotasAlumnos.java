import java.util.Random;
import java.util.Arrays;

public class NotasAlumnos {

    // Datos iniciales
    public static String[] alumnos = {"José", "Ana", "María", "Luis", "Domingo"};
    public static String[] modulos = {"Programación", "Entornos", "Bases Datos", "Sistemas"};
    public static double[][] notas = new double[alumnos.length][modulos.length];

    public static void main(String[] args) {
        generarNotasAleatorias();
        mostrarTablaNotas();

        System.out.println("\n=== ESTADÍSTICAS DE UN ALUMNO ===");
        String alumno = "Ana";
        mostrarEstadisticasAlumno(alumno);

        System.out.println("\n=== ALUMNOS QUE HAN SUPERADO CADA MÓDULO ===");
        alumnosQueSuperanModulo();

        System.out.println("\n=== MÓDULOS APROBADOS POR CADA ALUMNO ===");
        modulosAprobadosPorAlumno();

        System.out.println("\n=== AÑADIR UN NUEVO ALUMNO ===");
        anadirAlumno("Carlos", new double[]{6.5, 8.0, 7.5, 9.0});
        mostrarTablaNotas();

        System.out.println("\n=== ELIMINAR MÓDULO DE PROGRAMACIÓN ===");
        eliminarModulo("Programación");
        mostrarTablaNotas();
    }

    // 1) Generar notas aleatorias
    public static void generarNotasAleatorias() {
        Random rand = new Random();
        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < modulos.length; j++) {
                notas[i][j] = Math.round((rand.nextDouble() * 10) * 10.0) / 10.0; // nota entre 0 y 10 con un decimal
            }
        }
    }

    // Mostrar tabla de notas
    public static void mostrarTablaNotas() {
        System.out.printf("%-10s", "Alumno");
        for (String m : modulos) {
            System.out.printf("%-15s", m);
        }
        System.out.println();

        for (int i = 0; i < alumnos.length; i++) {
            System.out.printf("%-10s", alumnos[i]);
            for (int j = 0; j < modulos.length; j++) {
                System.out.printf("%-15.1f", notas[i][j]);
            }
            System.out.println();
        }
    }

    // 2) Calificación media, máximo y mínimo de un alumno
    public static void mostrarEstadisticasAlumno(String nombre) {
        int index = Arrays.asList(alumnos).indexOf(nombre);
        if (index == -1) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        double suma = 0, max = 0, min = 10;
        for (double n : notas[index]) {
            suma += n;
            if (n > max) max = n;
            if (n < min) min = n;
        }
        double media = Math.round((suma / notas[index].length) * 10.0) / 10.0;

        System.out.println("Alumno: " + nombre);
        System.out.println("Media: " + media);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
    }

    // 3) ¿Cuántos alumnos han superado un módulo?
    public static void alumnosQueSuperanModulo() {
        for (int j = 0; j < modulos.length; j++) {
            int contador = 0;
            for (int i = 0; i < alumnos.length; i++) {
                if (notas[i][j] >= 5.0) contador++;
            }
            System.out.println("Módulo " + modulos[j] + ": " + contador + " alumnos aprobados");
        }
    }

    // 4) ¿Cuántos módulos aprueba un alumno?
    public static void modulosAprobadosPorAlumno() {
        for (int i = 0; i < alumnos.length; i++) {
            int contador = 0;
            for (int j = 0; j < modulos.length; j++) {
                if (notas[i][j] >= 5.0) contador++;
            }
            System.out.println(alumnos[i] + " aprueba " + contador + " módulo(s)");
        }
    }

    // 5a) Añadir un nuevo alumno con sus calificaciones (memoria dinámica)
    public static void anadirAlumno(String nuevoAlumno, double[] nuevasNotas) {
        if (nuevasNotas.length != modulos.length) {
            System.out.println("Error: número de notas no coincide con los módulos.");
            return;
        }

        alumnos = Arrays.copyOf(alumnos, alumnos.length + 1);
        alumnos[alumnos.length - 1] = nuevoAlumno;

        double[][] nuevasNotasMatriz = new double[alumnos.length][modulos.length];
        for (int i = 0; i < notas.length; i++) {
            nuevasNotasMatriz[i] = Arrays.copyOf(notas[i], modulos.length);
        }
        nuevasNotasMatriz[alumnos.length - 1] = nuevasNotas;
        notas = nuevasNotasMatriz;

        System.out.println("Alumno " + nuevoAlumno + " añadido correctamente.");
    }

    // 5b) Eliminar un módulo y sus notas
    public static void eliminarModulo(String moduloAEliminar) {
        int index = Arrays.asList(modulos).indexOf(moduloAEliminar);
        if (index == -1) {
            System.out.println("Módulo no encontrado.");
            return;
        }

        // Eliminar columna de notas
        double[][] nuevasNotas = new double[alumnos.length][modulos.length - 1];
        for (int i = 0; i < alumnos.length; i++) {
            int col = 0;
            for (int j = 0; j < modulos.length; j++) {
                if (j != index) {
                    nuevasNotas[i][col++] = notas[i][j];
                }
            }
        }

        // Eliminar módulo del array
        String[] nuevosModulos = new String[modulos.length - 1];
        int k = 0;
        for (int j = 0; j < modulos.length; j++) {
            if (j != index) nuevosModulos[k++] = modulos[j];
        }

        modulos = nuevosModulos;
        notas = nuevasNotas;

        System.out.println("Módulo " + moduloAEliminar + " eliminado correctamente.");
    }
}

