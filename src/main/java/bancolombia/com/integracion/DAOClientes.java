package bancolombia.com.integracion;

import bancolombia.com.negocio.Cliente;
import bancolombia.com.negocio.Domicilio;
import bancolombia.com.negocio.ServicioClientes;
import lombok.Data;

import java.sql.*;
import java.util.TreeSet;

public class DAOClientes implements ServicioClientes {
    private String url="jdbc:mysql://localhost:3306/banca";
    private String usuario="root";
    private String password="1234567890";
//    private DriverManager driver;
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    private int renglones;

    public DAOClientes(){
        try {
            this.conexion = DriverManager.getConnection(this.url,this.usuario, this.password);
            this.sentencia = this.conexion.createStatement();
        } catch (SQLException e){
            System.out.println("Hubo un problema de conexion con la BD: " + e.getMessage());
        }
    }

    public DAOClientes (String url, String usuario, String password){
        this.url = url;
        this.usuario = usuario;
        this.password = password;

        try {
            this.conexion = DriverManager.getConnection(this.url,this.usuario, this.password);
            this.sentencia = this.conexion.createStatement();
        } catch (SQLException e){
            System.out.println("Hubo un problema de conexion con la BD: " + e.getMessage());
        }
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        String query = "INSERT INTO CLIENTES (numero,nombre,domicilio,rfc,telefono) VALUES (" +
                cliente.getNumero() + ",'" +
                cliente.getNombre() + "','" +
                cliente.getDomicilio().getEstado() + "','"+
                cliente.getRfc() + "','" +
                cliente.getTelefono() + "'" +
                ")";
        System.out.println(query);

        try {
            int val = this.sentencia.executeUpdate(query);
            return val > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarCliente(int numero) {
        String query = "DELETE FROM CLIENTES WHERE numero = " + numero;
        System.out.println("query: " + query);

        try {
            int val = this.sentencia.executeUpdate(query);
            return val > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Cliente consultarCliente(int numero) {
        String query = "SELECT * FROM CLIENTES WHERE numero = " + numero;
        System.out.println("query: " + query);

        Cliente cliente = null;

        try {
            this.resultado = this.sentencia.executeQuery(query);
            if (this.resultado.next()) {
                cliente = this.extractData(this.resultado);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el cliente: " + e.getMessage());
        }

        return cliente;
    }

    @Override
    public TreeSet<Cliente> obtenerClientes() {
        String query = "SELECT * FROM CLIENTES";
        System.out.println("query: " + query);

        TreeSet<Cliente> clientes = new TreeSet<>();
        try {
            this.resultado = this.sentencia.executeQuery(query);
            while (this.resultado.next()) {
                clientes.add(this.extractData(this.resultado));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente buscarClientePorRfc(String rfc) {
        String query = "SELECT * FROM CLIENTES WHERE rfc = '" + rfc + "'";
        System.out.println("query: " + query);

        Cliente cliente = null;

        try {
            this.resultado = this.sentencia.executeQuery(query);

            if (this.resultado.next()) {
                cliente = this.extractData(this.resultado);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el cliente: " + e.getMessage());
        }

        return cliente;
    }

    @Override
    public void listarClientes() {
        this.obtenerClientes().forEach(System.out::println);
    }

    private Cliente extractData(ResultSet resultado) throws SQLException {
        final int numeroCliente = resultado.getInt("numero");
        final String nombre = resultado.getString("nombre");
        final String estado = resultado.getString("domicilio");
        final String rfc = resultado.getString("rfc");
        final String telefono = resultado.getString("telefono");
        final String fechaNacimiento = resultado.getString("fechaNacimiento");

        final Domicilio domicilio = new Domicilio(null, 0, null, estado, 0);

        return new Cliente(numeroCliente, nombre, domicilio, rfc, telefono, fechaNacimiento);

    }
}
