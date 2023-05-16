import static org.junit.Assert.*;

import org.example.calculator.Calculator;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
public class TestCalculator {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void emptyStringTest() throws Exception{
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void stringWithOnlyOneNumber() throws Exception {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void stringWithTwoNumbers() throws Exception{
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void handleMoreThanTwoNumbers() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("String can't contain more than two numbers");
        int sum = Calculator.add("1,2,5");
    }
}
