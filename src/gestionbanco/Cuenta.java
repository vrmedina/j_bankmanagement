
package gestionbanco;

public class Cuenta {
    private int nCuenta;
    private double saldo;

    public Cuenta(int nCuenta, double saldo) {
        this.nCuenta = nCuenta;
        this.saldo = saldo;
    }

    public int getnCuenta() {
        return nCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void ingresarDinero(double cantidad) {
        saldo += cantidad;
    }
    
    public void retirarDinero(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        }else {
            System.out.println("No hay saldo suficiente en su cuenta");
        }
    }
    
    
}
