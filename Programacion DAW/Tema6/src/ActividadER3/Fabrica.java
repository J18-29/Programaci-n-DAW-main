public class Fabrica {
    public static void main(String[] args) {
        SucursalDAO s = new SucursalDAO("S1", "Calle Mayor");
        RevistaDAO r = new RevistaDAO(1, "Revista Prueba");

        s.getRevistas().add(r);

        System.out.println(r.getTitulo());
    }
}
