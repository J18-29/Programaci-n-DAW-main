package Prueba;

 class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}
//Clase que usa la excepción
public class RegistroUsuario{
    public void registrarUsuario(String nombre, int edad) throws EdadInvalidaException {
        if (edad < 18) {
            throw new EdadInvalidaException("La edad minima para registrarse es de 18 y"+nombre+" NO la cumple");
        }
        System.out.println("Usuario " + nombre + " registrado con éxito.");
    }
    public static void main(String[] args) {
        RegistroUsuario registro = new RegistroUsuario();
        try {
            registro.registrarUsuario("Domingo", 40);
            registro.registrarUsuario("Ana", 18);
            registro.registrarUsuario("Luis", 17);
        } catch (EdadInvalidaException e) {
            System.out.println("Error : " + e.getMessage());
        }

        
    }
}
