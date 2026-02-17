package Modelo;




import java.sql.*;

public class DisenaDAO {

    public void insertar(Disena d) throws Exception {
        Connection con = Conexion.getConnection();

        String sql = "INSERT INTO Disena(id_profesor,id_practica,fecha) VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, d.getIdProfesor());
        ps.setInt(2, d.getIdPractica());
        ps.setDate(3, new java.sql.Date(d.getFecha().getTime()));

        ps.executeUpdate();
        con.close();
    }
}
