package lujo;

public class Turista {
      int id;
     String nombre;
     String apellidos;
     String direccion;
     String telefono;

     public Turista(){}

     public Turista(int id, String nombre, String apellidos, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public String getApellidos() {
         return apellidos;
     }

     public void setApellidos(String apellidos) {
         this.apellidos = apellidos;
     }

     public String getDireccion() {
         return direccion;
     }

     public void setDireccion(String direccion) {
         this.direccion = direccion;
     }

     public String getTelefono() {
         return telefono;
     }

     public void setTelefono(String telefono) {
         this.telefono = telefono;
     }

     @Override
     public String toString() {
        return "Turista [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
                + ", telefono=" + telefono + "]";
     }
     
}
