package src;

public class CuentaDeAhorro extends Cuenta implements FormaDeAhorro {
    private final float tasa;
    private int días;

    public CuentaDeAhorro(Integer monto_inicial, float tasa) {
        Cuenta.setLast_cuenta(Cuenta.getLast_cuenta() + 1);// It is Update this number
        this.númeroDeCuenta = Cuenta.getLast_cuenta();// The Cuenta is creaded with the last number

        this.Saldo = monto_inicial.intValue();
        this.tasa = tasa;
    }

    public CuentaDeAhorro(Integer monto_inicial) {
        Cuenta.setLast_cuenta(Cuenta.getLast_cuenta() + 1);// It is Update this number
        this.númeroDeCuenta = Cuenta.getLast_cuenta();// The Cuenta is creaded with the last number

        this.Saldo = monto_inicial.intValue();
        this.tasa = 1.0001f;
    }

    public void actualizar() {
        Saldo = Math.round(getSaldo() * tasa);
        if (this.días > 0) {
            this.días--;
        }
    }

    public int getMonto() {
        return this.Saldo;
    }

    protected void retirar(int monto) throws Exception {
        if (this.días <= 0) {
            if (this.Saldo - monto > 0) {
                this.Saldo -= monto;
                this.días += 7;
            } else {
                throw new Exception();
            }
        }
        else{
            throw new Exception();
        }
    }

}