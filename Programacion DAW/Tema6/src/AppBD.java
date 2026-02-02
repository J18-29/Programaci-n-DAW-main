import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ActividadER.Conexion;

public class AppBD {
    public static void main(String[] args) {
        // String sql="CREATE TABLE IF NOT EXISTS persona (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100), email VARCHAR(100)";
        // try{
        //     Connection conexion=Conexion.getConnection();
        //     Statement stmt= conexion.createStatement();
        //     stmt.executeUpdate(sql);
        //     System.out.println("Fila insertada correctamente.");
        //     crearPersona("Juan Perez", "juan.perez@example.com");
        // } catch (Exception e) {
        //     System.err.println("Error: " + e.getMessage());
        // }
        
        //Ejemplo de Actividad 1
        listarJugadores("Spain", "Lakers");
        //Ejemplo de Actividad 2
        actualizarJugador();
        
    }

 

 public static void crearPersona(String nombre, String email)  {
 String sql = "INSERT INTO persona (nombre, email) VALUES (?, ?)";
 try (Connection conn = Conexion.getConnection();
 PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setString(1, nombre);
 ps.setString(2, email);
 ps.executeUpdate();
 System.out.println("Persona creada.");
 } catch (SQLException e) {
 System.err.println("Error al insertar: " + e.getMessage());
 }
 }


public static void listarJugadores(String procedencia, String equipo) {
    String sql = "SELECT codigo, Nombre, Procedencia, Nombre_equipo " +
                 "FROM jugadores " +
                 "WHERE Procedencia = ? AND Nombre_equipo = ?";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, procedencia);
        ps.setString(2, equipo);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getInt("codigo") + " : " +
                rs.getString("Nombre") + " - " +
                rs.getString("Procedencia") + " - " +
                rs.getString("Nombre_equipo")
            );
        }
    } catch (SQLException e) {
        System.err.println("Error al leer: " + e.getMessage());
    }
}



 public static void actualizarJugador() {
    String sql = "UPDATE jugadores SET Procedencia = 'Spain' WHERE codigo = 666";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Jugador 666 actualizado correctamente.");
        } else {
            System.out.println("No existe ningún jugador con código 666.");
        }

    } catch (SQLException e) {
        System.err.println("Error al actualizar: " + e.getMessage());
    }
}


public static Persona obtenerPersonaPorId(int id) {
 String sql = "SELECT * FROM persona WHERE id = ?";
 Persona persona = null;
 try (Connection conn = Conexion.getConnection();
 PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setInt(1, id);
 try (ResultSet rs = ps.executeQuery()) {
 if (rs.next()) {
 persona = new Persona(
 );
 }
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 return persona;
}




public void eliminarPersona(int id) {
 String sql = "DELETE FROM persona WHERE id = ?";
 try (Connection conn = Conexion.getConnection();
 PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setInt(1, id);
 ps.executeUpdate();
 System.out.println("Persona eliminada.");
 } catch (SQLException e) {
 System.err.println("Error al borrar: " + e.getMessage());
 }
}

public static void insertarJugador() {
    String sql = "INSERT INTO jugadores " +
                 "(codigo, Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, 999);
        ps.setString(2, "Jugador Test");
        ps.setString(3, "Spain");
        ps.setString(4, "1.90");
        ps.setInt(5, 90);
        ps.setString(6, "C");
        ps.setString(7, "Lakers");

        ps.executeUpdate();
        System.out.println("Jugador insertado correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al insertar: " + e.getMessage());
    }
}


public static void borrarJugador() {
    String sql = "DELETE FROM jugadores WHERE codigo = ?";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, 999);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("No se encontró el jugador para borrar.");
        }

    } catch (SQLException e) {
        System.err.println("Error al borrar: " + e.getMessage());
    }
}

}
