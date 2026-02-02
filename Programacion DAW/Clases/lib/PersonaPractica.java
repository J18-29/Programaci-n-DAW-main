public class PersonaPractica {
 String nombre; //Atributos por defecto public
 byte edad;
 double estatura;
 
 public PersonaPractica(){ //Constructor
     this.nombre = getNombre();
     this.edad = getEdad();
     this.estatura = getEstatura();
 }
 public PersonaPractica(String nombre,byte edad,double estatura){
    this.nombre = nombre;
    this.edad = edad;
    this.estatura = estatura;
 }
 
 public void setNombre(String nom){
    this.nombre=nom;
 }
 public String getNombre(){
       return this.nombre;
 }
 public void setEdad(byte años){
       this.edad=años;
 }
 public byte getEdad(){
       return this.edad;
 }
 public void setEstatura(double altura){
    this.estatura=altura;
 }
 public double getEstatura(){
    return this.estatura;
 }
 public void saludar(){ //Método
 System.out.println("Hola a todos, soy "+nombre);
 }
 public void imprimeDatos(){
    System.out.println("Te llamas" +nombre+ ",tienes"+edad+"años y mides"+estatura);
 }
 public static void main(String[] args) {
 PersonaPractica p1=new PersonaPractica();
 PersonaPractica p2=new PersonaPractica();
 PersonaPractica p3=new PersonaPractica();
 //Indicar los atributos
 p1.setNombre("Pepa");
 p1.setEdad((byte)18);
 p1.setEstatura(1.87);
 p2.setNombre("Paco");
 p2.setEdad((byte)51);
 p2.setEstatura(1.68);
 p3.setNombre("Miguel");
 p3.setEdad((byte)27);
 p3.setEstatura(1.79);
 //Imprimir resultados
 p1.imprimeDatos();
 p2.imprimeDatos();
 p3.imprimeDatos();
 }
}
