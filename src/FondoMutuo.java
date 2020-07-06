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
        this.monto = Math.round(getMonto() * getCrecimiento());
    }

    public int getMonto() {
        return this.monto;
    }

    protected void cobrar() {
        this.cuenta.abonar(getMonto());
        this.monto = 0;
    }

    public String getID() {
        return this.id;
    }

    public static float getCrecimiento() {
        return FondoMutuo.crecimiento;
    }

    public static void setCrecimiento(float crecimiento) {
        FondoMutuo.crecimiento = crecimiento;
    }
}