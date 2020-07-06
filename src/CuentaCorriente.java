package src;

public class CuentaCorriente extends Cuenta implements Tarjeta {
    public CuentaCorriente(Integer monto_inicial) {
        Cuenta.setLast_cuenta(Cuenta.getLast_cuenta() + 1);
        this.númeroDeCuenta = Cuenta.getLast_cuenta();

        this.Saldo = monto_inicial.intValue();
    }

    public void transferir(int númeroDeCuenta, int monto) {
        try {
            ReadFile.getCuenta(númeroDeCuenta).abonar(monto);

            this.retirar(monto);

        } catch (NullPointerException ex) {
            System.out.println("La cuenta :" + númeroDeCuenta + " no ha sido  encontrada");
        }
    }

    protected void retirar(int monto) {
        this.Saldo -= monto;

    }
}