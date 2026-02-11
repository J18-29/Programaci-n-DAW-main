package src.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PiezaDAO {

    // CREATE
    public void insertar(int codigo, String nombre, String color, double precio, int codigoCategoria) {
        String sql = "INSERT INTO pieza VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, color);
            ps.setDouble(4, precio);
            ps.setInt(5, codigoCategoria);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // READ (SELECT)
    public void listar() {
        String sql = "SELECT * FROM pieza";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("codigo") + " - " +
                        rs.getString("nombre") + " - " +
                        rs.getString("color") + " - " +
                        rs.getDouble("precio") + " - " +
                        rs.getInt("codigo_categoria")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // UPDATE
    public void actualizar(int codigo, String nuevoNombre, String nuevoColor, double nuevoPrecio, int nuevoCodigoCategoria) {
        String sql = "UPDATE pieza SET nombre=?, color=?, precio=?, codigo_categoria=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoColor);
            ps.setDouble(3, nuevoPrecio);
            ps.setInt(4, nuevoCodigoCategoria);
            ps.setInt(5, codigo);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // DELETE
    public void borrar(int codigo) {
        String sql = "DELETE FROM pieza WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
