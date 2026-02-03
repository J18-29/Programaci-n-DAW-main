

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SuministroDAO {

    // CREATE
    public void insertar(int codigoProveedor, int codigoPieza, Timestamp fechaHora, int cantidad) {
        String sql = "INSERT INTO proveedor_suministra_pieza VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigoProveedor);
            ps.setInt(2, codigoPieza);
            ps.setTimestamp(3, fechaHora);
            ps.setInt(4, cantidad);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // READ (SELECT)
    public void listar() {
        String sql = "SELECT * FROM proveedor_suministra_pieza";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("codigo_proveedor") + " - " +
                        rs.getInt("codigo_pieza") + " - " +
                        rs.getTimestamp("fecha_hora") + " - " +
                        rs.getInt("cantidad")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // UPDATE
    public void actualizar(int codigoProveedor, int codigoPieza, Timestamp nuevaFechaHora, int nuevaCantidad) {
        String sql = "UPDATE proveedor_suministra_pieza SET fecha_hora=?, cantidad=? WHERE codigo_proveedor=? AND codigo_pieza=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setTimestamp(1, nuevaFechaHora);
            ps.setInt(2, nuevaCantidad);
            ps.setInt(3, codigoProveedor);
            ps.setInt(4, codigoPieza);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // DELETE
    public void borrar(int codigoProveedor, int codigoPieza) {
        String sql = "DELETE FROM proveedor_suministra_pieza WHERE codigo_proveedor=? AND codigo_pieza=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigoProveedor);
            ps.setInt(2, codigoPieza);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
