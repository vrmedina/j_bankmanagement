
package gestionbanco;

public class Cliente {
    private String nombre;
    private String apellido;
    private double cedula;
    private Cuenta cuentas[];

    public Cliente(String nombre, String apellido, double cedula, Cuenta[] cuentas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getCedula() {
        return cedula;
    }
    
    public double consultaSaldo(int n) {
        return cuentas[n].getSaldo();
    }

    public void ingresarDinero(int n, double cantidad) {
        cuentas[n].ingresarDinero(cantidad);
    }
    
    public void retirarDinero(int n, double cantidad) {
        cuentas[n].retirarDinero(cantidad);
    }
}
