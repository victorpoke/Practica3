public class Movimiento {
    private double importe;
    private char signo; 
    private String detalle;

    public Movimiento(double importe, char signo, String detalle) 
    {
        this.importe = importe;
        this.signo = signo;
        this.detalle = detalle;
    }

    public double getImporte() 
    {    return importe;   }

    public char getSigno() 
    {    return signo;}

    public String getDetalle() 
    {   return detalle;}
}
