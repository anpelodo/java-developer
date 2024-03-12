package bancolombia.com.negocio;

import java.util.ArrayList;
public interface ServicioClientes {
    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numero);
    Cliente consultarCliente(int numero);
    ArrayList<Cliente> obtenerClientes();
    Cliente buscarClientePorRfc(String rfc);
    void listarClientes();

}
