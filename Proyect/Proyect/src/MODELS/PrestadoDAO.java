package MODELS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestadoDAO {

    public boolean insertarPrestado(Prestado p) {
        String sql = "INSERT INTO prestado(id_libro, cod_usuario) VALUES(?,?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getIdLibro());
            ps.setInt(2, p.getCodigoUsuario());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error insertar prestado: " + e.getMessage());
            return false;
        }
    }

    public List<Prestado> listarPrestados() {
        List<Prestado> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestado";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Prestado(
                        rs.getInt("id_libro"),
                        rs.getInt("cod_usuario")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error listar prestados: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarPrestado(Prestado p) {
        // Si solo quieres actualizar codigoUsuario a partir de idLibro:
        String sql = "UPDATE prestado SET cod_usuario=? WHERE id_libro=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getCodigoUsuario());
            ps.setInt(2, p.getIdLibro());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error actualizar prestado: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPrestado(int idLibro, int codigoUsuario) {
        String sql = "DELETE FROM prestado WHERE id_libro=? AND cod_usuario=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            ps.setInt(2, codigoUsuario);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}