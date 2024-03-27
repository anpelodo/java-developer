package bancolombia.com.negocio;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Cliente implements ServicioCuentas, Comparable<Cliente> {

    private int numero;
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cuenta> cuentas;
    private String fechaNacimiento;

    public Cliente(int numero, String nombre, Domicilio domicilio, String rfc, String telefono, String fechaNacimiento) {
        this.numero = numero;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.cuentas = new ArrayList<>();
    }

    public Cliente(int numero, String nombre, String calle, int numeroDomicilio, String colonia, String estado, int codigoPostal, String rfc, String telefono, String fechaNacimiento) {
        this.numero = numero;
        this.nombre = nombre;
        this.domicilio = new Domicilio(calle, numeroDomicilio, colonia, estado, codigoPostal);
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.cuentas = new ArrayList<>();
    }

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        return this.cuentas.add(cuenta);
    }

    @Override
    public boolean cancelarCuenta(int numero) {
        var cuenta = this.cuentas.stream()
                .filter(cuentast -> cuentast.getNumero() == numero)
                .findFirst();

        if (cuenta.isPresent()) {
            cuenta.get().setFechaCancelacion((new Date()).toString());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void abonarCuenta(int numero, double abono) {
        this.cuentas.stream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .forEach(cuenta -> cuenta.setSaldo(cuenta.getSaldo() + abono));
    }

    @Override
    public void retirar(int numero, double retiro) {
        this.cuentas.stream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .forEach(cuenta -> cuenta.setSaldo(cuenta.getSaldo() - retiro));
    }

    @Override
    public ArrayList<Cuenta> obtenerCuentas() {
        return this.cuentas;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.numero - o.numero;
    }
}
