package Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class CocheNuevo {
    int id;
    String matricula;
    Version version;
    List<Extra> extras = new ArrayList<>();

    public CocheNuevo(int id, String matricula, Version version) {
        this.id = id;
        this.matricula = matricula;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    // 👌 MÉTODO QUE TE FALTABA
    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Coche Nuevo:\n");
    sb.append("  ID: ").append(id).append("\n");
    sb.append("  Matrícula: ").append(matricula).append("\n");
    sb.append("  Versión: ").append(version).append("\n");

    sb.append("  Extras:\n");
    if (extras.isEmpty()) {
        sb.append("    (Sin extras)\n");
    } else {
        for (Extra extra : extras) {
            sb.append("    - ").append(extra).append("\n");
        }
    }

    return sb.toString();
}

}

