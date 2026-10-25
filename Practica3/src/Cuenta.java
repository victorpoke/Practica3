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

    public Cuenta(String numero, String titular, double saldoInicial) 
    {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.movimientos = new ArrayList<>();
        if (saldoInicial > 0) 
        {
            movimientos.add(new Movimiento(saldoInicial, 'D', "Saldo inicial"));
        }
    }
    
    public void ingresar(double x) 
    {
        if (x > 0) 
        {
            saldo = saldo + x;
            movimientos.add(new Movimiento(x, 'D', "Ingreso en cuenta"));
        }
    }

    public void retirar(double x) 
    {
    	if (x > 0) 
    	{
            double saldoActual = getSaldo();
            // Límite de 500
            if ((saldoActual - x) >= -500) 
            {
                movimientos.add(new Movimiento(x, 'H', "Reintegro en cuenta"));
            } 
            else 
            {
                throw new IllegalArgumentException("Fondo bajo (saldo -" + Math.abs(saldoActual - x) + "€) en la cuenta " + numero + " para el reintegro de " + x + "€");
            }
        }
    }

    public double getSaldo() 
    {
        saldo = 0.0;
        for (Movimiento m : movimientos) 
        {
            if (m.getSigno() == 'D') 
            {
                saldo = saldo + m.getImporte();
            } 
            else 
            {
                saldo = saldo - m.getImporte();
            }
        }
        return saldo;
    }

    public String getNumero() { return numero; }
    public String getTitular() { return titular; }
    public List<Movimiento> getMovimientos() { return movimientos; }
}
