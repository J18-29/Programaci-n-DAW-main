package Abstractas;

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
        System.out.println(nombre + " recibe " + daño + " de daño. Vida restante: " + vida);
    }

    public String getNombre() {
        return nombre;
    }

    public abstract int atacar();
}
