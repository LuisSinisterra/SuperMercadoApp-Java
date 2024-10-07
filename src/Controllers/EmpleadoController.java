package Controllers;

import Models.Empleados.Empleado;
import Services.EmpleadoService;

import java.util.ArrayList;

public class EmpleadoController {
    EmpleadoService empleadoService;

    public EmpleadoController() {
        empleadoService = new EmpleadoService();
    }

    //Metodo para agregar empleado cajero
    public void agregarEmpleadoCajero(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno) {
        this.empleadoService.agregarEmpleadoCajero(idEmpleado, nombreCompleto, correo, salarioMensual, turno);
    }

    //Metodo para agregar empleaado gerente
    public void agregarEmpleadoGerente(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, double bonificacion) {
        this.empleadoService.agregarEmpleadoGerente(idEmpleado, nombreCompleto, correo, salarioMensual, bonificacion);
    }

    //Metodo para agreagar empleado reponedor
    public void agregarEmpleadoReponedor(int idEmpleado, String nombreCompleto, String correo, double salarioMensual) {
        this.empleadoService.agregarEmpleadoReponedor(idEmpleado, nombreCompleto, correo, salarioMensual);
    }

    //Metodo para eliminar empleado por su id empleado
    public void eliminarEmpleado(int idEmpleado) {
        //this.empleadoService.eliminarEmpleado(idEmpleado);
    }

    public void editarEmpleadoGerente(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, double bonificacion) {
        this.empleadoService.editarEmpleadoGerente(idEmpleado, nombreCompleto, correo, salarioMensual, bonificacion);
    }
    public void editarEmpleadoCajero(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno) {
        this.empleadoService.editarEmpleadoCajero(idEmpleado, nombreCompleto, correo, salarioMensual, turno);
    }
    public void editarEmpleadoReponedor(int idEmpleado, String nombreCompleto, String correo, double salarioMensual) {
        this.empleadoService.editarEmpleadoReponedor(idEmpleado, nombreCompleto, correo, salarioMensual);
    }
    
    public Empleado iniciarSesion(int idEmpleado, String correo) {
        return this.empleadoService.iniciarSesion(idEmpleado, correo);
    }

    public ArrayList<Empleado> getEmpleados() {
        return this.empleadoService.getEmpleados();
    }

}
