package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    public void insertar(Proveedor p) {
    String sql = "INSERT INTO proveedor (codigo, direccion, ciudad, provincia) VALUES (?, ?, ?, ?)";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, p.getCodigo());
        ps.setString(2, p.getDireccion());
        ps.setString(3, p.getCiudad());
        ps.setString(4, p.getProvincia());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace(); // mejor que solo getMessage()
    }
}

    public List<Proveedor> listar() {

        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Proveedor(
                        rs.getInt("codigo"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("provincia")));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return lista;
    }

   public void actualizar(Proveedor p) {

    String sql = "UPDATE proveedor SET direccion=?, ciudad=?, provincia=? WHERE codigo=?";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, p.getDireccion());
        ps.setString(2, p.getCiudad());
        ps.setString(3, p.getProvincia());
        ps.setInt(4, p.getCodigo());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void borrar(int codigo) {
        String sql = "DELETE FROM proveedor WHERE codigo=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}