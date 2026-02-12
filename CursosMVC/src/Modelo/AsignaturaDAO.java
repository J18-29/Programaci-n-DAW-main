package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO {
    private Connection conexion;

    public AsignaturaDAO(Connection conexion) {
        this.conexion = conexion;
    }
public void insertar(Asignatura asignatura) throws SQLException {
    // 1. La sentencia SQL solo lleva nombre, numero_horas e id_profesor
    String sql = "INSERT INTO asignatura (nombre, numero_horas, id_profesor) VALUES (?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        // 2. Pasamos los 3 parámetros
        ps.setString(1, asignatura.getNombre());
        ps.setInt(2, asignatura.getNumero_horas());
        ps.setInt(3, asignatura.getProfesor().getId()); // Asegúrate que este profesor ya exista en la BD

        // 3. Ejecutamos
        ps.executeUpdate();

        // 4. ESTO ES CLAVE: Le pedimos a MySQL el código que acaba de inventar
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                // Guardamos ese código en nuestro objeto Java
                asignatura.setCodigo(rs.getInt(1));
            }
        }
    }
}

    public Asignatura buscarPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT a.codigo, a.nombre, a.numero_horas, a.id_profesor, " +
                     "p.nombre AS prof_nom, p.apellido1, p.apellido2, p.especialidad, p.telefono " +
                     "FROM asignatura a " +
                     "JOIN profesor p ON a.id_profesor = p.id_profesor " +
                     "WHERE a.codigo = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Profesor prof = new Profesor(
                        rs.getInt("id_profesor"),
                        rs.getString("prof_nom"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("especialidad"),
                        rs.getString("telefono")
                    );
                    return new Asignatura(rs.getInt("codigo"), rs.getString("nombre"), rs.getInt("numero_horas"), prof);
                }
            }
        }
        return null;
    }

    public List<Asignatura> listarTodos() throws SQLException {
        List<Asignatura> lista = new ArrayList<>();
        String sql = "SELECT a.codigo, a.nombre, a.numero_horas, a.id_profesor, " +
                     "p.nombre AS prof_nom, p.apellido1, p.apellido2, p.especialidad, p.telefono " +
                     "FROM asignatura a " +
                     "JOIN profesor p ON a.id_profesor = p.id_profesor";

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Profesor prof = new Profesor(
                    rs.getInt("id_profesor"),
                    rs.getString("prof_nom"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("especialidad"),
                    rs.getString("telefono")
                );
                lista.add(new Asignatura(rs.getInt("codigo"), rs.getString("nombre"), rs.getInt("numero_horas"), prof));
            }
        }
        return lista;
    }

    public void actualizar(Asignatura asignatura) throws SQLException {
        String sql = "UPDATE asignatura SET nombre=?, numero_horas=?, id_profesor=? WHERE codigo=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, asignatura.getNombre());
            ps.setInt(2, asignatura.getNumero_horas());
            ps.setInt(3, asignatura.getProfesor().getId());
            ps.setInt(4, asignatura.getCodigo());
            ps.executeUpdate();
        }
    }

    public void eliminar(int codigo) throws SQLException {
        String sql = "DELETE FROM asignatura WHERE codigo=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }
}