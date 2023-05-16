import static org.junit.Assert.*;

import org.example.calculator.Calculator;
import org.junit.Test;

public class TestCalculator {

    @Test
    public void emptyStringTest() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void stringWithOnlyOneNumber() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void stringWithTwoNumbers() {
        assertEquals(3, Calculator.add("1,2"));
    }
}
