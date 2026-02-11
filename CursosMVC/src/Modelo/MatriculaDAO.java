package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    private Connection conexion;

    public MatriculaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // INSERTAR
    public void insertar(Matricula matricula) throws SQLException {
        String sql = "INSERT INTO matricula (alumno_id, asignatura_codigo, curso_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, matricula.getAlumno().getId());
            ps.setInt(2, matricula.getAsignatura().getCodigo());
            ps.setInt(3, matricula.getCurso().getId());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(Matricula matricula) throws SQLException {
        String sql = "DELETE FROM matricula WHERE alumno_id=? AND asignatura_codigo=? AND curso_id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, matricula.getAlumno().getId());
            ps.setInt(2, matricula.getAsignatura().getCodigo());
            ps.setInt(3, matricula.getCurso().getId());

            ps.executeUpdate();
        }
    }

    // LISTAR MATRÍCULAS DE UN ALUMNO
    public List<Matricula> listarPorAlumno(Alumno alumno) throws SQLException {
        String sql = "SELECT m.alumno_id, m.asignatura_codigo, m.curso_id, " +
                     "a.nombre AS asignatura_nombre, a.numeroHoras AS asignatura_horas, " +
                     "p.id AS profesor_id, p.nombre AS profesor_nombre, p.apellido1 AS profesor_apellido1, " +
                     "p.apellido2 AS profesor_apellido2, p.especialidad AS profesor_especialidad, p.telefono AS profesor_telefono, " +
                     "c.anioInicio, c.anioFin " +
                     "FROM matricula m " +
                     "JOIN asignatura a ON m.asignatura_codigo = a.codigo " +
                     "JOIN profesor p ON a.profesor_id = p.id " +
                     "JOIN curso_escolar c ON m.curso_id = c.id " +
                     "WHERE m.alumno_id = ?";

        List<Matricula> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, alumno.getId());
            ResultSet rs = ps.executeQuery();

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
                        rs.getInt("asignatura_codigo"),
                        rs.getString("asignatura_nombre"),
                        rs.getInt("asignatura_horas"),
                        profesor
                );

                CursoEscolar curso = new CursoEscolar(
                        rs.getInt("curso_id"),
                        rs.getInt("anioInicio"),
                        rs.getInt("anioFin")
                );

                Matricula matricula = new Matricula(alumno, asignatura, curso);
                lista.add(matricula);
            }
        }

        return lista;
    }

    // LISTAR TODOS
    public List<Matricula> listarTodos() throws SQLException {
        String sql = "SELECT m.alumno_id, m.asignatura_codigo, m.curso_id, " +
                     "al.nif, al.nombre AS alumno_nombre, al.apellido1 AS alumno_apellido1, al.apellido2 AS alumno_apellido2, " +
                     "a.nombre AS asignatura_nombre, a.numeroHoras AS asignatura_horas, " +
                     "p.id AS profesor_id, p.nombre AS profesor_nombre, p.apellido1 AS profesor_apellido1, " +
                     "p.apellido2 AS profesor_apellido2, p.especialidad AS profesor_especialidad, p.telefono AS profesor_telefono, " +
                     "c.anioInicio, c.anioFin " +
                     "FROM matricula m " +
                     "JOIN alumno al ON m.alumno_id = al.id " +
                     "JOIN asignatura a ON m.asignatura_codigo = a.codigo " +
                     "JOIN profesor p ON a.profesor_id = p.id " +
                     "JOIN curso_escolar c ON m.curso_id = c.id";

        List<Matricula> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getInt("alumno_id"),
                        rs.getString("nif"),
                        rs.getString("alumno_nombre"),
                        rs.getString("alumno_apellido1"),
                        rs.getString("alumno_apellido2")
                );

                Profesor profesor = new Profesor(
                        rs.getInt("profesor_id"),
                        rs.getString("profesor_nombre"),
                        rs.getString("profesor_apellido1"),
                        rs.getString("profesor_apellido2"),
                        rs.getString("profesor_especialidad"),
                        rs.getString("profesor_telefono")
                );

                Asignatura asignatura = new Asignatura(
                        rs.getInt("asignatura_codigo"),
                        rs.getString("asignatura_nombre"),
                        rs.getInt("asignatura_horas"),
                        profesor
                );

                CursoEscolar curso = new CursoEscolar(
                        rs.getInt("curso_id"),
                        rs.getInt("anioInicio"),
                        rs.getInt("anioFin")
                );

                Matricula matricula = new Matricula(alumno, asignatura, curso);
                lista.add(matricula);
            }
        }

        return lista;
    }
}
