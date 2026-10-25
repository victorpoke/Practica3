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
    
    @Test
    public void testCasoClaseTest0014() 
    {      
        Cuenta cuenta12345 = new Cuenta("12345", "Titular 1", 50.0);
        Cuenta cuenta67890 = new Cuenta("67890", "Titular 2", 0.0);

        cuenta12345.retirar(200.0);
        cuenta67890.retirar(350.0);
        cuenta12345.ingresar(100.0);

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> { cuenta67890.retirar(200.0); });
        assertTrue(exception1.getMessage().contains("Fondos insuficientes"));

        cuenta67890.retirar(150.0);
        cuenta12345.retirar(200.0);
        cuenta67890.ingresar(50.0);

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> { cuenta67890.retirar(100.0); });
        assertTrue(exception2.getMessage().contains("Fondos insuficientes"));

        assertEquals(-250.0, cuenta12345.getSaldo(), 0.001); 
        assertEquals(-450.0, cuenta67890.getSaldo(), 0.001); 
    }
    
    @Test
    public void testNegativoSuperarLimiteDescubierto() 
    {
        // Cuenta con saldo 0. 
        Cuenta cuenta = new Cuenta("99999", "Negativa", 0.0);
        
        // Intentar retirar 600 superando los 500 permitidos
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> { cuenta.retirar(600.0); });
        
        assertTrue(excepcion.getMessage().contains("Fondos insuficientes"));
    }
    
    @Test
    public void testNegativoImporteInvalidoIngresoRetirada() 
    {
        Cuenta cuenta = new Cuenta("11111", "Prueba", 100.0);
        
        // Ingresar un importe negativo 
        cuenta.ingresar(-50.0);
        assertEquals(100.0, cuenta.getSaldo(), 0.001);
        
        // Retirar un importe negativo 
        cuenta.retirar(-20.0);
        assertEquals(100.0, cuenta.getSaldo(), 0.001);
    }
}
