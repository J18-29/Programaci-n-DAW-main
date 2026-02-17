package Controlador;








import Modelo.AlumnoDAO;
import Modelo.DisenaDAO;
import Modelo.ExamenTeoricoDAO;
import Modelo.HaceDAO;
import Modelo.PracticaDAO;
import Modelo.ProfesorDAO;
import Modelo.RealizaDAO;
import Vista.ClaseView;

public class ClaseController {

    private ClaseView view = new ClaseView();

    private AlumnoDAO alumnoDAO = new AlumnoDAO();
    private ProfesorDAO profesorDAO = new ProfesorDAO();
    private PracticaDAO practicaDAO = new PracticaDAO();
    private ExamenTeoricoDAO examenDAO = new ExamenTeoricoDAO();
    private RealizaDAO realizaDAO = new RealizaDAO();
    private HaceDAO haceDAO = new HaceDAO();
    private DisenaDAO disenaDAO = new DisenaDAO();

    public void iniciar() {

        int opcion;

        do {
            opcion = view.menu();

            try {

                switch (opcion) {

                    case 1:
                        alumnoDAO.insertar(view.pedirAlumno());
                        break;

                    case 2:
                        profesorDAO.insertar(view.pedirProfesor());
                        break;

                    case 3:
                        practicaDAO.insertar(view.pedirPractica());
                        break;

                    case 4:
                        examenDAO.insertar(view.pedirExamen());
                        break;

                    case 5:
                        realizaDAO.insertar(view.pedirRealiza());
                        break;

                    case 6:
                        haceDAO.insertar(view.pedirHace());
                        break;

                    case 7:
                        disenaDAO.insertar(view.pedirDisenaPractica());
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 0);
    }
}

