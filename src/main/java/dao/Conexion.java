/*
    === Singleton ===
    Singleton/instancia única, es un patrón de diseño. Garantizar que una clase sólo tenga una instancia y proporcionar
    un punto de acceso global a ella... (para conectarse a la bbdd sólo una vez con un sólo objeto/instancia).
 */
package dao;

// === importar de java todas las librerías sql ===
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    // === constructor ===
    private Conexion() {
        
    }

    // === lo primero, crear una variable para guardar el estado de la conexión a nuestra bbdd ===
    private static Connection conexion;

    // === crear variable para tener una sóla instancia | para la conexión a la bbdd
    // === y llamar/conectar desde el botón de JForm "Registro"  ===
    private static Conexion instancia;

    // === crear las variables de conexión | parámetros para poder conectarnos a la bbdd (url, usuario, pass) ===
    private static final String URL = "jdbc:mysql://localhost/bd_empleados";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // ============================
    // === método | conectar a la bbdd ===
    // ============================
    public Connection conectar() {
        try {
            // === cargar el Driver para poder conectar con la bbdd ===
            Class.forName("com.mysql.cj.jdbc.Driver");
            // === guardar/obtener la conexión de la bbdd en una variable ===
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // === mensaje de éxito al conectar ===
            //JOptionPane.showMessageDialog(null, "Conexón realizada con éxito");
            // === retornar la conexión ===
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            // === muestra mensaje avisando de error y el tipo de error que es con "e" ===
            System.out.println(e);
        }
        // === retornar conexión | para el "catch" ===
        return conexion;
    }

    // ============================
    // === método | cerrar la conexión ===
    // ============================
    public void cerrarConexion() throws SQLException  {
        try {
            // === cerrar conexión ===
            conexion.close();
            // === mensaje para confirmar desconexión ===
            //JOptionPane.showMessageDialog(null, "Se desconectó de la Base de Datos");
        } catch (SQLException e) {
            System.out.println(e);
            conexion.close();
        } finally  {
            conexion.close();
        }
    }    
    
    
    // ====================
    // === patrón | singleton ===
    // ====================
    public static Conexion getInstance() {
        // === si la instanacia está nula o vacía, crea una nueva ===
        if(instancia == null) {
            // === convertir la variable a objeto/instancia ===
            instancia = new Conexion();
        }
        // === en caso contrario, la instancia no esta vacía/nula, retornar la conexión ===
        return instancia;
    }
    
}
