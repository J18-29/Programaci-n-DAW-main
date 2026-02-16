package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    private Connection conexion;

    public ProfesorDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertar(Profesor profesor) throws SQLException {
    String sql = "INSERT INTO profesor (nombre, apellido1, apellido2, especialidad, telefono) VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, profesor.getNombre());
        ps.setString(2, profesor.getApellido1());
        ps.setString(3, profesor.getApellido2());
        ps.setString(4, profesor.getEspecialidad());
        ps.setString(5, profesor.getTelefono());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            profesor.setId(rs.getInt(1));
        }
    }
}
    // BUSCAR POR ID
    public Profesor buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM profesor WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("especialidad"),
                        rs.getString("telefono")
                );
            }
        }

        return null;
    }

    // LISTAR TODOS
    public List<Profesor> listarTodos() throws SQLException {
        String sql = "SELECT * FROM profesor";
        List<Profesor> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Profesor profesor = new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("especialidad"),
                        rs.getString("telefono")
                );
                lista.add(profesor);
            }
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizar(Profesor profesor) throws SQLException {
        String sql = "UPDATE profesor SET nombre=?, apellido1=?, apellido2=?, especialidad=?, telefono=? WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido1());
            ps.setString(3, profesor.getApellido2());
            ps.setString(4, profesor.getEspecialidad());
            ps.setString(5, profesor.getTelefono());
            ps.setInt(6, profesor.getId());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM profesor WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // MÉTODO PARA LISTAR PROFESORES Y SUS MATRÍCULAS
public void listarAsignaciones() throws SQLException {
    String sql = "SELECT p.nombre, p.apellido1, m.numero_matricula, m.codigo_asignatura " +
                 "FROM profesor p " +
                 "JOIN matricula m ON p.id = m.id_profesor";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        System.out.println("\n--- LISTADO DE ASIGNACIONES ---");
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido1");
            int nMatricula = rs.getInt("numero_matricula");
            int codAsignatura = rs.getInt("codigo_asignatura");
            
            System.out.println("Profesor: " + nombre + " " + apellido + 
                               " | Matrícula: " + nMatricula + 
                               " | Asignatura: " + codAsignatura);
        }
    }
}
}

