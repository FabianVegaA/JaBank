package src;

public class FondoMutuo implements FormaDeAhorro {
    private String id;
    private static float crecimiento;
    private int monto;
    private Cuenta cuenta;

    public FondoMutuo(int monto, Cuenta cuenta, String id) {
        this.id = id;
        this.monto = monto;
        this.cuenta = cuenta;
    }

    public void actualizar() {
        this.monto *= FondoMutuo.crecimiento;
    }

    public int getMonto() {
        return this.monto;
    }

    protected void cobrar() {
        this.cuenta.abonar(monto);
        this.monto = 0;
    }

    public String getID() {
        return this.id;
    }

    public static void setCrecimiento(float crecimiento) {
        FondoMutuo.crecimiento = crecimiento;
    }
}