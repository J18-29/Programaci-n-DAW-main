package Clases.BlackJack;

public class Cartas {

    // Atributos de la carta: su valor y su palo
    private String valor; // Puede ser "2", "3", ..., "10", "J", "Q", "K", "A"
    private String palo;  // Puede ser "Corazones", "Diamantes", "Tréboles", "Picas"

    // Constructor de la carta: recibe el valor y el palo
    public Cartas(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    // Método para obtener el valor como cadena
    public String getValor() {
        return valor;
    }

    // Método que devuelve el valor numérico de la carta según las reglas del juego
    public int getValorJuego() {
        if ("JQK".contains(valor)) return 10; // J, Q, K valen 10 puntos
        if ("A".equals(valor)) return 11;     // As vale 11 puntos (podría ajustarse según reglas)
        return Integer.parseInt(valor);       // Los números del 2 al 10 conservan su valor
    }

    
    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}

