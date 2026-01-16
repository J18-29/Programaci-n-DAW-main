package Herencia;

public abstract class Personaje {
    protected String nombre;
    protected int vida;

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDaño(int daño) {
        vida -= daño;
        if (vida < 0) {
            vida = 0;
        }
    }

    // Método abstracto
    public abstract int atacar();

    public void mostrarEstado() {
        System.out.println(nombre + " - Vida: " + vida);
    }

    public String getNombre() {
        return nombre;
    }
}
