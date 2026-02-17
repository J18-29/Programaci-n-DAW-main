package Modelo;


import java.sql.*;

public class ExamenTeoricoDAO {

   public void insertar(ExamenTeorico e) throws Exception {

    Connection con = Conexion.getConnection();

    String sql = "INSERT INTO examenes_teoricos(titulo,numero_preguntas,fecha,id_profesor) VALUES (?,?,?,?)";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setString(1, e.getTitulo());
    ps.setInt(2, e.getNumeroPreguntas());
    ps.setDate(3, new java.sql.Date(e.getFecha().getTime()));
    ps.setInt(4, e.getIdProfesor());

    ps.executeUpdate();
    con.close();
}

}
