

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaDAO {
 // CREATE
 public static void insertar(int codigo, String nombre) {
 String sql = "INSERT INTO categoria VALUES (?, ?)";
 try (Connection conn = Conexion.getConnection();
 PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setInt(1, codigo);
 ps.setString(2, nombre);
 ps.executeUpdate();
 } catch (SQLException e) {
 System.err.println(e.getMessage());
 }
 }
 // READ (SELECT)
 public static void listar() {
 String sql = "SELECT * FROM categoria";
 try (Connection conn = Conexion.getConnection();
 Statement stmt = conn.createStatement();
 ResultSet rs = stmt.executeQuery(sql)) {
 while (rs.next()) {
 System.out.println(
 rs.getInt("codigo") + " - " + rs.getString("nombre")
 );
 }
 } catch (SQLException e) {
 System.err.println(e.getMessage());
 }
 
 }
 // UPDATE
 public static void actualizar(int codigo, String nuevoNombre) {
 String sql = "UPDATE categoria SET nombre=? WHERE codigo=?";
 try (Connection conn = Conexion.getConnection();
 PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setString(1, nuevoNombre);
 ps.setInt(2, codigo);
 ps.executeUpdate();
 } catch (SQLException e) {
 System.err.println(e.getMessage());
 }
 }
 // DELETE
 public static void borrar(int codigo) {
 String sql = "DELETE FROM categoria WHERE codigo=?";
 try (Connection conn = Conexion.getConnection();
 PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setInt(1, codigo);
 ps.executeUpdate();
 } catch (SQLException e) {
 System.err.println(e.getMessage());
 }
 }
}