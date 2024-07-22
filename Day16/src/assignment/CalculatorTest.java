package assignment;

//CalculatorTest.java
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

 private Calculator calculator;

 @BeforeClass
 public static void setUpBeforeClass() throws Exception {
     System.out.println("This runs once before any of the test methods.");
 }

 @AfterClass
 public static void tearDownAfterClass() throws Exception {
     System.out.println("This runs once after all the test methods.");
 }

 @Before
 public void setUp() throws Exception {
     calculator = new Calculator();
     System.out.println("This runs before each test method.");
 }

 @After
 public void tearDown() throws Exception {
     System.out.println("This runs after each test method.");
 }

 @Test
 public void testAdd() {
     assertEquals(8, calculator.add(5, 3));
     assertEquals(0, calculator.add(-1, 1));
     assertEquals(-5, calculator.add(-2, -3));
 }

 @Test
 public void testSubtract() {
     assertEquals(2, calculator.subtract(5, 3));
     assertEquals(-2, calculator.subtract(-1, 1));
     assertEquals(1, calculator.subtract(-2, -3));
 }

 @Test
 public void testMultiply() {
     assertEquals(15, calculator.multiply(5, 3));
     assertEquals(-1, calculator.multiply(-1, 1));
     assertEquals(6, calculator.multiply(-2, -3));
 }

 @Test
 public void testDivide() {
     assertEquals(2, calculator.divide(6, 3));
     assertEquals(-1, calculator.divide(-1, 1));
     assertEquals(2, calculator.divide(-6, -3));
 }

 @Test(expected = IllegalArgumentException.class)
 public void testDivideByZero() {
     calculator.divide(1, 0);
 }
}
