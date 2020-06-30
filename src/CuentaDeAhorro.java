package src;

public class CuentaDeAhorro extends Cuenta implements FormaDeAhorro {
    private final float tasa;
    private int días;

    public CuentaDeAhorro(int númeroDeCuenta, float tasa) {
        this.númeroDeCuenta = númeroDeCuenta;
        this.tasa = tasa;
    }

    public CuentaDeAhorro(int númeroDeCuenta) {
        this.tasa = 1.0001f;
        this.númeroDeCuenta = númeroDeCuenta;

    }

    public void actualizar() {
        Saldo *= tasa;
    }

    public int getMonto() {
        return Saldo;
    }

    protected void retirar(int monto) {
        if (this.días == 0) {
            try {
                if (this.Saldo >= monto) {
                    this.Saldo -= monto;
                    this.días += 7;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Monto solicitado es mayor a su saldo");
            }
        }
    }

}