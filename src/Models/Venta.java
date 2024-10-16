package Models;

import Models.Empleados.Empleado;
import Models.Productos.Producto;
import java.util.ArrayList;

public class Venta {
    //Arreglar en caso de ser necesario
    //version en prueba
    private int idVenta;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private double total;
    private Empleado empleado;

    public Venta(int idVenta, Cliente cliente, Empleado empleado, double total) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.total = total;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
