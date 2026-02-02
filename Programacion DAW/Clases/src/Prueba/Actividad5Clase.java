package Prueba;

import java.time.LocalDateTime;

import Clases.Categoria;
import Clases.Pieza;
import Clases.Proveedor;
import Clases.ProveedorSuministraPieza;

//Crear Clases
public class Actividad5Clase {
    public static void main(String[] args) {
        Categoria cat = new Categoria(1, "Electrónica");
        Pieza p = new Pieza(101, "Resistencia", "Rojo", 0.15, cat);
        Proveedor prov = new Proveedor(500, "C/ Mayor 12", "Madrid", "Madrid");

        ProveedorSuministraPieza rel =
            new ProveedorSuministraPieza(prov, p, LocalDateTime.now(), 300);

        System.out.println(cat);
        System.out.println(p);
        System.out.println(prov);
        System.out.println(rel);
    }
}
