package src;



import java.sql.Connection;

import src.Modelo.Conexion2;
import src.Vista.CursoView;
import src.Controlador.CursoController;



public class EjecutarCurso {

    public static void main(String[] args) {

        try {

            
            Connection conexion = Conexion2.getConnection();
          
            CursoController controlador = new CursoController(conexion);
            controlador.iniciar();

            conexion.close();

           
            CursoView view = new CursoView();

          
            int opcion;

            do {
                opcion = view.mostrarMenu();

                switch (opcion) {

                    case 1:
                        
                        break;

                    case 6:
                        System.out.println("Saliendo...");
                        break;
                }

            } while (opcion != 6);

            conexion.close();

        } catch (Exception e) {
           e.printStackTrace();

        }
    }
}

