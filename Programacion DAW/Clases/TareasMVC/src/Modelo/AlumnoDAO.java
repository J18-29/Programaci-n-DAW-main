package Modelo;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    public void insertar(Alumno alumno) throws Exception {
        Connection con = Conexion.getConnection();
       String sql = "INSERT INTO Alumnos(nif,nombre,apellido1,apellido2,grupo) VALUES (?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, alumno.getNif());
        ps.setString(2, alumno.getNombre());
        ps.setString(3, alumno.getApellido1());
        ps.setString(4, alumno.getApellido2());
        ps.setString(5, alumno.getGrupo());

        ps.executeUpdate();
        con.close();
    }

    public List<Alumno> listar() throws Exception {
        List<Alumno> lista = new ArrayList<>();
        Connection con = Conexion.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM alumno");

        while(rs.next()){
            Alumno a = new Alumno(
                    rs.getInt("id"),
                    rs.getString("nif"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("grupo")
            );
            lista.add(a);
        }
        con.close();
        return lista;
    }
}
