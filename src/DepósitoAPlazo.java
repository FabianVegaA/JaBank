package src;

public class DepósitoAPlazo implements FormaDeAhorro{
    private Long tasa;
    private int dias;
    private int monto;
    private Cuenta cuenta;

    public DepósitoAPlazo(int initialMonto, Cuenta cuenta, int dias){
        this.cuenta = cuenta;
        this.monto = initialMonto;
        this.dias = dias;
    }

    public void actualizar() {
        monto *= tasa;
    }

    public int getMonto() {
        return monto;
    }
}