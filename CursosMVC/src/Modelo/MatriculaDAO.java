package src.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {
    private Connection conexion;

    public MatriculaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertar(Matricula matricula) throws SQLException {
    
    String sql = "INSERT INTO matricula (numero_matricula, codigo_asignatura, id_curso, id_profesor) VALUES (?, ?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, matricula.getAlumno().getNumeroMatricula());
        ps.setInt(2, matricula.getAsignatura().getCodigo());
        ps.setInt(3, matricula.getCurso().getId());
       
        ps.setInt(4, matricula.getAsignatura().getProfesor().getId()); 
        
        ps.executeUpdate();
    }
}

  public List<Matricula> listarTodos() throws SQLException {
    // Usamos m.id_profesor que es la que creamos en la tabla MATRICULA
    String sql = "SELECT m.numero_matricula, m.codigo_asignatura, m.id_curso, " +
                 "al.nombre AS alu_nom, " +
                 "asig.nombre AS asig_nom, asig.numero_hora, " + 
                 "p.id AS prof_id, p.nombre AS prof_nom, " +
                 "c.anio_inicio, c.anio_fin " +
                 "FROM matricula m " +
                 "JOIN alumno al ON m.numero_matricula = al.id " +
                 "JOIN asignatura asig ON m.codigo_asignatura = asig.codigo " +
                 "JOIN profesor p ON m.id_profesor = p.id " + 
                 "JOIN curso_escolar c ON m.id_curso = c.id";

    List<Matricula> lista = new ArrayList<>();
    // Usamos PreparedStatement por seguridad aunque no tenga parámetros
    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            // ... (tu lógica de creación de objetos)
            Alumno alu = new Alumno(rs.getInt("numero_matricula"), rs.getString("alu_nom"), "", "", "", "");
            Profesor prof = new Profesor(rs.getInt("prof_id"), rs.getString("prof_nom"), "", "", "", "");
            Asignatura asig = new Asignatura(rs.getInt("codigo_asignatura"), rs.getString("asig_nom"), rs.getInt("numero_hora"), prof);
            CursoEscolar curso = new CursoEscolar(rs.getInt("id_curso"), rs.getInt("anio_inicio"), rs.getInt("anio_fin"));
            lista.add(new Matricula(alu, asig, curso));
        }
    }
    return lista;
}

}