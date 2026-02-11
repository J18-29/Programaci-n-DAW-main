package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private Connection conexion;

    public AlumnoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // INSERTAR
    public void insertar(Alumno alumno) throws SQLException {
        String sql = "INSERT INTO alumno (nif, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, alumno.getNif());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido1());
            ps.setString(4, alumno.getApellido2());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(rs.getInt(1));
            }
        }
    }

    // BUSCAR POR ID
    public Alumno buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM alumno WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Alumno(
                        rs.getInt("id"),
                        rs.getString("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2")
                );
            }
        }

        return null;
    }

    // LISTAR TODOS
    public List<Alumno> listarTodos() throws SQLException {
        String sql = "SELECT * FROM alumno";
        List<Alumno> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2")
                );

                lista.add(alumno);
            }
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizar(Alumno alumno) throws SQLException {
        String sql = "UPDATE alumno SET nif=?, nombre=?, apellido1=?, apellido2=? WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, alumno.getNif());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido1());
            ps.setString(4, alumno.getApellido2());
            ps.setInt(5, alumno.getId());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM alumno WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
