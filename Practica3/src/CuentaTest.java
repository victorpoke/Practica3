import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CuentaTest {

    @Test
    public void testSuma() { 
    	assertEquals(5, Matematicas.suma(2,3)); 
    	} 
    
    @Test
    public void testIngresar() {
        Cuenta cuenta = new Cuenta("01111", "ABC");
        cuenta.ingresar(100.0);
        assertEquals(100.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testRetirar() {
        Cuenta cuenta = new Cuenta("01111", "ABC");
        cuenta.ingresar(200.0);
        cuenta.retirar(50.0);
        assertEquals(150.0, cuenta.getSaldo(), 0.001);
    }
}
