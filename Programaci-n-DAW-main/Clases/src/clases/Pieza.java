package Clases;

public class Pieza {
    private int codigo;
    private String nombre;
    private String color;
    private double precio;

    private Categoria categoria;  // Relación pertenece

     //Constructores
    public Pieza(int codigo, String nombre, String color, double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.categoria = categoria;
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

    public String getColor() { 
        return color; 
    }
    public void setColor(String color) { 
        this.color = color; 
    }

    public double getPrecio() { 
        return precio;
     }
    public void setPrecio(double precio) { 
        this.precio = precio;
     }

    public Categoria getCategoria() { 
        return categoria; 
    }
    public void setCategoria(Categoria categoria) { 
        this.categoria = categoria;
     }
    
     //Imprimir resultado
    @Override
    public String toString() {
        return "Pieza [codigo=" + codigo + ", nombre=" + nombre + 
               ", color=" + color + ", precio=" + precio + 
               ", categoria=" + categoria.getNombre() + "]";
    }
}

