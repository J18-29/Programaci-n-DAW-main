package Clases;

public class Categoria {
    private int codigo;
    private String nombre;


     //Constructor
    public Categoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //Get y Set
    public int getCodigo() { 
        return codigo; 
    }
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }

    public String getNombre() {
         return nombre; 
        }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    //Imprimir resultado
    @Override
    public String toString() {
        return "Categoria [codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}

