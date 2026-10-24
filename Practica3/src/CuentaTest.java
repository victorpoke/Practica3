import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CuentaTest {

    @Test
    public void testIngresar() {
        Cuenta cuenta = new Cuenta("01111", "ABC");
        cuenta.ingresar(100.0);
        assertEquals(100.0, cuenta.getSaldo(), 0.001);
    }
}
