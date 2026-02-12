package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoEscolarDAO {

    private Connection conexion;

    public CursoEscolarDAO(Connection conexion) {
        this.conexion = conexion;
    }

public void insertar(CursoEscolar curso) throws SQLException {
    // IMPORTANTE: Usamos 'anio_inicio' y 'anio_fin' (sin la ñ)
    String sql = "INSERT INTO curso_escolar (anio_inicio, anio_fin) VALUES (?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setInt(1, curso.getAnio_inicio());
        ps.setInt(2, curso.getAnio_fin());

        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                curso.setId(rs.getInt(1));
            }
        }
    }
}

    // BUSCAR POR ID
    public CursoEscolar buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM curso_escolar WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CursoEscolar(
                        rs.getInt("id"),
                        rs.getInt("anioInicio"),
                        rs.getInt("anioFin")
                );
            }
        }

        return null;
    }

    // LISTAR TODOS
    public List<CursoEscolar> listarTodos() throws SQLException {
        String sql = "SELECT * FROM curso_escolar";
        List<CursoEscolar> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CursoEscolar curso = new CursoEscolar(
                        rs.getInt("id"),
                        rs.getInt("anioInicio"),
                        rs.getInt("anioFin")
                );
                lista.add(curso);
            }
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizar(CursoEscolar curso) throws SQLException {
        String sql = "UPDATE curso_escolar SET anioInicio=?, anioFin=? WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, curso.getAnio_inicio());
            ps.setInt(2, curso.getAnio_fin());
            ps.setInt(3, curso.getId());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM curso_escolar WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
