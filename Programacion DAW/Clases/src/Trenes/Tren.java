package Trenes;

public class Tren {
     Locomotora locomotora;
     Maquinistas maquinista;
     Vagón[] vagones;

    public Tren(Locomotora locomotora, Maquinistas maquinista, Vagón[] vagones) {
        this.locomotora = locomotora;
        this.maquinista = maquinista;
        this.vagones = vagones;
    }

    public Locomotora getLocomotora() { 
        return locomotora; 
    }
    public void setLocomotora(Locomotora locomotora) { 
        this.locomotora = locomotora; 
    }

    public Maquinistas getMaquinista() { 
        return maquinista; 
    }
    public void setMaquinista(Maquinistas maquinista) { 
        this.maquinista = maquinista; 
    }

    public Vagón[] getVagones() { 
        return vagones; 
    }
    public void setVagones(Vagón[] vagones) { 
        this.vagones = vagones; 
    }

    public void mostrarInfo() {
        System.out.println("=== Tren ===");
        System.out.println(locomotora);
        System.out.println("Maquinista: " + maquinista);
        for (Vagón v : vagones) {
            System.out.println(" - " + v);
        }
        System.out.println();
    }
}
