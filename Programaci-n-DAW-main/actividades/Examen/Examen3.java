package Examen;

import java.util.Scanner;

public class Examen3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Días de la semana
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        String[][] horario = {
            {"IPE", "Sist.Informaticos", "Bases de Datos","Bases de Datos", "Programación","Programación", },
            {"LMSGI,", "Sist.Informaticos","Sist.Informaticos" ,"Programación", "Programación","Ent.Desarrollo",},
            {"Bases de Datos", "Sist.Informaticos","Sist.informaticos", "Programación","Programación",},
            {"Programación", "Ent.Desarrollo","Ent.Desarrollo", "IPE", "Bases de Datos", "Sostenibilidad",},
            {"Bases de Datos", "Digitalización", "LMSGI","LMSGI", "IPE", "Programación",}
        };

        int opcion;
        do {
            // Mostramos menú
            System.out.println("\nMenú:");
            System.out.println("1 - Mostrar el horario completo");
            System.out.println("2 - Obtener clases de un día");
            System.out.println("3 - Obtener clases de una hora");
            System.out.println("4 - Modificar una clase");
            System.out.println("5 - Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    // Mostramos todo el horario
                    System.out.println("\nHorario completo:");
                    for (int i = 0; i < dias.length; i++) {
                        System.out.print(dias[i] + ": ");
                        for (int j = 0; j < horario[i].length; j++) {
                            System.out.print(horario[i][j] + " | ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    // Mostramos las clases de un día
                    System.out.print("Introduce el día (Lunes a Viernes): ");
                    String dia = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < dias.length; i++) {
                        if (dias[i].equalsIgnoreCase(dia)) {
                            System.out.println(dia + ": ");
                            for (int j = 0; j < horario[i].length; j++) {
                                System.out.println("Hora " + (j + 1) + ": " + horario[i][j]);
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Día no válido.");
                    }
                    break;

                case 3:
                    // Mostramos las clases de una hora
                    System.out.print("Introduce la hora (1 a 6): ");
                    int hora = sc.nextInt();
                    sc.nextLine();
                    if (hora < 1 || hora > horario[0].length) {
                        System.out.println("Hora no válida.");
                        break;
                    }
                    System.out.println("Clases en la hora " + hora + ":");
                    for (int i = 0; i < dias.length; i++) {
                        System.out.println(dias[i] + ": " + horario[i][hora - 1]);
                    }
                    break;

                case 4:
                    // Modificamos las clase
                    System.out.print("Introduce el día de origen: ");
                    String diaOrigen = sc.nextLine();
                    System.out.print("Introduce la hora de origen (1 a 6): ");
                    int horaOrigen = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduce el día de destino: ");
                    String diaDestino = sc.nextLine();
                    System.out.print("Introduce la hora de destino (1 a 6): ");
                    int horaDestino = sc.nextInt();
                    sc.nextLine();

                    int indexOrigen = -1, indexDestino = -1;
                    for (int i = 0; i < dias.length; i++) {
                        if (dias[i].equalsIgnoreCase(diaOrigen)) indexOrigen = i;
                        if (dias[i].equalsIgnoreCase(diaDestino)) indexDestino = i;
                    }

                    if (indexOrigen == -1 || indexDestino == -1 ||
                        horaOrigen < 1 || horaOrigen > horario[0].length ||
                        horaDestino < 1 || horaDestino > horario[0].length) {
                        System.out.println("Datos inválidos.");
                    } else {
                        // Intercambiamos clases
                        String temp = horario[indexOrigen][horaOrigen - 1];
                        horario[indexOrigen][horaOrigen - 1] = horario[indexDestino][horaDestino - 1];
                        horario[indexDestino][horaDestino - 1] = temp;
                        System.out.println("Clase modificada con éxito.");
                    }
                    break;
                  //Para ver las Clases modificadas pulsad la opcion 1 cuando os lo vuelva a preguntar
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
