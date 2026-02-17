package Modelo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    // INSERTAR
    public void insertar(Profesor profesor) throws Exception {

        Connection con = Conexion.getConnection();

        // Cambiado 'profesor' → 'Profesores'
        String sql = "INSERT INTO Profesores(nif,nombre,apellido1,apellido2) VALUES (?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, profesor.getNif());
        ps.setString(2, profesor.getNombre());
        ps.setString(3, profesor.getApellido1());
        ps.setString(4, profesor.getApellido2());

        ps.executeUpdate();
        con.close();
    }

    // LISTAR
    public List<Profesor> listar() throws Exception {

        List<Profesor> lista = new ArrayList<>();

        Connection con = Conexion.getConnection();
        Statement st = con.createStatement();

        // Cambiado 'profesor' → 'Profesores'
        ResultSet rs = st.executeQuery("SELECT * FROM Profesores");

        while (rs.next()) {

            Profesor p = new Profesor(
                    rs.getInt("id"),
                    rs.getString("nif"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2")
            );

            lista.add(p);
        }

        con.close();
        return lista;
    }

    // BUSCAR POR ID
    public Profesor buscarPorId(int id) throws Exception {

        Connection con = Conexion.getConnection();

        // Cambiado 'profesor' → 'Profesores'
        String sql = "SELECT * FROM Profesores WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Profesor profesor = null;

        if (rs.next()) {
            profesor = new Profesor(
                    rs.getInt("id"),
                    rs.getString("nif"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2")
            );
        }

        con.close();
        return profesor;
    }
}
