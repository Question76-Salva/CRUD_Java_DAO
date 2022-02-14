/*
    === clase | para implementar los métodos abstractos ===
 */
package interfaces;

import dao.Conexion;
import java.sql.*;
import personas.Empleado;

public class DAOEmpleadoImplementacion implements DAOEmpleado {

    // === instancia de la clase Conexion ===
    Conexion conexion = Conexion.getInstance();

    // ============================
    // === añadir métodos abstractos ===
    // ============================
    // =================================
    // === INSERTAR |  registros en la bbdd ===
    // =================================
    @Override
    public void registrar(Empleado empleado) {
        try {
            // === abrir conexión bbdd ===
            Connection conectar = conexion.conectar();
            // === preparar consulta sql ===
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO empleados VALUES(?, ?)");
            // === pasar los datos | a cada columna de la tabla de la bbdd ===
            insertar.setInt(1, empleado.getId());
            insertar.setString(2, empleado.getEmpleado());
            // === ejecutar consulta sql ===
            insertar.executeUpdate();
            
             // === cerrar la conexión ===
            conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // ==================================
    // === MODIFICAR |  registros en la bbdd ===
    // ==================================
    @Override
    public void modificar(Empleado empleado) {
        try {
            // === abrir conexión bbdd ===
            Connection conectar = conexion.conectar();
            // === preparar consulta sql ===
            PreparedStatement modificar = conectar.prepareStatement("UPDATE empleados SET nombre = ? WHERE id = ?");
            // === pasar los datos | a cada columna de la tabla de la bbdd ===
            modificar.setString(1, empleado.getEmpleado());
            modificar.setInt(2, empleado.getId());
            // === ejecutar consulta sql ===
            modificar.executeUpdate();
            
             // === cerrar la conexión ===
            conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // ================================
    // === ELIMINAR |  registros en la bbdd ===
    // ================================
    @Override
    public void eliminar(Empleado empleado) {
        try {
            // === abrir conexión bbdd ===
            Connection conectar = conexion.conectar();
            // === preparar consulta sql ===
            PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM empleados WHERE id = ?");
            // === pasar los datos | a cada columna de la tabla de la bbdd ===
            eliminar.setInt(1, empleado.getId());
            // === ejecutar consulta sql ===
            eliminar.executeUpdate();
            
             // === cerrar la conexión ===
            conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // ===============================
    // === BUSCAR |  registros en la bbdd ===
    // ===============================
    @Override
    public void buscar(Empleado empleado) {
        try {
            // === abrir conexión bbdd ===
            Connection conectar = conexion.conectar();
            // === preparar consulta sql ===
            PreparedStatement buscar = conectar.prepareStatement("SELECT * FROM empleados WHERE id = ?");
            // === pasar los datos | a cada columna de la tabla de la bbdd ===
            buscar.setInt(1, empleado.getId());
            // === guardar la consulta sql ===
            ResultSet consulta = buscar.executeQuery();
            
            // === comprobar si hay registros en la tabla | o si está vacia ===
            if (consulta.next()) {
                // === establecer un ID de lo que obtengamos de la consulta | la consulta es un String | parsear a Int ===
                empleado.setId(Integer.parseInt(consulta.getString("id")));
                // === establecer un NOMBRE de lo que obtengamos de la consulta ===
                empleado.setEmpleado(consulta.getString("nombre"));                
            }
            
            // === cerrar la conexión ===
            conexion.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
