package bancolombia.com.negocio;

public class CuentaDeAhorro extends Cuenta {
    private double tasaInteresMensual;

    CuentaDeAhorro(int numero, String fechaApertura, double saldo, String fechaCancelacion, double tasaInteresMensual) {
        super(numero, fechaApertura, saldo, fechaCancelacion);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    CuentaDeAhorro(int numero, String fechaApertura, double saldo, double tasaInteresMensual) {
        super(numero, fechaApertura, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    CuentaDeAhorro(int numero, String fechaApertura, double tasaInteresMensual) {
        super(numero, fechaApertura);
        this.tasaInteresMensual = tasaInteresMensual;
    }


    double calcularIntereses() {
        return this.saldo * this.tasaInteresMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeAhorro{" +
                "tasaInteresMensual=" + tasaInteresMensual +
                ", numero=" + numero +
                ", fechaApertura='" + fechaApertura + '\'' +
                ", saldo=" + saldo +
                ", fechaCancelacion='" + fechaCancelacion + '\'' +
                '}';
    }
}
