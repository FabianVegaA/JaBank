package src;

public class CuentaVista extends Cuenta implements Tarjeta {

    public CuentaVista(Integer monto_inicial) {
        Cuenta.setLast_cuenta(Cuenta.getLast_cuenta() + 1);
        this.númeroDeCuenta = Cuenta.getLast_cuenta();

        this.Saldo = monto_inicial.intValue();
    }

    public void transferir(int númeroDeCuenta, int monto) {
        try {
            this.retirar(monto);
        } catch (Exception ex) {
            System.out.println("Ha habido un problema al hacer esta transferencia.");
            System.out.println("transferir " + monto + " " + getNúmeroDeCuenta() + " " + númeroDeCuenta);
        }

        this.abonar(monto);
    }
}