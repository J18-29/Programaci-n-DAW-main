package MODELS;

import MODELS.Libro;
import MODELS.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // Insertar un libro
    public void insertar(Libro l) {
        String sql = "INSERT INTO libro (titulo, isbn, anio, descripcion, url, id_autor) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getIsbn());
            ps.setInt(3, l.getAnio());
            ps.setString(4, l.getDescripcion());
            ps.setString(5, l.getUrl());
            ps.setInt(6, l.getId_Autor());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // Listar todos los libros
    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("isbn"),
                        rs.getInt("anio"),
                        rs.getString("descripcion"),
                        rs.getString("url"),
                        rs.getInt("id_autor")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    // Actualizar un libro
    public void actualizar(Libro l) {
        String sql = "UPDATE libro SET titulo=?, isbn=?, anio=?, descripcion=?,url=?, id_autor=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getIsbn());
            ps.setInt(3, l.getAnio());
            ps.setString(4, l.getDescripcion());
            ps.setString(5, l.getUrl());
            ps.setInt(6, l.getId_Autor());
            ps.setInt(7, l.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // Eliminar un libro
    public void eliminar(int id) {
        String sql = "DELETE FROM libro WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}