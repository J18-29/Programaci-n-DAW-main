package Clases.Cartas;

public class Jugador {
    private String nombre;
    private int puntuacion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
    }

    public void sumarPunto() {
        puntuacion++;
    }

  public void restarPunto() {
    if (puntuacion > 0) {
        puntuacion--;
    }
}


    public int getPuntuacion() {
        return puntuacion;
    }

    public String getNombre() {
        return nombre;
    }
}
