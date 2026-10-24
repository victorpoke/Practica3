import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numero;
    private String titular;
    private double saldo;
    private List<Movimiento> movimientos;

    public Cuenta(String numero, String titular) 
    {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.movimientos = new ArrayList<>();
    }

    public void ingresar(double x) 
    {
        if (x > 0) {
            saldo = saldo + x;
            movimientos.add(new Movimiento(x, 'D', "Ingreso en cuenta"));
        }
    }

    public void retirar(double x) 
    {
        if (x > 0 && saldo >= x) {
            saldo = saldo - x;
            movimientos.add(new Movimiento(x, 'H', "Reintegro en cuenta"));
        }
    }

    public double getSaldo() 
    {
        saldo = 0.0;
        for (Movimiento m : movimientos) {
            if (m.getSigno() == 'D') {
                saldo = saldo + m.getImporte();
            } else {
                saldo = saldo + m.getImporte();
            }
        }
        return saldo;
    }

    public String getNumero() { return numero; }
    public String getTitular() { return titular; }
    public List<Movimiento> getMovimientos() { return movimientos; }
}
