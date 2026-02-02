package Clases;

public class Ciudad {
    private int codigo;
    private String nombre;
    private int indicativo;

    // Constructor
    public Ciudad(int codigo, String nombre, int indicativo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.indicativo = indicativo;
    }

    // Getters y Setters
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

    public int getIndicativo() { 
        return indicativo; 
    }
    public void setIndicativo(int indicativo) {
         this.indicativo = indicativo;
         }

    // Mostrar información
    public void mostrarCiudad() {
        System.out.println("Ciudad: " + nombre + " (Código: " + codigo + ", Indicativo: " + indicativo + ")");
    }
}

