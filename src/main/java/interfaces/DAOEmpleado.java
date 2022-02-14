/*
    === interface | para crear los métodos abstractos del CRUD ===
*/

package interfaces;

import personas.Empleado;

public interface DAOEmpleado {
         
    // ======================
    // === métodos abstractos ===
    // ======================
    public void registrar(Empleado empleado); 
    
    public void modificar(Empleado empleado);
    
    public void eliminar(Empleado empleado);
    
    public void buscar(Empleado empleado);
}
