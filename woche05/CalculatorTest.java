import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalculatorTest.
 */
public class CalculatorTest {
    private Calculator calculator;

    /**
     * Default constructor for test class CalculatorTest
     */
    public CalculatorTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testPlusEqualsZero() {
        assertEquals(0, calculator.plus(0, 0));
        assertEquals(0, calculator.plus(1, -1));
        assertEquals(0, calculator.plus(-1, 1));
    }

    @Test
    public void testPlusEqualsOne() {
        assertEquals(1, calculator.plus(0, 1));
        assertEquals(1, calculator.plus(1, 0));
        assertEquals(1, calculator.plus(50, -49));
        assertEquals(1, calculator.plus(-10, 11));
    }

    @Test
    public void testPlus() {
        assertEquals(99, calculator.plus(90, 9));
        assertEquals(108, calculator.plus(9, 99));
        assertEquals(-42, calculator.plus(40, -82));
        assertEquals(-42, calculator.plus(-20, -22));
    }

    @Test
    public void testMultiEqualsZero() {
        assertEquals(0, calculator.multi(0, 0));
        assertEquals(0, calculator.multi(1, 0));
        assertEquals(0, calculator.multi(0, 1));
        assertEquals(0, calculator.multi(999, 0));
        assertEquals(0, calculator.multi(0, 999));
        assertEquals(0, calculator.multi(-9, 0));
        assertEquals(0, calculator.multi(0, -78));
    }

    @Test
    public void testMultiWithOne() {
        assertEquals(42, calculator.multi(1, 42));
        assertEquals(49, calculator.multi(49, 1));
        assertEquals(-39, calculator.multi(1, -39));
        assertEquals(-58, calculator.multi(-58, 1));
    }

    @Test
    public void testMulti() {
        assertEquals(25, calculator.multi(5, 5));
        assertEquals(56, calculator.multi(7, 8));
        assertEquals(56, calculator.multi(8, 7));
    }

    @Test
    public void testPowExponentZero() {
        assertEquals(1, calculator.pow(42, 0));
        assertEquals(1, calculator.pow(986, 0));
    }

    @Test
    public void testPowBaseZero() {
        assertEquals(0, calculator.pow(0, 42));
        assertEquals(0, calculator.pow(0, 986));
    }

    @Test
    public void testPowExponentOne() {
        assertEquals(42, calculator.pow(42, 1));
        assertEquals(9756, calculator.pow(9756, 1));
        assertEquals(0, calculator.pow(0, 1));
    }

    @Test
    public void testPowInvalid() {
        assertEquals(-1, calculator.pow(2000000000, 3));
        assertEquals(-1, calculator.pow(-4, 3));
        assertEquals(-1, calculator.pow(8, -2));
    }

    @Test
    public void testPow() {
        assertEquals(74088, calculator.pow(42, 3));
        assertEquals(225, calculator.pow(15, 2));
        assertEquals(32, calculator.pow(2, 5));
        assertEquals(625, calculator.pow(5, 4));
    }

    @Test
    public void testDivResultOne() {
        assertEquals(1, calculator.div(5, 5));
        assertEquals(1, calculator.div(1, 1));
        assertEquals(1, calculator.div(42, 42));    
    }

    @Test
    public void testDivByOne() {
        assertEquals(1, calculator.div(1, 1));
        assertEquals(5, calculator.div(5, 1));
        assertEquals(999, calculator.div(999, 1));    
    }

    @Test
    public void testDivEqualsOne() {
        assertEquals(1, calculator.div(1, 1));    
    }

    @Test
    public void testDivInvalid() {
        assertEquals(-1, calculator.div(13, 4));
        assertEquals(-1, calculator.div(17, 5));
        assertEquals(-1, calculator.div(10, 53));
        assertEquals(-1, calculator.div(20, 30));
        assertEquals(-1, calculator.div(1, 5));
        assertEquals(-1, calculator.div(1, 999));
        assertEquals(-1, calculator.div(53, 5));
        assertEquals(-1, calculator.div(13, 4));
        assertEquals(-1, calculator.div(17, 5));
        assertEquals(-1, calculator.div(10, 53));
        assertEquals(-1, calculator.div(20, 30));
        assertEquals(-1, calculator.div(-9, 7));
        assertEquals(-1, calculator.div(42, -6));
        assertEquals(-1, calculator.div(9, 0));
        assertEquals(-1, calculator.div(42, 0));
    }

    @Test
    public void testDiv() {
        assertEquals(7, calculator.div(49, 7));
        assertEquals(7, calculator.div(42, 6));
    }

    @Test
    public void testModResultEqualsOne() {
        assertEquals(1, calculator.mod(1, 5));
        assertEquals(1, calculator.mod(1, 8));
        assertEquals(1, calculator.mod(7, 3));
    }

    @Test
    public void testModInvalid() {
        assertEquals(-1, calculator.mod(1, 0));
        assertEquals(-1, calculator.mod(34, 0));
        assertEquals(-1, calculator.mod(42, -13));
        assertEquals(-1, calculator.mod(-87, 15));
    }

    @Test
    public void testMod() {
        assertEquals(3, calculator.mod(42, 13));
        assertEquals(12, calculator.mod(87, 15));
        assertEquals(19, calculator.mod(295, 23));
    }
}