package Modelo;




import java.sql.*;


public class PracticaDAO {

    public void insertar(Practica p) throws Exception {
        Connection con = Conexion.getConnection();
        String sql = "INSERT INTO practica(titulo,dificultad) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getTitulo());
        ps.setString(2, p.getDificultad());

        ps.executeUpdate();
        con.close();
    }
}

