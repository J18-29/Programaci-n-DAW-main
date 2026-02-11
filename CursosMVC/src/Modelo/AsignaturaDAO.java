package src.Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO {

    private Connection conexion;

    public AsignaturaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // INSERTAR
    public void insertar(Asignatura asignatura) throws SQLException {
        String sql = "INSERT INTO asignatura (nombre, numeroHoras, profesor_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, asignatura.getNombre());
            ps.setInt(2, asignatura.getNumeroHoras());
            ps.setInt(3, asignatura.getProfesor().getId()); // Usamos el id del profesor

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                asignatura.setCodigo(rs.getInt(1));
            }
        }
    }

    // BUSCAR POR CODIGO
    public Asignatura buscarPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT a.codigo, a.nombre, a.numeroHoras, " +
                     "p.id AS profesor_id, p.nombre AS profesor_nombre, " +
                     "p.apellido1 AS profesor_apellido1, p.apellido2 AS profesor_apellido2, " +
                     "p.especialidad AS profesor_especialidad, p.telefono AS profesor_telefono " +
                     "FROM asignatura a " +
                     "JOIN profesor p ON a.profesor_id = p.id " +
                     "WHERE a.codigo = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Profesor profesor = new Profesor(
                        rs.getInt("profesor_id"),
                        rs.getString("profesor_nombre"),
                        rs.getString("profesor_apellido1"),
                        rs.getString("profesor_apellido2"),
                        rs.getString("profesor_especialidad"),
                        rs.getString("profesor_telefono")
                );

                return new Asignatura(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getInt("numeroHoras"),
                        profesor
                );
            }
        }

        return null;
    }

    // LISTAR TODOS
    public List<Asignatura> listarTodos() throws SQLException {
        String sql = "SELECT a.codigo, a.nombre, a.numeroHoras, " +
                     "p.id AS profesor_id, p.nombre AS profesor_nombre, " +
                     "p.apellido1 AS profesor_apellido1, p.apellido2 AS profesor_apellido2, " +
                     "p.especialidad AS profesor_especialidad, p.telefono AS profesor_telefono " +
                     "FROM asignatura a " +
                     "JOIN profesor p ON a.profesor_id = p.id";

        List<Asignatura> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Profesor profesor = new Profesor(
                        rs.getInt("profesor_id"),
                        rs.getString("profesor_nombre"),
                        rs.getString("profesor_apellido1"),
                        rs.getString("profesor_apellido2"),
                        rs.getString("profesor_especialidad"),
                        rs.getString("profesor_telefono")
                );

                Asignatura asignatura = new Asignatura(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getInt("numeroHoras"),
                        profesor
                );

                lista.add(asignatura);
            }
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizar(Asignatura asignatura) throws SQLException {
        String sql = "UPDATE asignatura SET nombre=?, numeroHoras=?, profesor_id=? WHERE codigo=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, asignatura.getNombre());
            ps.setInt(2, asignatura.getNumeroHoras());
            ps.setInt(3, asignatura.getProfesor().getId());
            ps.setInt(4, asignatura.getCodigo());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int codigo) throws SQLException {
        String sql = "DELETE FROM asignatura WHERE codigo=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }
}
