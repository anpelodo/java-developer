package bancolombia.com.negocio;

import lombok.Data;

import java.util.TreeSet;

@Data
public class Banco implements ServicioClientes {
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private TreeSet<Cliente> clientes;

    public Banco(String nombre, Domicilio domicilio, String rfc, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.clientes = new TreeSet<>();
    }

    public Banco(String nombre, String calle, int numero, String colonia, String estado, int codigoPostal, String rfc, String telefono) {
        this.nombre = nombre;
        this.domicilio = new Domicilio(calle, numero, colonia, estado, codigoPostal);
        this.rfc = rfc;
        this.telefono = telefono;
        this.clientes = new TreeSet<>();
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        return true;
    }

    @Override
    public boolean eliminarCliente(int numero) {
        Cliente cliente = consultarCliente(numero);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Se dio de baja al cliente numero: " + numero);
            return true;
        }
        return false;
    }

    @Override
    public Cliente consultarCliente(int numero) {
        var result = this.clientes.stream()
                .filter(cliente -> cliente.getNumero() == numero)
                .findFirst();

        if (result.isEmpty()) {
            System.out.println("No se encontro el cliente numero: " + numero);
            return null;
        }

        return result.get();
    }

    @Override
    public TreeSet<Cliente> obtenerClientes() {
        return this.clientes;
    }

    @Override
    public Cliente buscarClientePorRfc(String rfc) {
        var result = clientes.stream()
                .filter(cliente -> cliente.getRfc() == rfc)
                .findFirst();

        if(result.isEmpty()){
            System.out.println("No se encontro el cliente con rfc: " + rfc);
            return null;
        }

        return result.get();
    }

    @Override
    public void listarClientes() {
        System.out.println("=".repeat(232));

        clientes.forEach(System.out::println);

        System.out.println("=".repeat(232));
    }
}
