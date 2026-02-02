package Prueba;

import Clases.Cartas.Juego;
import Clases.Cartas.Jugador;

public class ActividadCartas{
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Jugador 1");
        Juego juego = new Juego(jugador);

        juego.iniciar();
    }
}

