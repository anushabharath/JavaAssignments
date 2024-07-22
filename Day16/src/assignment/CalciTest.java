package assignment;
// CalculatorTest.java
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalciTest {

    @Test
    public void testAdd() {
        Calci calculator = new Calci();
        assertEquals(8, calculator.add(5, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    public void testSubtract() {
        Calci calculator = new Calci();
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(-1, 1));
        assertEquals(1, calculator.subtract(-2, -3));
    }

    @Test
    public void testMultiply() {
        Calci calculator = new Calci();
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(-1, calculator.multiply(-1, 1));
        assertEquals(6, calculator.multiply(-2, -3));
    }

    @Test
    public void testDivide() {
        Calci calculator = new Calci();
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-1, calculator.divide(-1, 1));
        assertEquals(2, calculator.divide(-6, -3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Calci calculator = new Calci();
        calculator.divide(1, 0);
    }
}

