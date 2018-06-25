package test.by.ryazantseva.handling.action;

import by.ryazantseva.handling.action.SortParagraph;
import by.ryazantseva.handling.chain.TextPartType;
import by.ryazantseva.handling.chain.impl.TextHandler;
import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.DataFileReaderException;
import by.ryazantseva.handling.exception.InvalidInputDataException;
import by.ryazantseva.handling.read.DataFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortParagraphTest {

    @Test
    public void sortParagraphPositiveTest() throws DataFileReaderException, InvalidInputDataException {
        String expected = "    It is a -6000 established fact that a reader will be of a page when looking at its layout.  \n" +
                "    Bye.  \n" +
                "    It has survived - not only (five) centuries, but also the leap into 19 electronic typesetting, remaining 8 essentially -3 unchanged.  It was popularised in the -715 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.  \n" +
                "    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.  The point of using 224 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.  \n";
        DataFileReader dataFileReader = new DataFileReader();
        String text = dataFileReader.readFromFile("files/text.txt");
        TextHandler textHandler = new TextHandler();
        TextComposite composite = textHandler.handleRequest(text);
        SortParagraph sortParagraph = new SortParagraph();
        composite = sortParagraph.sort(composite);
        String actual = composite.toStringComponent();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortParagraphIsNotTextNegativeTest() {
        try {
            SortParagraph sortParagraph = new SortParagraph();
            TextComposite textComposite = new TextComposite(TextPartType.LEXEME);
            sortParagraph.sort(textComposite);
            Assert.fail("Composite is not text");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void sortParagraphIsEmptyNegativeTest() {
        try {
            SortParagraph sortParagraph = new SortParagraph();
            TextComposite textComposite = new TextComposite(TextPartType.TEXT);
            sortParagraph.sort(textComposite);
            Assert.fail("Composite is empty");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }
}
