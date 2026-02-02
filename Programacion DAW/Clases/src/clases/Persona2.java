package Clases;

public class Persona2 {
    //Atributos
    private String cedula;
    private String nombre;
    private String apellido;
    private char genero;

    private Fecha fechaNacimiento;
    private Ciudad ciudadNacimiento;
    private Ciudad ciudadResidencia;

    // Constructor
    public Persona2(String cedula, String nombre, String apellido, char genero,
                   Fecha fechaNacimiento, Ciudad ciudadNacimiento, Ciudad ciudadResidencia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.ciudadResidencia = ciudadResidencia;
    }

    // Getters y Setters
    public String getCedula() { 
        return cedula; 
    }
    public void setCedula(String cedula) { 
        this.cedula = cedula; 
    }

    public String getNombre() { 
        return nombre;
     }
    public void setNombre(String nombre) { 
        this.nombre = nombre;
     }

    public String getApellido() { 
        return apellido;
     }
    public void setApellido(String apellido) { 
        this.apellido = apellido; 
    }

    public char getGenero() { 
        return genero;
     }
    public void setGenero(char genero) { 
        this.genero = genero; 
    }

    public Fecha getFechaNacimiento() { 
        return fechaNacimiento; 
    }
    public void setFechaNacimiento(Fecha fechaNacimiento) { 
        this.fechaNacimiento = fechaNacimiento;
     }

    public Ciudad getCiudadNacimiento() { 
        return ciudadNacimiento; 
    }
    public void setCiudadNacimiento(Ciudad ciudadNacimiento) {
         this.ciudadNacimiento = ciudadNacimiento; 
        }

    public Ciudad getCiudadResidencia() { 
        return ciudadResidencia;
     }
    public void setCiudadResidencia(Ciudad ciudadResidencia) { 
        this.ciudadResidencia = ciudadResidencia;
     }

    // Mostrar información completa
    public void mostrarInformacion() {
        System.out.println("----- Información de la Persona -----");
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Género: " + genero);
        System.out.print("Fecha de nacimiento: ");
        fechaNacimiento.mostrarFecha();
        System.out.print("Ciudad de nacimiento: ");
        ciudadNacimiento.mostrarCiudad();
        System.out.print("Ciudad de residencia: ");
        ciudadResidencia.mostrarCiudad();
        System.out.println("-------------------------------------");
    }
}

