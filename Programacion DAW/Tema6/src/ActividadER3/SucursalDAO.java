import java.util.ArrayList;
import java.util.List;

public class SucursalDAO {

    private String codigo;
    private String direccion;
    private List<RevistaDAO2> revistas;

    
    public SucursalDAO(String codigo, String direccion) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.revistas = new ArrayList<>();
    }

    
    public List<RevistaDAO2> getRevistas() {
        return revistas;
    }


    @Override
    public String toString() {
        return "SucursalDAO [codigo=" + codigo + ", direccion=" + direccion + ", revistas=" + revistas + "]";
    }


    

    
}
