package Controllers;

import Models.Empleados.Empleado;
import Services.EmpledoService;

public class EmpleadoController {
    EmpledoService empleadoService;

    public EmpleadoController() {
        empleadoService = new EmpledoService();
    }

    public void agregarEmpleado(Empleado empleado) {
        this.empleadoService.agregarEmpleado(empleado);
    }

    public void eliminarEmpleado(int idEmpleado) {
        this.empleadoService.eliminarEmpleado(idEmpleado);
    }

    public void editarEmpleado(Empleado empleado) {
        this.empleadoService.editarEmpleado(empleado);
    }

}
