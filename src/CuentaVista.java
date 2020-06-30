package src;

public class CuentaVista extends Cuenta implements Tarjeta {
    
    public CuentaVista(int númeroDeCuenta){
        this.númeroDeCuenta = númeroDeCuenta;
    }
    
    public void transferir(int númeroDeCuenta, int monto){
        this.retirar(monto);
        this.abonar(monto);
    }
}