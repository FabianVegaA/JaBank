package src;

public class DepósitoAPlazo implements FormaDeAhorro {
    private final Double tasa;
    private int dias;
    private int monto;
    private Cuenta cuenta;

    public DepósitoAPlazo(int initialMonto, Cuenta cuenta, int dias) {
        this.cuenta = cuenta;
        this.monto = initialMonto;
        this.dias = dias;

        this.tasa = 1 + (((double) (1f - FondoMutuo.getCrecimiento())) / 3);
    }

    public void actualizar() {
        monto *= tasa;
    }

    public int getMonto() {
        return monto;
    }

    protected void retirar() {
        if (this.dias == 0) {
            this.cuenta.abonar(this.monto);
            this.monto = 0;
        } else {
            System.out.println("Aún no es tiempo para retirar, quedan " + Integer.toString(this.dias)
                    + " días para retirar su deposito");
        }
    }
}