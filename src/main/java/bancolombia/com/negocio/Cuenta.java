package bancolombia.com.negocio;

import lombok.Data;

@Data
public abstract class Cuenta implements Comparable<Cuenta> {
    protected int numero;
    protected String fechaApertura;
    protected double saldo;
    protected String fechaCancelacion;

    Cuenta(int numero, String fechaApertura, double saldo, String fechaCancelacion){
        this.numero = numero;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.fechaCancelacion = fechaCancelacion;
    }

    Cuenta(int numero, String fechaApertura, double saldo){
        this.numero = numero;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    Cuenta(int numero, String fechaApertura){
        this.numero = numero;
        this.fechaApertura = fechaApertura;
        this.saldo = 0.0;
    }

    @Override
    public int compareTo(Cuenta cuenta){
        return this.fechaApertura.compareToIgnoreCase(cuenta.getFechaApertura());
    }

}
