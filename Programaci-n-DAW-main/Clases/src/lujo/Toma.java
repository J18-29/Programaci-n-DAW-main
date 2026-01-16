package lujo;

public class Toma {

     Turista turista;
     Vuelo vuelo;
     Sucursal sucursal;

    public Toma(Turista turista, Vuelo vuelo, Sucursal sucursal) {
        this.turista = turista;
        this.vuelo = vuelo;
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Toma{turista=" + turista.getNombre() + ", vuelo=" + vuelo.getId() + "}";
    }
}

