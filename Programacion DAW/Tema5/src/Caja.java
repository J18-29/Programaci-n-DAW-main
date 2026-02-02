

public class Caja<T> {
    private T contenido;

    public Caja() {}
    public Caja(T dato) {
        this.contenido = dato;
    }

    public  void guardar(T valor){
        this.contenido =valor;
    }
    public T obtener(){
        return contenido;
    }

    public static void main(String[] args) {
        Caja<Integer> caja1= new Caja<Integer>(10);
        caja1.guardar(20);
        Caja<String> caja2= new Caja<>();
        caja2.guardar("Hola Mundo");
       
        System.out.println("Contenido caja1: " + caja1.obtener());
    }
}
