package Modelo;




import java.sql.*;

public class HaceDAO {

    public void insertar(Hace h) throws Exception {
        Connection con = Conexion.getConnection();
        String sql = "INSERT INTO hace(id_alumno,id_examen,nota) VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, h.getIdAlumno());
        ps.setInt(2, h.getIdExamen());
        ps.setDouble(3, h.getNota());

        ps.executeUpdate();
        con.close();
    }
}
