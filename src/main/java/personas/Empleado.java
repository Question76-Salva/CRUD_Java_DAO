
package personas;

public class Empleado {

    // ==================================
    // === propiedades | columnas tabla bbdd ===
    // ==================================
    private int id;
    private String empleado;
    
    // ====================
    // === getters & setters ===
    // ====================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    
}
