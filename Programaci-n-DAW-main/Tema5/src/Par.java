public class Par<K,V> {
    private K clave;
    private V valor;

    public Par() {}
    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }
    public K getClave() {
        return clave;
    }
    public void setClave(K clave) {
        this.clave = clave;
    }
    public V getValor() {
        return valor;
    }
    public void setValor(V valor) {
        this.valor = valor;
    }

  public void mostrarPar() {
        System.out.println("Clave: " + clave + ", Valor: " + valor);
    }
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 25);
        par1.mostrarPar();

        Par<Integer, String> par2 = new Par<>(1, "Uno");
        par2.mostrarPar();
    }
}