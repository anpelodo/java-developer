package bancolombia.com;

import bancolombia.com.integracion.DAOClientes;
import bancolombia.com.negocio.Banco;
import bancolombia.com.negocio.Cliente;
import bancolombia.com.negocio.CuentaDeAhorro;

public class Main {
    public static void main(String[] args) {
        Banco bancolombia = new Banco("BanCoppel", "Madero", 155, "Centro", "CDMX", 10010, "BCS032212", "5510234589");
        System.out.println(bancolombia);
        Cliente cliente1 = new Cliente(1000, "Fernando", "Aldama", 206, "Centro", "Mexico", 50000, "JAHF670223", "7222142780", "670223");
        Cliente cliente2 = new Cliente(5000, "Veronica", "Duraznos", 57, "Calvario", "Yucatan", 92000, "RESV900808", "1234213445", "900808");
        Cliente cliente3 = new Cliente(2000, "Arturo", "Morelos", 500, "Independencia", "Chihuahua", 24500, "AARS690114", "568213444", "690114");
        Cliente cliente4 = new Cliente(7000, "Luz Maria", "Juarez", 1212, "ProHogar", "Guerrero", 32000, "MMLM801004", "123412344", "801004");


        var daoCliente = new DAOClientes();

        daoCliente.agregarCliente(cliente1);
        daoCliente.agregarCliente(cliente2);
        daoCliente.agregarCliente(cliente3);
        daoCliente.agregarCliente(cliente4);
        daoCliente.listarClientes();

        System.out.println(daoCliente.consultarCliente(1000));
        System.out.println(daoCliente.consultarCliente(1050));
        System.out.println(daoCliente.buscarClientePorRfc("AARS690114"));
        System.out.println(daoCliente.buscarClientePorRfc("AARS690115"));
        System.out.println(daoCliente.eliminarCliente(1000));
        daoCliente.listarClientes();
//        bancolombia.agregarCliente(cliente2);
//        bancolombia.agregarCliente(cliente3);
//        bancolombia.agregarCliente(cliente1);
//        bancolombia.agregarCliente(cliente4);
//        bancolombia.listarClientes();
//        bancolombia.consultarCliente(2500);
//        bancolombia.consultarCliente(7000);
//        bancolombia.eliminarCliente(2000);
//        bancolombia.eliminarCliente(1500);
//        bancolombia.buscarClientePorRfc("RESV900808");
//        bancolombia.buscarClientePorRfc("AAAA451011");
//
//        var cuenta1 = new CuentaDeAhorro(1001, "2021-01-01", 0.0, 0.05);
//        var cuenta2 = new CuentaDeAhorro(1002, "2022-03-15", 100.0, 0.08);
//        cliente1.agregarCuenta(cuenta1);
//        cliente1.agregarCuenta(cuenta2);
    }
}