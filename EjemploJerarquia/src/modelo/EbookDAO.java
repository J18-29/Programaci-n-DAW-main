package src.Modelo;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EbookDAO {
    // READ (lista de Persona)
    public ArrayList<Libro> listar() {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT l.id, isbn, anyo_publicacion,titulo,descripcion,tipo,tamanyo, precio FROM Libro l, Ebook e where l.id=e.id";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                libros.add(new Ebook(rs.getInt("id"), rs.getString("isbn"), 
                rs.getDate("anyo_publicacion"),rs.getString("titulo"),
                rs.getString("descripcion"),rs.getInt("tipo"),
                rs.getString("tamanyo"), rs.getDouble("precio") ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return libros;
    }
    //Leer 1 Ebook
    public Libro listarById(int id) {
        String sql = "SELECT l.id, isbn, anyo_publicacion,titulo,descripcion,tipo,tamanyo, precio FROM Libro l, Ebook e where l.id=e.id and l.id=?";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Ebook(rs.getInt("id"), rs.getString("isbn"), 
                rs.getDate("anyo_publicacion"),rs.getString("titulo"),
                rs.getString("descripcion"),rs.getInt("tipo"),
                rs.getString("tamanyo"), rs.getDouble("precio") );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    // CREATE
    public void insertar(Ebook p) {
        //Hay que hacer la inserción en Libro y la parte de Ebook
        String sql= "INSERT INTO Libro (id,isbn, anyo_publicacion,titulo,descripcion,tipo) VALUES (?, ?,?,?,?,1)";
        String sql2 = "INSERT INTO Ebook (id,tamaño, precio) VALUES (?, ?,?)";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getId()); 
            ps.setString(2, p.getIsbn());
            ps.setDate(3, p.getAnyo_publicacion());
            ps.setString(4,p.getTitulo());
            ps.setString(5,p.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql2)) {
            ps.setInt(1, p.getId()); 
            ps.setString(2, p.getTamanyo());
            ps.setDouble(3, p.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    // UPDATE
    public void actualizar(Ebook p) {
        //Hay que actualizar tanto Libro como Ebook
        String sql = "UPDATE Ebook SET tamanyo=?, precio=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getTamanyo());
            ps.setDouble(2, p.getPrecio()); 
            ps.setInt(3, p.getId()); 
            ps.executeUpdate();
        } catch (SQLException e) {  e.printStackTrace();  }
        String sql2 = "UPDATE Libro SET isbn=?, anyo_publicacion=?, titulo=?, descripcion=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql2)) {
            ps.setString(1, p.getIsbn()); 
            ps.setDate(2,p.getAnyo_publicacion());
            ps.setString(3, p.getTitulo());
            ps.setString(4,p.getDescripcion());
            ps.setDouble(5, p.getId()); 
            ps.executeUpdate();
        } catch (SQLException e) {  e.printStackTrace();  }
    }
    // DELETE
    public void eliminar(int id) {
        //Hay que borrar tanto el Ebook como el Papel
        String sql = "DELETE FROM Ebook WHERE id=?";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id); ps.executeUpdate();
            String sql2 = "DELETE FROM Libro WHERE id=? and tipo=1";
            try {
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, id);
                ps2.executeUpdate();
            } catch (SQLException e) {  e.printStackTrace();  }
        } catch (SQLException e) {  e.printStackTrace();  }
    }
}