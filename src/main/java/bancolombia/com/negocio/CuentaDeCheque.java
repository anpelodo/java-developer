package bancolombia.com.negocio;

public class CuentaDeCheque extends Cuenta{
    private double costoManejoMensual;
    CuentaDeCheque(int numero, String fechaApertura, double saldo, String fechaCancelacion, double costoManejoMensual) {
        super(numero, fechaApertura, saldo, fechaCancelacion);
        this.costoManejoMensual = costoManejoMensual;
    }

    CuentaDeCheque(int numero, String fechaApertura, double saldo, double costoManejoMensual) {
        super(numero, fechaApertura, saldo);
        this.costoManejoMensual = costoManejoMensual;
    }

    CuentaDeCheque(int numero, String fechaApertura, double costoManejoMensual) {
        super(numero, fechaApertura);
        this.costoManejoMensual = costoManejoMensual;
    }
}
