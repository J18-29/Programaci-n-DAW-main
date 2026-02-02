package Interfaces;

public class PartidodeFutbol {
    public static void main(String[] args) {

        Futbolista f1 = new Futbolista(1, "Leo", "Messi", 36, 10, "Delantero");
        Entrenador e1 = new Entrenador(2, "Lionel", "Scaloni", 45, 123);
        Masajista m1 = new Masajista(3, "Juan", "Perez", 50, "Fisioterapeuta", 20);

        f1.concentrarse();
        f1.entrenar();
        f1.jugarPartido();
        f1.entrevista();

        e1.planificarEntrenamiento();

        m1.darMasaje();
    }
}
