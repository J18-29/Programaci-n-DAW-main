package src.Vista;



import src.Modelo.CursoEscolar;

public class CursoEscolarView {
    private String anio; 

    public CursoEscolarView(CursoEscolar curso) {
        this.anio = curso.getAnioInicio() + "-" + curso.getAnioFin();
    }

    public String getAnio() {
        return anio;
    }
}
