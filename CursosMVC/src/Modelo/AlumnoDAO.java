package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private Connection conexion;

    public AlumnoDAO(Connection conexion) {
        this.conexion = conexion;
    }

   
    public void insertar(Alumno alumno) throws SQLException {
       
        String sql = "INSERT INTO alumno (numero_matricula, nombre, apellido1, apellido2, fecha_nacimiento, telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
           
            ps.setInt(1, alumno.getNumeroMatricula()); 
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido1());
            ps.setString(4, alumno.getApellido2());
            ps.setString(5, alumno.getFechaNacimiento());
            ps.setString(6, alumno.getTelefono());

            ps.executeUpdate();
        }
    }

    // BUSCAR POR ID: Ahora busca por numero_matricula (que es tu PK)
    public Alumno buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM alumno WHERE numero_matricula = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Alumno(
                        rs.getInt("numero_matricula"), 
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("telefono"),
                        rs.getString("fecha_nacimiento")
                    );
                }
            }
        }
        return null;
    }

    // LISTAR TODOS
    public List<Alumno> listarTodos() throws SQLException {
        String sql = "SELECT * FROM alumno";
        List<Alumno> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno(
                    rs.getInt("numero_matricula"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("telefono"),
                    rs.getString("fecha_nacimiento")
                );
                lista.add(alumno);
            }
        }
        return lista;
    }

    // ACTUALIZAR
    public void actualizar(Alumno alumno) throws SQLException {
        String sql = "UPDATE alumno SET nombre=?, apellido1=?, apellido2=?, fecha_nacimiento=?, telefono=? WHERE numero_matricula=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido1());
            ps.setString(3, alumno.getApellido2());
            ps.setString(4, alumno.getFechaNacimiento());
            ps.setString(5, alumno.getTelefono());
            ps.setInt(6, alumno.getNumeroMatricula());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM alumno WHERE numero_matricula = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}