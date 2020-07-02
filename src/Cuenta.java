package src;

public abstract class Cuenta {
    protected int Saldo;
    protected Integer númeroDeCuenta;

    private static int last_cuenta;

    protected static void setLast_cuenta(Integer new_number) {
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

    protected void retirar(int monto) {
        try {
            if (this.Saldo >= monto) {
                this.Saldo -= monto;
            } else {
                throw new Exception("Excede el máximo");
            }

        } catch (Exception e) {
            System.out.println("No tiene saldo suficiente");
        }
    }
}