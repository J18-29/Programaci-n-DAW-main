// Clase genérica Caja
public class Caja<T> {

    private T valor;

    // Constructor
    public Caja(T valor) {
        this.valor = valor;
    }

    // Getter
    public T getValor() {
        return valor;
    }

    // Setter
    public void setValor(T valor) {
        this.valor = valor;
    }

    // Método de salida
    public void mostrar() {
        System.out.println("El valor de la caja es: " + valor);
    }

    // toString
    @Override
    public String toString() {
        return "Caja{" + "valor=" + valor + '}';
    }

    // Pruebas de uso
    public static void main(String[] args) {

        // Caja de enteros
        Caja<Integer> cajaEnteros = new Caja<>(10);
        cajaEnteros.mostrar();
        cajaEnteros.setValor(25);
        System.out.println(cajaEnteros);

        // Caja de cadenas
        Caja<String> cajaTexto = new Caja<>("Hola mundo");
        cajaTexto.mostrar();

        // Caja de decimales
        Caja<Double> cajaDouble = new Caja<>(3.14);
        System.out.println("Valor double: " + cajaDouble.getValor());

        // Caja de objetos (por ejemplo, Boolean)
        Caja<Boolean> cajaBoolean = new Caja<>(true);
        cajaBoolean.mostrar();
    }
}
