package Interfaces;

public class Avion implements Movible, Sonoro {

    public Avion(String string) {
       
    }

    @Override
    public void mover() {
        System.out.println("El avión vuela por el cielo");
    }

    @Override
    public void emitirSonido() {
        System.out.println("El avión hace ruido de motores: ¡vroooom!");
    }
}
