package Clases;

public class Proveedor {
    private int codigo;
    private String direccion;
    private String ciudad;
    private String provincia;

     //Constructor
    public Proveedor(int codigo, String direccion, String ciudad, String provincia) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

     //Get y Set
    public int getCodigo() { 
        return codigo; 
    }
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }

    public String getDireccion() { 
        return direccion; 
    }
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }

    public String getCiudad() { 
        return ciudad; 
    }
    public void setCiudad(String ciudad) { 
        this.ciudad = ciudad; 
    }

    public String getProvincia() { 
        return provincia;
     }
    public void setProvincia(String provincia) { 
        this.provincia = provincia;
     }
     
     //Imprimir resultado
    @Override
    public String toString() {
        return "Proveedor [codigo=" + codigo + ", direccion=" + direccion + 
               ", ciudad=" + ciudad + ", provincia=" + provincia + "]";
    }
}

