package test.by.ryazantseva.handling.calculate;

import by.ryazantseva.handling.calculate.ReversePolishNotation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ReversePolishNotationTest {
    @Test
    public void ReversePolishNotationPositiveTest(){
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        String expected = "8";
        String formula ="3+5";
        String actual = String.valueOf(reversePolishNotation.parse(formula));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void ReversePolishNotationNegativeTest(){
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        String expected = "7";
        String formula ="3+10";
        String actual = String.valueOf(reversePolishNotation.parse(formula));
        Assert.assertNotEquals(actual, expected);
    }

}
