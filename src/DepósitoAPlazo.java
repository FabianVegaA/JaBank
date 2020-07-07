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

        this.tasa = 1f + (FondoMutuo.getCrecimiento() - 1f) / 3;
    }

    public void actualizar() {
        if (this.dias > 0) {
            this.monto = Math.round(getMonto() * tasa);
            this.dias -= 1;
        }

        if (this.dias <= 0) {
            this.cobrar();
        }
    }

    public int getMonto() {
        return this.monto;
    }

    protected void cobrar() {
        this.cuenta.abonar(this.monto);
        this.monto = 0;
    }
}