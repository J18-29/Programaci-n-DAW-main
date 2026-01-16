package Prueba;

import Trenes.Locomotora;
import Trenes.Maquinistas;
import Trenes.Mecánico;
import Trenes.Tren;
import Trenes.Vagón;

public class Actividad9Clase {
    public static void main(String[] args) {

        // Mecánicos
        Mecánico m1 = new Mecánico("Luis", "123A", "600111222", Mecánico.Especialidad.FRENOS);
        Mecánico m2 = new Mecánico("Ana", "456B", "600333444", Mecánico.Especialidad.MOTOR);
        Mecánico m3 = new Mecánico("Carlos", "789C", "600555666", Mecánico.Especialidad.ELECTRICIDAD);

        // Maquinistas
        Maquinistas maq1 = new Maquinistas("Pedro", "111A", 2000, "Senior");
        Maquinistas maq2 = new Maquinistas("María", "222B", 1800, "Junior");
        Maquinistas maq3 = new Maquinistas("Jorge", "333C", 2200, "Veterano");

        // Locomotoras
        Locomotora l1 = new Locomotora("LOC-001", 3000, 1998, m1);
        Locomotora l2 = new Locomotora("LOC-002", 3500, 2005, m2);
        Locomotora l3 = new Locomotora("LOC-003", 2800, 2010, m3);

        // Tren 1 → 3 vagones
        Vagón[] vagones1 = {
                new Vagón(1, 20000, 15000, "Carbón"),
                new Vagón(2, 18000, 12000, "Trigo"),
                new Vagón(3, 25000, 20000, "Acero")
        };

        // Tren 2 → 4 vagones
        Vagón[] vagones2 = {
                new Vagón(1, 15000, 10000, "Madera"),
                new Vagón(2, 16000, 8000, "Piedra"),
                new Vagón(3, 17000, 12000, "Arena"),
                new Vagón(4, 20000, 15000, "Hierro")
        };

        // Tren 3 → 2 vagones
        Vagón[] vagones3 = {
                new Vagón(1, 30000, 25000, "Petróleo"),
                new Vagón(2, 22000, 18000, "Gas")
        };

        // Crear trenes
        Tren t1 = new Tren(l1, maq1, vagones1);
        Tren t2 = new Tren(l2, maq2, vagones2);
        Tren t3 = new Tren(l3, maq3, vagones3);

        // Mostrar información
        t1.mostrarInfo();
        t2.mostrarInfo();
        t3.mostrarInfo();
    }
}

