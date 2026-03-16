package MODELS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    // INSERTAR AUTOR
    public boolean insertarAutor(Autor autor) {

        String sql = "INSERT INTO autor(id, nombre, telefono) VALUES(?,?,?)";

        try {

            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, autor.getId());
            ps.setString(2, autor.getNombre());
            ps.setString(3, autor.getTelefono());

            ps.executeUpdate();
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // LISTAR AUTORES
    public List<Autor> listarAutores() {

        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autor";

        try {

            Connection conn = Conexion.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Autor autor = new Autor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                );

                lista.add(autor);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // BUSCAR AUTOR
    public Autor obtenerAutor(int id) {

        String sql = "SELECT * FROM autor WHERE id=?";
        Autor autor = null;

        try {

            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                autor = new Autor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                );
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return autor;
    }

    // ACTUALIZAR AUTOR
    public boolean actualizarAutor(Autor autor) {

        String sql = "UPDATE autor SET nombre=?, telefono=? WHERE id=?";

        try {

            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getTelefono());
            ps.setInt(3, autor.getId());

            ps.executeUpdate();

            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ELIMINAR AUTOR
    public boolean eliminarAutor(int id) {

        String sql = "DELETE FROM autor WHERE id=?";

        try {

            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            conn.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}