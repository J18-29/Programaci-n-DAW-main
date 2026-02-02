package lujo;
public class Reserva {

     Turista turista;
     Hotel hotel;
     Sucursal sucursal;

     String fechaEntrada;
     String fechaSalida;
     String regimen;

     public Reserva(){}
     
    public Reserva(Turista turista, Hotel hotel, Sucursal sucursal,
                   String fechaEntrada, String fechaSalida, String regimen) {
        this.turista = turista;
        this.hotel = hotel;
        this.sucursal = sucursal;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.regimen = regimen;
    }

    @Override
    public String toString() {
        return "Reserva{turista=" + turista.getNombre() + ", hotel=" + hotel.getNombre() + "}";
    }
}
