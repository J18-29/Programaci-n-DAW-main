package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EbookDAO {

    public void insertar(Ebook ebook) {
        String sql = "INSERT INTO ebook (tamaño, precio) VALUES (?, ?)";

        try (Connection conn = Conexion2.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ebook.getTamaño());
            ps.setDouble(2, ebook.getPrecio());

            ps.executeUpdate();
            System.out.println("Ebook insertado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ebook> listar() {
        List<Ebook> lista = new ArrayList<>();
        String sql = "SELECT * FROM ebook";

        try (Connection conn = Conexion2.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Ebook ebook = new Ebook(
                        rs.getInt("id"),
                        rs.getString("tamaño"),
                        rs.getDouble("precio")
                );
                lista.add(ebook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM ebook WHERE id = ?";

        try (Connection conn = Conexion2.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Ebook eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
