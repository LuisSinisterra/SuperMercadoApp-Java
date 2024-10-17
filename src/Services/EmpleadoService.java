package Services;

import Dao.EmpleadoDAO;
import Models.Empleados.Cajero;
import Models.Empleados.Empleado;
import Models.Empleados.Gerente;
import Models.Empleados.Reponedor;

import java.util.ArrayList;

public class EmpleadoService {

    ArrayList<Empleado> empleados;
    EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        //ArrayList que sera un contenedor polimorfico para poder agregar los 3 tipos de empleados del sistema
        this.empleados = new ArrayList<>();
        this.empleadoDAO = new EmpleadoDAO();
        this.empleados.add(new Gerente(100, "admin", "admin@", 2000000, 0.1));
    }

    public void agregarEmpleado(String tipoEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno, double bonificacion) throws RuntimeException {
        if(tipoEmpleado.equals("Gerente")) {
            Gerente gerente = new Gerente(0, nombreCompleto, correo, salarioMensual, bonificacion);
            this.empleadoDAO.agregarEmpleado(gerente);
        } else if (tipoEmpleado.equals("Cajero")) {
            Cajero cajero = new Cajero(0, nombreCompleto, correo, salarioMensual, turno);
            this.empleadoDAO.agregarEmpleado(cajero);
        } else if (tipoEmpleado.equals("Reponedor")) {
            Reponedor reponedor = new Reponedor(0, nombreCompleto, correo, salarioMensual);
            this.empleadoDAO.agregarEmpleado(reponedor);
        } else {
            throw new RuntimeException("Tipo de empleado no válido: " + tipoEmpleado);
        }
    }

    public void eliminarEmpleado(int idEmpleado) throws RuntimeException {

        for (Empleado empleado : this.empleados) {
            this.empleadoDAO.eliminarEmpleado(idEmpleado);
            return;
        }

        throw new RuntimeException("No se encuentra el empleado que desea eliminar");
    }

    public void editarEmpleadoCajero(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno) throws RuntimeException {
        for (Empleado empleado : this.empleados) {
            System.out.println("Revisando empleado con ID: " + empleado.getIdEmpleado());

            if (empleado.getIdEmpleado() == idEmpleado) {
                System.out.println("Empleado encontrado: " + empleado.getNombreCompleto());

                if (empleado instanceof Cajero) {
                    empleado.setNombreCompleto(nombreCompleto);
                    empleado.setSalarioMensual(salarioMensual);
                    empleado.setCorreo(correo);
                    ((Cajero) empleado).setTurno(turno);
                    System.out.println("Empleado editado con éxito: " + nombreCompleto);
                    return;
                } else {
                    System.out.println("El empleado no es un cajero.");
                }
            }
        }
        
        throw new RuntimeException("No se encuentra el cajero que desea editar");
    }

    public void editarEmpleadoGerente(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, double bonificacion) throws RuntimeException {
        for (Empleado empleado : this.empleados) {
            System.out.println("Revisando empleado con ID: " + empleado.getIdEmpleado());

            if (empleado.getIdEmpleado() == idEmpleado) {
                System.out.println("Empleado encontrado: " + empleado.getNombreCompleto());

                if (empleado instanceof Gerente) {
                    empleado.setNombreCompleto(nombreCompleto);
                    empleado.setSalarioMensual(salarioMensual);
                    empleado.setCorreo(correo);
                    ((Gerente) empleado).setBonificacion(bonificacion);
                    System.out.println("Gerente editado con éxito: " + nombreCompleto);
                    return;
                } else {
                    System.out.println("El empleado no es un gerente.");
                }
            }
        }
        throw new RuntimeException("No se encuentra el gerente que desea editar");
    }

    public void editarEmpleadoReponedor(int idEmpleado, String nombreCompleto, String correo, double salarioMensual) throws RuntimeException {
        for (Empleado empleado : this.empleados) {
            System.out.println("Revisando empleado con ID: " + empleado.getIdEmpleado());

            if (empleado.getIdEmpleado() == idEmpleado) {
                System.out.println("Empleado encontrado: " + empleado.getNombreCompleto());

                if (empleado instanceof Reponedor) {
                    empleado.setNombreCompleto(nombreCompleto);
                    empleado.setSalarioMensual(salarioMensual);
                    empleado.setCorreo(correo);
                    System.out.println("Reponedor editado con éxito: " + nombreCompleto);
                    return;
                } else {
                    System.out.println("El empleado no es un reponedor.");
                }
            }
        }
        throw new RuntimeException("No se encuentra el reponedor que desea editar");
    }

    private boolean buscarEmpleado(int idEmpleado) {
        for (Empleado empleado : this.empleados) {
            if (empleado.getIdEmpleado() == idEmpleado) {
                return true;
            }
        }
        return false;
    }

    public Empleado iniciarSesion(int idEmpleado, String correo) {
        if (buscarEmpleado(idEmpleado)) {
            if (correo == null) {
                return null;
            }

            for (Empleado empleado : this.empleados) {
                if (empleado.getIdEmpleado() == idEmpleado && correo.equals(empleado.getCorreo())) {
                    return empleado;
                }
            }
        }
        return null;
    }

    public ArrayList<Empleado> getEmpleados() {
        return this.empleadoDAO.getEmpleados();
    }

}
