package src.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void insertar(Libro libro) {
        String sql = "INSERT INTO libro (isbn, titulo, año, descripcion) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setInt(3, libro.getAnyo());
            ps.setString(4, libro.getDescripcion());

            ps.executeUpdate();
            System.out.println("Libro insertado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getInt("año"),
                        rs.getString("descripcion")
                );
                lista.add(libro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    //Update
    public void actualizar(Libro libro) {
        String sql = "UPDATE libro SET isbn = ?, titulo = ?, año = ?, descripcion = ? WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setInt(3, libro.getAnyo());
            ps.setString(4, libro.getDescripcion());
            ps.setInt(5, libro.getId());

            ps.executeUpdate();
            System.out.println("Libro actualizado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM libro WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Libro eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
