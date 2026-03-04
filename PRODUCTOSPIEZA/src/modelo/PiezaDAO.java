package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PiezaDAO {

    // Insertar una pieza
    public void insertar(Pieza p) {
        String sql = "INSERT INTO pieza (codigo, nombre, color, precio, codigo_categoria) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getColor());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getCodCategoria());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas las piezas
    public List<Pieza> listar() {
        List<Pieza> lista = new ArrayList<>();
        String sql = "SELECT * FROM pieza";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Pieza(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("color"),
                        rs.getDouble("precio"),
                        rs.getInt("codigo_categoria")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Actualizar todos los campos de una pieza
    public void actualizar(Pieza p) {
        String sql = "UPDATE pieza SET nombre=?, color=?, precio=?, codigo_categoria=? WHERE codigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getColor());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCodCategoria());
            ps.setInt(5, p.getCodigo());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Borrar una pieza por código
    public void borrar(int codigo) {
        String sql = "DELETE FROM pieza WHERE codigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}