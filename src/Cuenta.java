package src;

public abstract class Cuenta {
    protected int Saldo;
    protected Integer númeroDeCuenta;

    public int getSaldo() {
        return this.Saldo;
    }

    public int getNúmeroDeCuenta() {
        return this.númeroDeCuenta.intValue();
    }

    protected void abonar(int monto) {
        this.Saldo += monto;
    }

    protected void retirar(int monto) {
        try {
            if (this.Saldo >= monto) {
                this.Saldo -= monto;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("No tiene saldo suficiente");
        }
    }
}