package src;

public abstract class Cuenta {
    protected int Saldo;
    protected Integer númeroDeCuenta;

    private static int last_cuenta;

    protected static void setLast_cuenta(Integer new_number) {// This implementation is
        last_cuenta = new_number.intValue();
    }

    protected static int getLast_cuenta() {
        return last_cuenta;
    }

    public int getSaldo() {
        return this.Saldo;
    }

    public int getNúmeroDeCuenta() {
        return this.númeroDeCuenta.intValue();
    }

    protected void abonar(int monto) {
        this.Saldo += monto;
    }

    protected void retirar(int monto) throws Exception {
        if (this.Saldo - monto >= 0) {
            this.Saldo -= monto;
        } else {
            throw new Exception("Excede el máximo");
        }
    }
}