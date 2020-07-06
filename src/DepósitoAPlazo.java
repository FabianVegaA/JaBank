package src;

public class DepósitoAPlazo implements FormaDeAhorro {
    private final float tasa;
    private int dias;
    private int monto;
    private Cuenta cuenta;

    public DepósitoAPlazo(int initialMonto, Cuenta cuenta, int dias) {
        this.cuenta = cuenta;
        this.monto = initialMonto;
        this.dias = dias;

        this.tasa = (float) (1d + (FondoMutuo.getCrecimiento() - 1d) / 3);
    }

    public void actualizar() {
        if (this.dias > 0) {
            monto = Math.round(getMonto() * tasa);
            this.dias -= 1;
        }

        if (this.dias <= 0) {
            cobrar();
        }
    }

    public int getMonto() {
        return monto;
    }

    protected void cobrar() {
        this.cuenta.abonar(this.monto);
        this.monto = 0;
    }
}