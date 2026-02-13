package src.Modelo;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class PapelDAO {

    public void insertar(Papel papel) {
        String sql = "INSERT INTO papel (fecha_impresion, precio, lugar_impresion) VALUES (?, ?, ?)";

        try (Connection conn = Conexion2.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(papel.getFechaImpresion()));
            ps.setDouble(2, papel.getPrecio());
            ps.setString(3, papel.getLugarImpresion());

            ps.executeUpdate();
            System.out.println("Papel insertado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Papel> listar() {
        List<Papel> lista = new ArrayList<>();
        String sql = "SELECT * FROM papel";

        try (Connection conn = Conexion2.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Papel papel = new Papel(
                        rs.getInt("id"),
                        rs.getDate("fecha_impresion").toLocalDate(),
                        rs.getDouble("precio"),
                        rs.getString("lugar_impresion")
                );
                lista.add(papel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM papel WHERE id = ?";

        try (Connection conn = Conexion2.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Papel eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
