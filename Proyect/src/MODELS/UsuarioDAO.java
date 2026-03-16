package MODELS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    // ========================
    // INSERTAR
    // ========================
    public boolean insertar(Usuario u) {
        String sql = "INSERT INTO usuario(telefono,nombre,apellido1,apellido2,sexo,fecha_nacimiento) VALUES(?,?,?,?,?,?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getTelefono());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido1());
            ps.setString(4, u.getApellido2());
            ps.setString(5, u.getSexo());
            ps.setDate(6, new java.sql.Date(u.getFechaNacimiento().getTime()));

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error insertar usuario: " + e.getMessage());
            return false;
        }
    }

    // ========================
    // LISTAR
    // ========================
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("codigo"),
                        rs.getString("telefono"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("sexo"),
                        rs.getDate("fecha_nacimiento") // nombre exacto de la columna
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error listar usuarios: " + e.getMessage());
        }

        return lista;
    }

    // ========================
    // ACTUALIZAR
    // ========================
    public boolean actualizar(Usuario u) {
        String sql = "UPDATE usuario SET telefono=?, nombre=?, apellido1=?, apellido2=?, sexo=?, fecha_nacimiento=? WHERE codigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, u.getTelefono());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido1());
            ps.setString(4, u.getApellido2());
            ps.setString(5, u.getSexo());
            ps.setDate(6, new java.sql.Date(u.getFechaNacimiento().getTime()));
            ps.setInt(7, u.getCodigo());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    // ========================
    // ELIMINAR
    // ========================
    public boolean eliminar(int codigo) {
        String sql = "DELETE FROM usuario WHERE codigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}
