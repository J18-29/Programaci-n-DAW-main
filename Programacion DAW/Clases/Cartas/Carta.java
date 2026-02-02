package Clases.Cartas;

public class Carta {
    int valor;
    String palo;
    
    
    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }


    public int getValor() {
        return valor;
    }


    public String getPalo() {
        return palo;
    }


    @Override
    public String toString() {
        return "Carta [valor=" + valor + ", palo=" + palo + "]";
    }


  

    
}
