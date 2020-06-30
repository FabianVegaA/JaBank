package src;

public class CuentaCorriente extends Cuenta implements Tarjeta {
    public CuentaCorriente(int númeroDeCuenta) {
        this.númeroDeCuenta = númeroDeCuenta;
    }

    public void transferir(int númeroDeCuenta, int monto) {

    }
}