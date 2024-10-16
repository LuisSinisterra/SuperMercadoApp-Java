package Dao;

import Models.Empleados.Cajero;
import Models.Empleados.Empleado;
import Models.Empleados.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpleadoDAO {

    private DataBaseConnector dbc = new DataBaseConnector();

    public void agregarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO Productos (nombre_completo, correo, salario, tipo_empleado, turno, bonificacion) VALUES (?,?,?,?,?,?)";
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, empleado.getNombreCompleto());
            pstmt.setString(2, empleado.getCorreo());
            pstmt.setDouble(3, empleado.getSalarioMensual());

            if(empleado instanceof Gerente){
                pstmt.setString(4, "Gerente");
                pstmt.setDouble(6, ((Gerente) empleado).getBonificacion());
                pstmt.setString(5, "No aplica");
            } else if(empleado instanceof Cajero){
                pstmt.setString(4, "Cajero");
                pstmt.setString(5, ((Cajero) empleado).getTurno());
                pstmt.setDouble(6, 0);
            } else {
                pstmt.setString(4, "Reponedor");
                pstmt.setString(5, "No aplica");
                pstmt.setDouble(6, 0);
            }

            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL AGREGAR UN EMPLEADO " + e.getMessage());
        }

    }

}
