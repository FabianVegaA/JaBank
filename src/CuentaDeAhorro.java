package src;

public class CuentaDeAhorro extends Cuenta implements FormaDeAhorro {
    private float tasa;
    private int dias;

    public CuentaDeAhorro(int númeroDeCuenta, float tasa){
        this.númeroDeCuenta = númeroDeCuenta;
        this.tasa = tasa;
    }

    public CuentaDeAhorro(int númeroDeCuenta){
        this.númeroDeCuenta = númeroDeCuenta;
    }

    public void actualizar() {
        Saldo *= tasa;
    }

    public int getMonto() {
        return Saldo;
    }

}