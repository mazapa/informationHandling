package test.by.ryazantseva.handling.chain;

import by.ryazantseva.handling.chain.impl.TextHandler;
import by.ryazantseva.handling.exception.InvalidInputDataException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TextHandlerTest {
    @Test
    public void TextHandlerNegativeTest() {
        try {
            TextHandler textHandler = new TextHandler();
            textHandler.handleRequest("");
            Assert.fail("File is nonexistent");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }

    }
}
