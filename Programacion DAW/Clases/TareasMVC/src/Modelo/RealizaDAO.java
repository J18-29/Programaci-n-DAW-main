package Modelo;


import java.sql.*;

public class RealizaDAO {

    public void insertar(Realiza r) throws Exception {
        Connection con = Conexion.getConnection();
        String sql = "INSERT INTO realiza(id_alumno,id_practica,fecha,nota) VALUES (?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, r.getIdAlumno());
        ps.setInt(2, r.getIdPractica());
        ps.setDate(3, new java.sql.Date(r.getFecha().getTime()));
        ps.setDouble(4, r.getNota());

        ps.executeUpdate();
        con.close();
    }
}
