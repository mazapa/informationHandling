package test.by.ryazantseva.handling.composite;

import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.chain.impl.TextHandler;
import by.ryazantseva.handling.composite.impl.Symbol;
import by.ryazantseva.handling.exception.InvalidInputDataException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SymbolTest {
    @Test
    public void SymbolNegativeTest() {
        try {
            Symbol symbol = new Symbol("hh", TextPartType.SYMBOL);
            Assert.fail("It is not symbol");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }

    }
    @Test
    public void SymbolInvalidTypeNegativeTest() {
        try {
            Symbol symbol = new Symbol("h", TextPartType.LEXEME);
            Assert.fail("It is not symbol");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }
}
