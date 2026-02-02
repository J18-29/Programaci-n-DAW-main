import java.util.ArrayList;
import java.util.Random;

public class NotasAlumnosArray {
    public static void main(String[] args) {
        // Lista de alumnos
        ArrayList<String> alumnos = new ArrayList<>();
        alumnos.add("José");
        alumnos.add("Ana");
        alumnos.add("María");
        alumnos.add("Luis");
        alumnos.add("Domingo");

        // Lista de módulos
        ArrayList<String> modulos = new ArrayList<>();
        modulos.add("Programación");
        modulos.add("Entornos");
        modulos.add("Bases de Datos");
        modulos.add("Sistemas");

        // Estructura para las notas: una lista de listas (una fila por alumno)
        ArrayList<ArrayList<Double>> notas = new ArrayList<>();

        // Inicializar la matriz con ceros
        for (int i = 0; i < alumnos.size(); i++) {
            ArrayList<Double> filaNotas = new ArrayList<>();
            for (int j = 0; j < modulos.size(); j++) {
                filaNotas.add(0.0);
            }
            notas.add(filaNotas);
        }

        // Generar notas aleatorias
        generarNotasAleatorias(notas);

        // Mostrar resultados en forma de tabla
        mostrarNotas(alumnos, modulos, notas);
    }

    // Genera notas aleatorias del 0 al 10
    public static void generarNotasAleatorias(ArrayList<ArrayList<Double>> notas) {
        Random random = new Random();
        for (int i = 0; i < notas.size(); i++) {
            for (int j = 0; j < notas.get(i).size(); j++) {
                notas.get(i).set(j, Math.round(random.nextDouble() * 100.0) / 10.0); // Ej: 0.0 a 10.0
            }
        }
    }

    // Muestra la tabla de notas
    public static void mostrarNotas(ArrayList<String> alumnos, ArrayList<String> modulos, ArrayList<ArrayList<Double>> notas) {
        System.out.println("\n📋 TABLA DE NOTAS DE ALUMNOS\n");

        // Encabezado
        System.out.printf("%-10s", "Alumno");
        for (String modulo : modulos) {
            System.out.printf("%15s", modulo);
        }
        System.out.printf("%15s%n", "Media");

        System.out.println("--------------------------------------------------------------------------------");

        // Mostrar cada fila (alumno y sus notas)
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.printf("%-10s", alumnos.get(i));
            double suma = 0;
            for (int j = 0; j < modulos.size(); j++) {
                double nota = notas.get(i).get(j);
                suma += nota;
                System.out.printf("%15.1f", nota);
            }
            double media = suma / modulos.size();
            System.out.printf("%15.2f%n", media);
        }
    }
}

