package MODELS;

import java.util.Date;

public class Usuario{
    private int codigo;
    private String telefono;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String sexo;
    private Date fechaNacimiento;

    public Usuario(int codigo,String telefono,String nombre, String apellido1, String apellido2, String sexo, Date fechaNacimiento){
        this.codigo=codigo;
        this.telefono=telefono;
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.sexo=sexo;
        this.fechaNacimiento=fechaNacimiento;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
    this.nombre = nombre;
}
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}