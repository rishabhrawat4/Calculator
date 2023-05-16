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
        thrown.expect(Exception.class);
        thrown.expectMessage("line can't be empty");
        Calculator.add("");
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
        Calculator.add("1,2,3,4,5");
    }

    @Test
    public void handleNewLineCharBetweenNumbers() throws Exception {
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void handleNewLineCharAtEnd() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("line can't be empty");
        Calculator.add("1\n");
    }

    @Test
    public void supportDeliminator() throws Exception {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void handleNegativeNumbers() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("negatives not allowed -3, -4,");
        Calculator.add("1,-3\n-4,3");
    }
}
